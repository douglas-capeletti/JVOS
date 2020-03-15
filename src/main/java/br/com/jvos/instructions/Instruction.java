package br.com.jvos.instructions;

import br.com.jvos.CPU;

public abstract class Instruction {

    protected int[] parameters;

    public Instruction(int[] parameters) {
        this.parameters = parameters;
    }

    abstract public void doOperation(CPU cpu);

}