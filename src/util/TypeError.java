package util;

/**
 * Created by Cristiano Piemontese on 08/07/2017.
 */
public class TypeError {
    public final String msg;

    public TypeError(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
