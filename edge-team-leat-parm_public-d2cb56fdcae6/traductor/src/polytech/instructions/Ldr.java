package polytech.instructions;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Ldr extends Instruction {
    public Ldr(String line) {
        super(line);
        infos = Arrays.asList(9);
    }

    @Override
    public String convertToHexa() {
        return infos.stream()
                .map(Integer::toHexString)
                .collect(Collectors.joining())
                + Integer.toHexString(getRegister() + 8)
                + (getNumber() < 64 ? "0" : "")
                + Integer.toHexString(getNumber() / 4);
    }

    private int getRegister() {
        return Integer.parseInt(line.substring(line.indexOf("r", 3) + 1, line.indexOf(",")));
    }

    private int getNumber() {
        return line.contains("#") ? Integer.parseInt(line.substring(line.indexOf("#") + 1, line.indexOf("]"))) : 0;
    }
}
