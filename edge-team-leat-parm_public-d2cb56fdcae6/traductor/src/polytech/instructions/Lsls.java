package polytech.instructions;

import java.util.List;

public class Lsls extends Instruction {
    public Lsls(String line) {
        super(line);
    }

    @Override
    public String convertToHexa() {
        String binary = BinarytoHexa(getRegister());
        while (binary.length() < 4) binary = "0" + binary;
        return binary;
    }

    private String getRegister() {
        line = line.substring(5);
        List<String> res = getNumbers(line);
        if (line.contains("#")) {
            while (res.get(2).length() < 5) res.set(2, "0" + res.get(2));
            return "00000" + res.get(2) + res.get(1) + res.get(0);
        } else {
            return "0100000010" + res.get(1) + res.get(0);
        }
    }
}