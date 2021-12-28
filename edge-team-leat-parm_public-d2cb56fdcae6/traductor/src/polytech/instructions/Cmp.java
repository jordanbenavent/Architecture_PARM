package polytech.instructions;

import java.util.List;

public class Cmp extends Instruction {
    public Cmp(String line) {
        super(line);
        infos = List.of(1);
    }

    @Override
    public String convertToHexa() {
        String binary = getRegister();
        return BinarytoHexa(binary);
    }

    private String getRegister() {
        line = line.substring(4);
        List<String> res = getNumbers(line);
        //System.out.println("res " + res);
        if (line.contains("#")) {
            while (res.get(1).length() != 8) res.set(1, "0" + res.get(1));
            return "00101" + res.get(0) + res.get(1);
        } else {
            return "0100001010" + res.get(1) + res.get(0);
        }
    }
}
