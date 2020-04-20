package br.com.jvos.operations;

import br.com.jvos.Thread;

public abstract class Operation {

    protected int reg1;
    protected int reg2;
    protected int par;

    public Operation(int reg1, int reg2, int par) {
        this.reg1 = reg1;
        this.reg2 = reg2;
        this.par = par;
    }

    abstract public void doOperation(Thread thread);

    abstract public String toString();

}