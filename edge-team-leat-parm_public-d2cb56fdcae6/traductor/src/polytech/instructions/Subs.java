package polytech.instructions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subs extends Instruction {
    public Subs(String line) {
        super(line);
        infos = Arrays.asList(1);
    }

    @Override
    public String convertToHexa() {
        //String base = "0001101";
        String binary = getRegister();
        //System.out.println(binary);
        //System.out.println(BinarytoHexa(binary));
        return BinarytoHexa(binary);
    }

    private String getRegister() {
        line = line.substring(5);
        List<String> res = getNumbers(line);
        //System.out.println("res " + res);
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
