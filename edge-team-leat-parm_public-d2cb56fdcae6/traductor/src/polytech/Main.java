package polytech;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\matth\\OneDrive\\Documents\\Architecture_PARM\\edge-team-leat-parm_public-d2cb56fdcae6\\code_c\\simple_add.s";
        path = path.replace("\\", "/");
        Traductor traductor = new Traductor(path);
        traductor.read();
        traductor.keepKnownInstruction();
        traductor.displaySfile(true);
        System.out.println();
        traductor.displayBinFile();
    }
}
