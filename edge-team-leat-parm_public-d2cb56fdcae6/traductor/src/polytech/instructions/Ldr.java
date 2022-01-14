package polytech.instructions;

import java.util.Arrays;

public class Ldr extends Instruction {
    public Ldr(String line) {
        super(line);
        infos = Arrays.asList(9);
    }

    @Override
    public String convertToHexa() {
        return BinarytoHexa("10011" + getRegister() + getNumber());
    }

    private String getRegister() {
        String res = line.substring(line.indexOf("r", 3) + 1, line.indexOf(","));
        res = Integer.toBinaryString(Integer.parseInt(res));
        while (res.length() != 3) res = "0" + res;
        return res;
    }

    private String getNumber() {
        int resInteger = line.contains("#") ? Integer.parseInt(line.substring(line.indexOf("#") + 1, line.indexOf("]"))) : 0;
        resInteger = resInteger / 4;
        String resString = Integer.toBinaryString(resInteger);
        while (resString.length() != 8) resString = "0" + resString;
        return resString;
    }
}
