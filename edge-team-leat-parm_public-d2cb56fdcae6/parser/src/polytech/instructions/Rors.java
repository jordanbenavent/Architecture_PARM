package polytech.instructions;

import java.util.List;

public class Rors extends Instruction {
    public Rors(String line) {
        super(line);
    }

    @Override
    public String convertToHexa() {
        return BinarytoHexa(getRegister());
    }

    private String getRegister() {
        line = line.substring(5);
        List<String> res = getNumbers(line);
        return "0100000111" + res.get(1) + res.get(0);
    }
}
