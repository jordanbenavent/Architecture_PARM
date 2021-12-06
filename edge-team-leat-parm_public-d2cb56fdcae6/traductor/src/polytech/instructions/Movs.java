package polytech.instructions;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Movs extends Instruction {
    public Movs(String line) {
        super(line);
        infos = Arrays.asList(2, 0);
    }

    @Override
    public String convertToHexa() {
        return infos.stream()
                .map(Integer::toHexString)
                .collect(Collectors.joining())
                + getRegister()
                + Integer.toHexString(getNumber());
    }

    private int getRegister() {
        return Integer.parseInt(line.substring(line.indexOf("r") + 1, line.indexOf(",")));
    }

    private int getNumber() {
        return Integer.parseInt(line.substring(line.indexOf("#") + 1));
    }
}
