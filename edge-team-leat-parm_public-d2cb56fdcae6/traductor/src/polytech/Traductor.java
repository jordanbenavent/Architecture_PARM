package polytech;

import polytech.instructions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Traductor {

    private final Path path;
    private final List<Instruction> instructions;
    private List<String> lines;
    private final List<String> fonctions;

    Traductor(String path) {
        this.path = Paths.get(path);
        this.instructions = new ArrayList<>();
        this.fonctions = new ArrayList<>();
    }

    void read() throws IOException {
        List<String> allLines = Files.readAllLines(path);
        lines = allLines.stream().map(String::trim).filter(l -> l.length() > 0 && l.charAt(0) != '.' && l.charAt(0) != '@' && !l.startsWith("run")).toList();
        //String source = null;
        HashMap<String, Integer> branch = new HashMap<>();
        int com = 0, c;
        for (String allLine : allLines) {
            if (allLine.length() > 0) {
                if (allLine.charAt(0) == '.') {
                    branch.put(allLine.substring(0, allLine.length() - 1), com);
                    //System.out.println(allLine.substring(0, allLine.length() - 1) + " "+com);
                } else {
                    allLine = allLine.trim();
                    if (allLine.charAt(0) != '.' && allLine.charAt(0) != '@' && !allLine.startsWith("run")) {
                        com++;
                    }
                }
            }
        }
        com = 0;
        for (String line : lines) {
            //line = line.trim();
            if (line.startsWith("b")) {
                String name = line.substring(line.indexOf("."));
                //System.out.println(name);
                c = branch.get(name);
                fonctions.add(line.substring(0, line.indexOf(".") - 1) + "," + (c - com - 3));
                //System.out.println(name + " " + c + " " + com);
                /*for (int i = 0; i < allLines.size(); i++) {
                    if (c == 0) {
                        if (allLines.get(i).startsWith(name)) {
                            System.out.println(allLines.get(i + 1));
                            for (int k = 0; k < lines.size(); k++) {
                                if (lines.get(k).equals(allLines.get(i + 1).trim())) {
                                    c = k;
                                    //System.out.println("c find " + lines.get(k));
                                    break;
                                }
                            }
                        }
                    } else {
                        s = lines.indexOf(line);
                        System.out.println("c " + c + " s " + s);
                        fonctions.add(line.substring(0, line.indexOf(".") - 1) + "," + (c - s - 3));
                        break;
                    }
                }*/
            } else {
                fonctions.add(line);
            }
            com++;
        }

        System.out.println(fonctions.toString());
    }

    void keepKnownInstruction() {
        List<String> conditions = new ArrayList<>(
                Arrays.asList("beq", "bne", "bcs", "bhs", "bcc", "blo", "bmi",
                        "bpl", "bvs", "bvc", "bhi", "bls", "bge", "blt", "bgt",
                        "ble", "bal"));
        for (String line : fonctions) {
            if (line.startsWith("subs")) {
                instructions.add(new Subs(line));
            } else if (line.startsWith("sub")) {
                instructions.add(new Sub(line));
            } else if (line.startsWith("movs")) {
                instructions.add(new Movs(line));
            } else if (line.startsWith("str")) {
                instructions.add(new Str(line));
            } else if (line.startsWith("ldr")) {
                instructions.add(new Ldr(line));
            } else if (line.startsWith("adds")) {
                instructions.add(new Adds(line));
            } else if (line.startsWith("cmp")) {
                instructions.add(new Cmp(line));
            } else if (line.startsWith("orrs")) {
                instructions.add(new Orrs(line));
            } else if (line.startsWith("eors")) {
                instructions.add(new Eors(line));
            } else if (line.startsWith("rsbs")) {
                instructions.add(new Rsbs(line));
            } else if (line.startsWith("ands")) {
                instructions.add(new Ands(line));
            } else if (line.startsWith("muls")) {
                instructions.add(new Muls(line));
            } else if (line.startsWith("lsrs")) {
                instructions.add(new Lsrs(line));
            } else if (line.startsWith("lsls")) {
                instructions.add(new Lsls(line));
            } else if (conditions.stream().anyMatch(line::startsWith)) {
                instructions.add(new ConditionnalBranch(line));
            } else if (line.startsWith("b")) {
                instructions.add(new UnconditionnalBranch(line));
            }
        }
    }

    void displaySfile() {
        for (Instruction instruction : instructions) {
            System.out.println(instruction.getLine());
        }
    }

    void displayBinFile() {
        for (Instruction instruction : instructions) {
            System.out.print(instruction.convertToHexa() + " ");
            //System.out.print(instruction.convertToHexa() + " ");
        }
    }
}
