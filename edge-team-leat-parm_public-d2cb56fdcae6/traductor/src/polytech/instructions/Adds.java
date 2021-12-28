package polytech.instructions;

import java.util.List;
import java.util.stream.Collectors;

public class Adds extends Instruction {
    public Adds(String line) {
        super(line);
        infos = List.of(1);
    }

    @Override
    public String convertToHexa() {
        String binary = getRegister();
        return BinarytoHexa(binary);
    }

    private String getRegister() {
        line = line.substring(5);
        List<String> res = getNumbers(line);
        //System.out.println("res " + res);
        if (!line.contains("#")) {
            return "0001100" + res.get(2) + res.get(1) + res.get(0);
        } else if (res.size() == 3) {
            return "0001110" + res.get(2) + res.get(1) + res.get(0);
        } else {
            while (res.get(1).length() != 8) res.set(1, "0" + res.get(1));
            return "00110" + res.get(0) + res.get(1);
        }
    }
}
