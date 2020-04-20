package br.com.jvos.operations.operation.JType;

import br.com.jvos.Thread;
import br.com.jvos.operations.Operation;

import static br.com.jvos.Util.lineHeader;

public class JMPIL extends Operation {

    public JMPIL(int reg1, int reg2, int par) {
        super(reg1, reg2, par);
    }

    @Override
    public void doOperation(Thread thread) {
        if (thread.getRegister(this.reg2) < 0) thread.setPC(thread.getRegister(this.reg1));
    }

    @Override
    public String toString() {
        return lineHeader(this.getClass().getName()).concat("PC <- (" + this.reg2 + " < 0) ? " + this.reg1 + " : +1");
    }
}
