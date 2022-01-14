package polytech.instructions;

import java.util.List;

public class Cmn extends Instruction {
    public Cmn(String line) {
        super(line);
    }

    @Override
    public String convertToHexa() {
        String binary = getRegister();
        return BinarytoHexa(binary);
    }

    protected String getRegister() {
        line = line.substring(4);
        List<String> res = getNumbers(line);
        return "0100001011" + res.get(1) + res.get(0);
    }
}
