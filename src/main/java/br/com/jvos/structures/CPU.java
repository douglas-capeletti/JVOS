package br.com.jvos.structures;

import br.com.jvos.runtime.Util;

public class CPU {

    private int memorySize; //TODO build validation using this value
    private int initialDataIndex; //TODO build validation using this value

    private long PC = -1;
    private byte[][] registers = new byte[8][4];

    public CPU(int memorySize, int initialDataIndex) {
        this.memorySize = memorySize;
        this.initialDataIndex = initialDataIndex;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public int getInitialDataIndex() {
        return initialDataIndex;
    }

    public byte[] read(int register) {
        byte[] values = registers[register];
        System.out.printf("Reading register [%d] values -> %s%n", register, Util.toString(registers[register]));
        return values;
    }

    public void write(int register, byte[] content) {
        if (content.length > 4) throw new RuntimeException("The content to write are grater than the space available");
        System.out.printf("Writing register [%d] values -> %s%n", register, Util.toString(content));
        this.registers[register] = content;
    }

}
