package polytech.instructions;

import java.util.List;

public class Sbcs extends Instruction {
    public Sbcs(String line) {
        super(line);
    }

    @Override
    public String convertToHexa() {
        return BinarytoHexa(getRegister());
    }

    private String getRegister() {
        line = line.substring(5);
        List<String> res = getNumbers(line);
        return "0100000110" + res.get(1) + res.get(0);
    }
}
