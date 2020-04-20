package br.com.jvos;

public class Runner {

    public static void main(String[] args) {

        Memory mem = new Memory(1024);

        Thread thread = new Thread(mem);

        Loader loader = new Loader();

        Program program = loader.load("fibonacci");

        thread.run(program);

        mem.printBlock(50, 10);
    }

}
