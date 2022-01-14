package polytech.instructions;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConditionnalBranch extends Instruction {
    public ConditionnalBranch(String line) {
        super(line);
    }

    @Override
    public String convertToHexa() {
        return BinarytoHexa("1101" + cond() + imm8());
    }

    private String cond() {
        String cond = line.substring(1, 3);
        Map<String, String> conditions = Stream.of(new Object[][]{
                {"eq", "0000"}, {"ne", "0001"}, {"cs", "0010"}, {"hs", "0010"}, {"cc", "0011"},
                {"lo", "0011"}, {"mi", "0100"}, {"pl", "0101"}, {"vs", "0110"}, {"vc", "0111"},
                {"hi", "1000"}, {"ls", "1001"}, {"ge", "1010"}, {"lt", "1011"}, {"gt", "1100"},
                {"le", "1101"}, {"al", "1110"}}).collect(Collectors.toMap(data -> (String) data[0], data -> (String) data[1]));
        String binary = String.valueOf(conditions.get(cond));
        while (binary.length() < 4) binary = "0" + binary;
        return binary;
    }

    private String imm8() {
        int number = Integer.parseInt(line.substring(4));
        String binary = TwoComplement(number);
        while (binary.length() < 8) binary = "0" + binary;
        return binary;
    }

    private String TwoComplement(int number) {
        String binary = Integer.toBinaryString(number);
        if (number >= 0) return binary;
        return binary.substring(binary.length() - 8);
    }
}
