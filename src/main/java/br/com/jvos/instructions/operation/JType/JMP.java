package br.com.jvos.instructions.operation.JType;

import br.com.jvos.CPU;
import br.com.jvos.instructions.Instruction;

public class JMP extends Instruction {

    public JMP(int[] parameters) {
        super(parameters);
    }

    @Override
    public void doOperation(CPU cpu) {
        int k = parameters[2];
        System.out.println("JMP   | PC <- " + k);
        cpu.setPC(k - 1);
    }
}
