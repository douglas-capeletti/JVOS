package br.com.jvos;

import br.com.jvos.instructions.Instruction;

public class Program {

    private Instruction[] instructions;

    public Program(Instruction[] instructions) {
        this.instructions = instructions;
    }

    void run(CPU cpu) {
        System.out.println("Program running on PC [" + cpu.getPC() + "");
        for (Instruction instruction : instructions) {
            if (cpu.getPC() == -1) break;
            instruction.doOperation(cpu);
            cpu.setPC(cpu.getPC() + 1);
        }
        cpu.setPC(0);
    }

}
