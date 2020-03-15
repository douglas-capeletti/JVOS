package br.com.jvos;

import br.com.jvos.instructions.Instruction;

public class Program<T extends Instruction> {

    private T[] instructions;

    public Program(T[] instructions) {
        this.instructions = instructions;
    }

    void run(CPU cpu) {
        System.out.println("Program running on PC [" + cpu.getPC() + "");
        for (T instruction : instructions) {
            if (cpu.getPC() == -1) break;
            instruction.doOperation(cpu);
            cpu.setPC(cpu.getPC() + 1);
        }
        cpu.setPC(0);
    }

}
