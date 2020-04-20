package br.com.jvos.operations.operation.R1Type;

import br.com.jvos.Thread;
import br.com.jvos.operations.Operation;

import static br.com.jvos.Util.lineHeader;

public class STOP extends Operation {

    public STOP(int reg1, int reg2, int par) {
        super(reg1, reg2, par);
    }

    @Override
    public void doOperation(Thread thread) {
        thread.setPC(0);
    }

    @Override
    public String toString() {
        return lineHeader(this.getClass().getName());
    }
}
