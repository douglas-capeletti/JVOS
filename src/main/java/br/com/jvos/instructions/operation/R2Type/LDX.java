package br.com.jvos.instructions.operation.R2Type;

import br.com.jvos.CPU;
import br.com.jvos.instructions.Instruction;

public class LDX extends Instruction {

    public LDX(int[] parameters) {
        super(parameters);
    }

    @Override
    public void doOperation(CPU cpu) {
        int rdIndex = parameters[0];
        int rsIndex = parameters[1];
        int a = cpu.getMemoryRow(rsIndex);
        System.out.println("LDX   | R" + rdIndex + " <- [" + rsIndex + "]");
        cpu.setRegister(rdIndex, a);
    }
}
