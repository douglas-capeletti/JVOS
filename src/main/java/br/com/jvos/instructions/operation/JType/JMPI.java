package br.com.jvos.instructions.operation.JType;

import br.com.jvos.CPU;
import br.com.jvos.instructions.Instruction;

public class JMPI extends Instruction {

    public JMPI(int[] parameters) {
        super(parameters);
    }

    @Override
    public void doOperation(CPU cpu) {
        int rs = cpu.getRegister(parameters[0]);
        System.out.println("JMPI  | PC <- " + rs);
        cpu.setPC(rs-1);
    }
}
