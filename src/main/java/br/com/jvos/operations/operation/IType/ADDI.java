package br.com.jvos.operations.operation.IType;

import br.com.jvos.Thread;
import br.com.jvos.operations.Operation;

import static br.com.jvos.Util.lineHeader;

public class ADDI extends Operation {

    public ADDI(int reg1, int reg2, int par) {
        super(reg1, reg2, par);
    }

    @Override
    public void doOperation(Thread thread) {
        thread.setRegister(reg1, thread.getRegister(reg1) + this.par);
    }

    @Override
    public String toString() {
        return lineHeader(this.getClass().getName()).concat("R" + this.reg1 + " <- " + "R" + this.reg1 + " + " + this.par);
    }
}
