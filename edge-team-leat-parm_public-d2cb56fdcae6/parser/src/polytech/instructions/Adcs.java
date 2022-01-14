package polytech.instructions;

import java.util.List;

public class Adcs extends Instruction {
    public Adcs(String line) {
        super(line);
    }

    @Override
    public String convertToHexa() {
        return BinarytoHexa(getRegister());
    }

    protected String getRegister() {
        line = line.substring(5);
        List<String> res = getNumbers(line);
        return "0100000101" + res.get(1) + res.get(0);
    }
}
