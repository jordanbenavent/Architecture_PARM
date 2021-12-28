package polytech.instructions;

import java.util.List;

public class UnconditionnalBranch extends Instruction {
    public UnconditionnalBranch(String line) {
        super(line);
        infos = List.of(14);
    }

    @Override
    public String convertToHexa() {
        return BinarytoHexa("11100" + imm11());
    }

    private String imm11() {
        int number = Integer.parseInt(line.substring(2));
        String binary = TwoComplement(number);
        while (binary.length() < 11) binary = "0" + binary;
        return binary;
    }

    private String TwoComplement(int number) {
        String binary = Integer.toBinaryString(number);
        if (number >= 0) return binary;
        return binary.substring(binary.length() - 11);
    }
}
