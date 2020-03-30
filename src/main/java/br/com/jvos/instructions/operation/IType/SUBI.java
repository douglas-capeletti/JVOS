package br.com.jvos.instructions.operation.IType;

import br.com.jvos.CPU;
import br.com.jvos.instructions.Instruction;

public class SUBI extends Instruction {

    public SUBI(int[] parameters) {
        super(parameters);
    }

    @Override
    public void doOperation(CPU cpu) {
        int rdIndex = parameters[0];
        int rd = cpu.getRegister(rdIndex);
        int k = parameters[2];
        System.out.println("SUBI  | R" + rdIndex + "   <- " + rd + " - " + k);
        cpu.setRegister(rdIndex, rd - k);
    }
}
