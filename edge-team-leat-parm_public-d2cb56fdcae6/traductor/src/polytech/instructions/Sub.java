package polytech.instructions;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Sub extends Instruction {
    public Sub(String line) {
        super(line);
        infos = Arrays.asList(11, 0);
    }

    @Override
    public String convertToHexa() {
        return infos.stream()
                .map(Integer::toHexString)
                .collect(Collectors.joining())
                + Integer.toHexString(getNumber() / 4 + 128);
    }

    private int getNumber() {
        return Integer.parseInt(line.substring(line.indexOf("#") + 1));
    }
}
