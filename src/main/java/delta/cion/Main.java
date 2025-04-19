package delta.cion;

import java.io.File;
import java.util.Objects;

public class Main {

    public native void dc();

    public native void vivo();

    static {
        File d = new File("D:/Desktop/Violette_Project/jaba/ConsoleTests/src/main/java/delta/cion/dll/");
        for (File f : Objects.requireNonNull(d.listFiles())) {
            System.load(f.getAbsolutePath());
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.dc();
        main.vivo();
    }
}