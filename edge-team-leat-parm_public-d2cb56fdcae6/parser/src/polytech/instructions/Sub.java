package polytech.instructions;

public class Sub extends Instruction {
    public Sub(String line) {
        super(line);
    }

    @Override
    public String convertToHexa() {
        return BinarytoHexa(getRegister());
    }

    private String getRegister() {
        String res = Integer.toBinaryString(Integer.parseInt(line.substring(line.indexOf("#") + 1)) / 4);
        while (res.length() < 7) res = "0" + res;
        return "101100001" + res;
    }
}
