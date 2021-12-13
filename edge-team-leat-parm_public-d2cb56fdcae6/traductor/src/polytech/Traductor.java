package polytech;

import polytech.instructions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Traductor {

    private final Path path;
    private final List<Instruction> instructions;
    private List<String> lines;
    private HashMap<String, List<String>> fonctions;

    Traductor(String path) {
        this.path = Paths.get(path);
        this.instructions = new ArrayList<>();
    }

    void read() throws IOException {
        lines = Files.readAllLines(path);
        String name = null;
        for (String line : lines) {
            if (line.startsWith("run")) {
                name = "run";
                fonctions.put(name, new ArrayList<>());
            } else if (line.startsWith(".LBB0_")) {
                name = line.substring(0, line.indexOf(":"));
                fonctions.put(name, new ArrayList<>());
            } else if(name != null){
                fonctions.get(name).add(line);
            }
        }
        lines = Files.readAllLines(path).stream().map(String::trim).filter(l -> l.length() > 0 && l.charAt(0) != '.').toList();
    }

    void keepKnownInstruction() {
        for (String line : lines) {
            if (line.startsWith("sub")) {
                instructions.add(new Sub(line));
            } else if (line.startsWith("movs")) {
                instructions.add(new Movs(line));
            }else if (line.startsWith("str")) {
                    instructions.add(new Str(line));
            }else if (line.startsWith("ldr")) {
                instructions.add(new Ldr(line));
            } else if (line.startsWith("adds")) {
                instructions.add(new Adds(line));
            } else if (line.startsWith("b")) {
                zsaqzsefbujkoi

            }
        }
    }

    void displaySfile(boolean know) {
        if (know) {
            for (Instruction instruction : instructions) {
                System.out.println(instruction.getLine());
            }
        } else {
            System.out.println(lines);
        }
    }

    void displayBinFile() {
        for (Instruction instruction : instructions) {
            System.out.print(instruction.convertToHexa() + " ");
        }
    }
}
