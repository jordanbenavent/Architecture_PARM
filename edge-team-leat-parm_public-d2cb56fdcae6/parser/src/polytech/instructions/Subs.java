package polytech.instructions;

import java.util.List;

public class Subs extends Instruction {
    public Subs(String line) {
        super(line);
    }

    @Override
    public String convertToHexa() {
        String binary = getRegister();
        return BinarytoHexa(binary);
    }

    private String getRegister() {
        line = line.substring(5);
        List<String> res = getNumbers(line);
        if (!line.contains("#")) {
            return "0001101" + res.get(2) + res.get(1) + res.get(0);
        } else if (res.size() == 3) {
            return "0001111" + res.get(2) + res.get(1) + res.get(0);
        } else {
            while (res.get(1).length() != 8) res.set(1, "0" + res.get(1));
            return "00111" + res.get(0) + res.get(1);
        }
    }
}
