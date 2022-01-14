package polytech.instructions;

import java.util.List;

public class Orrs extends Instruction {
    public Orrs(String line) {
        super(line);
    }

    @Override
    public String convertToHexa() {
        return BinarytoHexa(getRegister());
    }

    private String getRegister() {
        line = line.substring(5);
        List<String> res = getNumbers(line);
        return "0100001100" + res.get(1) + res.get(0);
    }
}
