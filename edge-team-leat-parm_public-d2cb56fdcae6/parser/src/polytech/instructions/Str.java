package polytech.instructions;

public class Str extends Instruction {
    public Str(String line) {
        super(line);
    }

    @Override
    public String convertToHexa() {
        return BinarytoHexa("10010" + getRegister() + getNumber());
    }

    private String getRegister() {
        String res = Integer.toBinaryString(Integer.parseInt(line.substring(line.indexOf("r", 3) + 1, line.indexOf(","))));
        while (res.length() < 3) res = '0' + res;
        return res;
    }

    private String getNumber() {
        if (line.contains("#")) {
            String res = Integer.toBinaryString(Integer.parseInt(line.substring(line.indexOf("#") + 1, line.indexOf("]"))) / 4);
            while (res.length() < 8) res = '0' + res;
            return res;
        } else {
            return "00000000";
        }
    }
}
