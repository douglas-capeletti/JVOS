package br.com.jvos.operations.operation.R2Type;

import br.com.jvos.Thread;
import br.com.jvos.operations.Operation;

import static br.com.jvos.Util.lineHeader;

public class STX extends Operation {

    public STX(int reg1, int reg2, int par) {
        super(reg1, reg2, par);
    }

    @Override
    public void doOperation(Thread thread) {
        thread.setMemoryRow(thread.getMemoryRow(this.reg1), thread.getRegister(this.reg2));
    }

    @Override
    public String toString() {
        return lineHeader(this.getClass().getName()).concat("[R" + this.reg1 + "] <- R" + this.reg2);
    }
}
