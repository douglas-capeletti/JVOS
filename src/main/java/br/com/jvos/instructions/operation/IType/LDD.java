package br.com.jvos.instructions.operation.IType;

import br.com.jvos.CPU;
import br.com.jvos.instructions.Instruction;

public class LDD extends Instruction {

    public LDD(int[] parameters) {
        super(parameters);
    }

    @Override
    public void doOperation(CPU cpu) {
        int rdIndex = parameters[0];
        int a = cpu.getMemoryRow(parameters[2]);
        System.out.println("LDD   | R" + rdIndex + "   <- [" + a + "]");
        cpu.setRegister(rdIndex, a);
    }
}
