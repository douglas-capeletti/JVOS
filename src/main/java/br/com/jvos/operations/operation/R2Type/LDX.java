package br.com.jvos.operations.operation.R2Type;

import br.com.jvos.Thread;
import br.com.jvos.operations.Operation;

import static br.com.jvos.Util.lineHeader;

public class LDX extends Operation {

    public LDX(int reg1, int reg2, int par) {
        super(reg1, reg2, par);
    }

    @Override
    public void doOperation(Thread thread) {
        thread.setRegister(this.reg1, thread.getMemoryRow(this.reg2));
    }

    @Override
    public String toString() {
        return lineHeader(this.getClass().getName()).concat("R" + this.reg1 + " <- [R" + this.reg2 + "]");
    }
}
