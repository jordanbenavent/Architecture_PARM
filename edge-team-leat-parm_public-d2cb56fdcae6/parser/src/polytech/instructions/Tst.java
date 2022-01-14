package polytech.instructions;

import java.util.List;

public class Tst extends Instruction {
    public Tst(String line) {
        super(line);
    }

    @Override
    public String convertToHexa() {
        return BinarytoHexa(getRegister());
    }

    private String getRegister() {
        line = line.substring(4);
        List<String> res = getNumbers(line);
        return "0100001000" + res.get(1) + res.get(0);
    }
}
