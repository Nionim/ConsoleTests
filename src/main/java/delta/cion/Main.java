package delta.cion;

public class Main {

    public native void dc();

    static {
        System.loadLibrary("console_tests");
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.dc();
    }
}