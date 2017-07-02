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

public class YmlTest {

    private static int testNumber = 0;

    private static final String SEMANTIC_ERRORS = "semantic errors";
    private static final String CODEGEN_ERRORS = "code generation errors";

    // Colors to print fancy stuff
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";

    public static void main(String[] args) throws Exception {
        String fileName = "fool_tests.yml";

        HashMap<String, ArrayList<String>> testFile = loadYmlFromFile(fileName);

        testNumber = 0;
        int testsPassed = 0;
        String foolCode, expectedResult;

        for (String key : testFile.keySet()) {
            System.out.printf("%sTest #%d '%s'%s\n", ANSI_BLUE, testNumber + 1, key, ANSI_RESET);
            foolCode = testFile.get(key).get(0);
            expectedResult = testFile.get(key).get(1);

            String result = codeTest(key, foolCode);

            if (expectedResult.equals(result)) {
                testsPassed++;
            } else {
                System.out.printf("%sTest failed due to %s%s%s%n", ANSI_BLUE, ANSI_YELLOW, result, ANSI_RESET);
            }

            System.out.println();
            testNumber++;
        }

        if (testNumber == testsPassed) {
            System.out.printf("%sAll %d tests passed, you must be proud.%s\n", ANSI_GREEN, testNumber, ANSI_RESET);
        } else {
            System.out.printf("%s%d/%d tests passed, you are a failure.%s%n", ANSI_RED, testsPassed, testNumber, ANSI_RESET);
        }
    }

    public static HashMap<String, ArrayList<String>> loadYmlFromFile(String fileName) throws IOException {
        InputStream input = new FileInputStream(new File(fileName));
        Yaml yaml = new Yaml();

        // close your eyes and trust me
        return (HashMap<String, ArrayList<String>>) yaml.load(input);
    }

    public static String codeTest(String testName, String foolCode) throws Exception {

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
                System.out.println(err.size() + " errors found:");
                for (SemanticError e : err)
                    System.out.println("\t" + e);

                return SEMANTIC_ERRORS;
            } else {

                System.out.println("Visualizing AST...");
                System.out.println(ast.toPrint(""));

                Node type = ast.typeCheck(); //type-checking bottom-up
                System.out.println(type.toPrint("Type checking passed! Type of the program is: "));


                // CODE GENERATION
                String asmFileName = "tests_asm/test" + (testNumber + 1) + ".asm";

                String code = ast.codeGeneration();

                if (code == null) {
                    System.out.printf("Failed to generate code for '%s'%n", testName);
                    return CODEGEN_ERRORS;
                }

                BufferedWriter out = new BufferedWriter(new FileWriter(new File(asmFileName)));
                out.write(code);
                out.close();
                //System.out.println("Code generated! Assembling and running generated code.");

                FileInputStream isASM = new FileInputStream(asmFileName);
                ANTLRInputStream inputASM = new ANTLRInputStream(isASM);
                SVMLexer lexerASM = new SVMLexer(inputASM);
                CommonTokenStream tokensASM = new CommonTokenStream(lexerASM);
                SVMParser parserASM = new SVMParser(tokensASM);

                parserASM.assembly();

                //System.out.println("You had: " + lexerASM.lexicalErrors + " lexical errors and " + parserASM.getNumberOfSyntaxErrors() + " syntax errors.");
                //if (lexerASM.lexicalErrors > 0 || parserASM.getNumberOfSyntaxErrors() > 0) System.exit(1);

                //System.out.println("Starting Virtual Machine...");
                ExecuteVM vm = new ExecuteVM(parserASM.code);
                vm.cpu();
            }
        }
        return "";
    }
}
