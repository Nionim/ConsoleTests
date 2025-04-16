package delta.cion;

public class Main {

    public native void dc();

    static {
        System.load("D:/Desktop/Violette_Project/jaba/ConsoleTests/src/main/java/delta/cion/c/console_tests.dll");
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.dc();
    }
}