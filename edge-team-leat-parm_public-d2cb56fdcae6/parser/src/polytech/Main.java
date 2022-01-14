package polytech;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\matth\\OneDrive\\Documents\\Architecture_PARM\\edge-team-leat-parm_public-d2cb56fdcae6\\code_c\\code2.s";
        path = path.replace("\\", "/");
        Parser parser = new Parser(path);
        parser.read();
        parser.keepKnownInstruction();
        parser.displayBinFile();
    }
}
