package br.com.jvos.instructions.operation.R2Type;

import br.com.jvos.CPU;
import br.com.jvos.instructions.Instruction;

public class STX extends Instruction {

    public STX(int[] parameters) {
        super(parameters);
    }

    @Override
    public void doOperation(CPU cpu) {
        int rsIndex = parameters[1];
        int rs = cpu.getRegister(rsIndex);
        int rdIndex = parameters[0];
        int a = cpu.getMemoryRow(rsIndex);
        System.out.println("LDX   | [" + rdIndex + "] <- R" + rsIndex + "");
        cpu.setMemoryRow(rdIndex, rs);
    }
}
