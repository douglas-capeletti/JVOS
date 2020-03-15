package br.com.jvos.instructions.operation.R1Type;

import br.com.jvos.CPU;
import br.com.jvos.instructions.Instruction;

public class STOP extends Instruction {

    public STOP(int[] parameters) {
        super(parameters);
    }

    @Override
    public void doOperation(CPU cpu) {
        System.out.println("STOP");
        cpu.setPC(-1);
    }
}
