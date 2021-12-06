package polytech.instructions;

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
}
