package polytech.instructions;

import java.util.List;

public class Muls extends Instruction {
    public Muls(String line) {
        super(line);
    }

    @Override
    public String convertToHexa() {
        return BinarytoHexa(getRegister());
    }

    private String getRegister() {
        line = line.substring(5);
        List<String> res = getNumbers(line);
        return "0100001101" + res.get(1) + res.get(0);
    }
}
