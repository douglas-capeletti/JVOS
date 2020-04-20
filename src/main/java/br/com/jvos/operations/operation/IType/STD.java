package br.com.jvos.operations.operation.IType;

import br.com.jvos.Thread;
import br.com.jvos.operations.Operation;

import static br.com.jvos.Util.lineHeader;

public class STD extends Operation {

    public STD(int reg1, int reg2, int par) {
        super(reg1, reg2, par);
    }

    @Override
    public void doOperation(Thread thread) {
        thread.setMemoryRow(this.par, thread.getRegister(this.reg1));
    }

    @Override
    public String toString() {
        return lineHeader(this.getClass().getName()).concat("[" + this.par + "]" + " <- " + "R" + this.reg1);
    }
}
