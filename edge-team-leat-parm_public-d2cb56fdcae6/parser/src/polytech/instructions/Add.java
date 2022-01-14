package polytech.instructions;

public class Add extends Instruction {
    public Add(String line) {
        super(line);
    }

    @Override
    public String convertToHexa() {
        return BinarytoHexa(getRegister());
    }

    protected String getRegister() {
        String res = Integer.toBinaryString(Integer.parseInt(line.substring(line.indexOf("#") + 1)) / 4);
        while (res.length() < 7) res = "0" + res;
        return "101100000" + res;
    }
}
