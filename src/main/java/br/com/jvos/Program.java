package br.com.jvos;

import br.com.jvos.operations.Operation;

public class Program {

    private Operation[] operations;

    public Program(Operation[] operations) {
        this.operations = operations;
    }

    void run(Thread thread) {
        System.out.println("Program running...");
        thread.setPC(1);
        for (Operation operation : operations) {
            if (thread.getPC() == 0) break;
            operation.doOperation(thread);
            thread.nextPC();
        }
        thread.setPC(0);
    }

}
