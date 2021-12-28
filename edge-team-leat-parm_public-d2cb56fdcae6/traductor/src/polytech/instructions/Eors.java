package polytech.instructions;

import java.util.List;

public class Eors extends Instruction {
    public Eors(String line) {
        super(line);
    }

    @Override
    public String convertToHexa() {
        return BinarytoHexa(getRegister());
    }

    private String getRegister() {
        line = line.substring(5);
        List<String> res = getNumbers(line);
        return "0100000001" + res.get(1) + res.get(0);
    }
}
