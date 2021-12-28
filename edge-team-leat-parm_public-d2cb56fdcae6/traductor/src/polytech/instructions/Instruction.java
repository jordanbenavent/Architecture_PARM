package polytech.instructions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public abstract class Instruction {
    protected String line;
    protected List<Integer> infos;

    Instruction(String line){
        this.line = line;
    }

    public abstract  String convertToHexa();
    public String getLine(){
        return line;
    }

    protected List<String> getNumbers(String l){
        List<String> res = new ArrayList<>();
        for (String number : line.split(", ")) {
            number = Integer.toBinaryString(Integer.parseInt(number.substring(1)));
            while (number.length() < 3) number = "0" + number;
            res.add(number);
        }
        return res;
    }

    protected String BinarytoHexa(String binaryString) {
        return new BigInteger(binaryString, 2).toString(16);
    }
}
