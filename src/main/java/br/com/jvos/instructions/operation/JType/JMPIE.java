package br.com.jvos.instructions.operation.JType;

import br.com.jvos.CPU;
import br.com.jvos.instructions.Instruction;

public class JMPIE extends Instruction {

    public JMPIE(int[] parameters) {
        super(parameters);
    }

    @Override
    public void doOperation(CPU cpu) {
        int rc = parameters[1];
        if (cpu.getRegister(rc) == 0) {
            int rs = cpu.getRegister(parameters[0]);
            System.out.println("JMPIE | PC <- " + rs);
            cpu.setPC(rs-1);
        }
    }
}
