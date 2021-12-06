package polytech.instructions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Adds extends Instruction {
    public Adds(String line) {
        super(line);
        infos = List.of(1);
    }

    @Override
    public String convertToHexa() {
        return infos.stream()
                .map(Integer::toHexString)
                .collect(Collectors.joining())
                + Integer.toHexString(2048 +
                getRegister(2) * 64 +
                getRegister(1) * 8 +
                getRegister(0));
    }

    private int getRegister(int r) {
        if (r == 2) {
            return Integer.parseInt(line.substring(line.indexOf("r", 5 + 4 * r) + 1));
        } else {
            return Integer.parseInt(line.substring(line.indexOf("r", 4 + 4 * r) + 1, line.indexOf(",", 4 + 4 * r)));
        }
    }
}
