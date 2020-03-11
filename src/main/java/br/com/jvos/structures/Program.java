package br.com.jvos.structures;

import br.com.jvos.structures.instructions.Instruction;

public class Program<T extends Instruction> {

    private T[] instructions;

    public Program(T[] instructions) {
        this.instructions = instructions;
    }

    public T[] getInstructions() {
        return instructions;
    }
}
