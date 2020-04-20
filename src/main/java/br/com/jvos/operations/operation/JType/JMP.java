package br.com.jvos.operations.operation.JType;

import br.com.jvos.Thread;
import br.com.jvos.operations.Operation;

import static br.com.jvos.Util.lineHeader;

public class JMP extends Operation {

    public JMP(int reg1, int reg2, int par) {
        super(reg1, reg2, par);
    }

    @Override
    public void doOperation(Thread thread) {
        thread.setPC(this.par);
    }

    @Override
    public String toString() {
        return lineHeader(this.getClass().getName()).concat("PC <- " + this.par);
    }
}
