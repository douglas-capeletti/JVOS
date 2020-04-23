package br.com.jvos;

public class Runner {

    public static void main(String[] args) {

        int size = 1024;
        Memory mem = new Memory(size);

        CPU cpu = new CPU(mem);

        Loader loader = new Loader();

        Program program = loader.load("sample1.jvs");
        Program program2 = loader.load("sample2.jvs");

        cpu.run(program);
        mem.printBlock();
        mem.allocateMemory();

        System.out.println("==================================");
        cpu.run(program2);
        mem.printBlock();
    }

}
