/**
 * Created by Cristiano Piemontese on 30/06/2017.
 */

import ast.FOOLVisitorImpl;
import ast.Node;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.yaml.snakeyaml.Yaml;
import parser.*;
import util.Environment;
import util.SemanticError;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class YmlTests {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) throws Exception {
        String fileName = "src/fool_tests.yml";

        HashMap<String, ArrayList<String>> testFile = loadYmlFromFile(fileName);

        int testCount = 1;
        String foolCode, expectedResult;

        for (String key : testFile.keySet()) {
            System.out.printf(ANSI_BLUE + "Test #%d: '%s'\n" + ANSI_RESET, testCount, key);
            foolCode = testFile.get(key).get(0);
            expectedResult = testFile.get(key).get(1);

            String result = foolCodeMagic(fileName, foolCode);

            if (expectedResult.equals(result))
                System.out.println(ANSI_GREEN + " all tests passed!" + ANSI_RESET);
        }
    }

    public static HashMap<String, ArrayList<String>> loadYmlFromFile(String fileName) throws IOException {
        InputStream input = new FileInputStream(new File(fileName));
        Yaml yaml = new Yaml();

        // close your eyes and trust me
        return (HashMap<String, ArrayList<String>>) yaml.load(input);
    }

    // TODO: rename this function
    public static String foolCodeMagic(String fileName, String foolCode) throws Exception {
        ANTLRInputStream input = new ANTLRInputStream(foolCode);
        FOOLLexer lexer = new FOOLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        if (lexer.lexicalErrors > 0) {
            System.err.println("Lexical errors found. Exiting now.");
        } else {
            FOOLParser parser = new FOOLParser(tokens);
            FOOLVisitorImpl visitor = new FOOLVisitorImpl();

            Node ast = visitor.visit(parser.prog());

            Environment env = new Environment();
            ArrayList<SemanticError> err = ast.checkSemantics(env);

            if (err.size() > 0) {
                System.out.println(+ err.size() + " errors found:");
                for (SemanticError e : err)
                    System.out.println("\t" + e);
            } else {


                System.out.println("Visualizing AST...");
                System.out.println(ast.toPrint(""));

                Node type = ast.typeCheck(); //type-checking bottom-up
                System.out.println(type.toPrint("Type checking passed! Type of the program is: "));


                // CODE GENERATION  prova.fool.asm
                String code = ast.codeGeneration();
                BufferedWriter out = new BufferedWriter(new FileWriter(fileName + ".asm"));
                out.write(code);
                out.close();
                System.out.println("Code generated! Assembling and running generated code.");

                FileInputStream isASM = new FileInputStream(fileName + ".asm");
                ANTLRInputStream inputASM = new ANTLRInputStream(isASM);
                SVMLexer lexerASM = new SVMLexer(inputASM);
                CommonTokenStream tokensASM = new CommonTokenStream(lexerASM);
                SVMParser parserASM = new SVMParser(tokensASM);

                parserASM.assembly();

                System.out.println("You had: " + lexerASM.lexicalErrors + " lexical errors and " + parserASM.getNumberOfSyntaxErrors() + " syntax errors.");
                if (lexerASM.lexicalErrors > 0 || parserASM.getNumberOfSyntaxErrors() > 0) System.exit(1);

                System.out.println("Starting Virtual Machine...");
                ExecuteVM vm = new ExecuteVM(parserASM.code);
                vm.cpu();
            }
        }
        return "";
    }
}
