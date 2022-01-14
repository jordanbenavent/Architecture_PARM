package polytech.instructions;

import java.util.List;

public class Bics extends Instruction {
    public Bics(String line) {
        super(line);
    }

    @Override
    public String convertToHexa() {
        return BinarytoHexa(getRegister());
    }

    protected String getRegister() {
        line = line.substring(5);
        List<String> res = getNumbers(line);
        return "0100001110" + res.get(1) + res.get(0);
    }
}