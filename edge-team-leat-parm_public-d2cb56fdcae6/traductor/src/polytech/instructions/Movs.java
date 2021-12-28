package polytech.instructions;

import java.util.Arrays;
import java.util.List;

public class Movs extends Instruction {
    public Movs(String line) {
        super(line);
        infos = Arrays.asList(2);
    }

    @Override
    public String convertToHexa() {
        String binary = getRegister();
        binary = BinarytoHexa(binary);
        while (binary.length() < 4) binary = "0" + binary;
        return binary;
    }

    private String getRegister() {
        line = line.substring(5);
        List<String> res = getNumbers(line);
        if (line.contains("#")) {
            while (res.get(1).length() != 8) res.set(1, "0" + res.get(1));
            return "00100" + res.get(0) + res.get(1);
        } else {
            return "000000000" + res.get(1) + res.get(0);
            //return "0100000010" + res.get(1) + res.get(0);
        }
    }
}
