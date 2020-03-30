package br.com.jvos.instructions.operation.IType;

import br.com.jvos.CPU;
import br.com.jvos.instructions.Instruction;

public class STD extends Instruction {

    public STD(int[] parameters) {
        super(parameters);
    }

    @Override
    public void doOperation(CPU cpu) {
        int rsIndex = parameters[0];
        int rs = cpu.getRegister(rsIndex);
        int a = parameters[2];
        System.out.println("STD   | [" + a + "] <- R" + rsIndex);
        cpu.setMemoryRow(a, rs);
    }
}
