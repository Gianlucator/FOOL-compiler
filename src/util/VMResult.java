package util;

/**
 * Created by Cristiano Piemontese on 02/07/2017.
 */
public class VMResult {
    public static final int EMPTY_STACK = 0;
    public static final int OK = 1;

    private int result;
    private int message;

    public VMResult(int res, int msg) {
        result = res;
        message = msg;
    }

    public int getResult() {
        return result;
    }

    public String getMessage() {
        String msg = "";

        switch (message) {
            case EMPTY_STACK:
                msg = "empty stack at the end";
                break;
            case OK:
                msg = "successful execution";
                break;
        }

        return msg;
    }

    public boolean executionFailed() {
        return message != OK;
    }
}
