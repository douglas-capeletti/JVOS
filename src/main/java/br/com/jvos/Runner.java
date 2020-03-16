package br.com.jvos;

public class Runner {

    public static void main(String[] args) {

        int size = 1024;
        Memory mem = new Memory(size);

        CPU cpu = new CPU(mem);

        Loader loader = new Loader();
        Program program = loader.run("/sample.jvs");

        cpu.run(program);

        mem.printBlock();
    }

}
