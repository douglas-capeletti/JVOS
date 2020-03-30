package br.com.jvos.instructions.operation.IType;

import br.com.jvos.CPU;
import br.com.jvos.instructions.Instruction;

public class LDI extends Instruction {

    public LDI(int[] parameters) {
        super(parameters);
    }

    @Override
    public void doOperation(CPU cpu) {
        int rdIndex = parameters[0];
        int k = parameters[2];
        System.out.println("LDI   | R" + rdIndex + "   <- " + k);
        cpu.setRegister(rdIndex, k);
    }
}
