package polytech.instructions;

import java.util.List;

public class Asrs extends Instruction {
    public Asrs(String line) {
        super(line);
    }

    @Override
    public String convertToHexa() {
        String binary = getRegister();
        return BinarytoHexa(binary);
    }

    protected String getRegister() {
        line = line.substring(5);
        List<String> res = getNumbers(line);
        if (!line.contains("#")) {
            return "0100000100" + res.get(1) + res.get(0);
        } else {
            while (res.get(2).length() < 5) res.set(2, "0" + res.get(2));
            return "00010" + res.get(2) + res.get(1) + res.get(0);
        }
    }
}
