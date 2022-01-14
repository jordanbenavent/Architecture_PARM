package polytech;

import polytech.instructions.*;
import polytech.instructions.Lsls;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Parser {

    private final Path path;
    private final List<Instruction> instructions;
    private final List<String> fonctions;

    Parser(String path) {
        this.path = Paths.get(path);
        this.instructions = new ArrayList<>();
        this.fonctions = new ArrayList<>();
    }

    void read() throws IOException {
        List<String> allLines = Files.readAllLines(path);
        List<String> lines = allLines.stream().map(String::trim).filter(l -> l.length() > 0 && l.charAt(0) != '.' && l.charAt(0) != '@' && !l.startsWith("run")).toList();
        HashMap<String, Integer> branch = new HashMap<>();
        int com = 0, c;
        for (String allLine : allLines) {
            if (allLine.length() > 0) {
                if (allLine.charAt(0) == '.') {
                    branch.put(allLine.substring(0, allLine.length() - 1), com);
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
            if (line.startsWith("b") && !line.startsWith("bics")) {
                String name = line.substring(line.indexOf("."));
                c = branch.get(name);
                fonctions.add(line.substring(0, line.indexOf(".") - 1) + "," + (c - com - 3));
            } else {
                fonctions.add(line);
            }
            com++;
        }
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
            } else if (line.startsWith("cmn")) {
                instructions.add(new Cmn(line));
            } else if (line.startsWith("bics")) {
                instructions.add(new Bics(line));
            } else if (line.startsWith("mvns")) {
                instructions.add(new Mvns(line));
            } else if (line.startsWith("asrs")) {
                instructions.add(new Asrs(line));
            } else if (line.startsWith("adcs")) {
                instructions.add(new Adcs(line));
            } else if (line.startsWith("sbcs")) {
                instructions.add(new Sbcs(line));
            } else if (line.startsWith("rors")) {
                instructions.add(new Rors(line));
            } else if (line.startsWith("movs")) {
                instructions.add(new Movs(line));
            } else if (line.startsWith("tst")) {
                instructions.add(new Tst(line));
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
            } else if (line.startsWith("add")) {
                instructions.add(new Add(line));
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
        }
    }
}
