package br.com.jvos.structures;

import br.com.jvos.runtime.Util;

public class Memory {

    private int memorySize;
    private int initialDataIndex; //TODO build validation using this value
    private byte[][] memory;

    public Memory(int memorySize, int initialDataIndex) {
        this.memorySize = memorySize;
        this.initialDataIndex = initialDataIndex;
        this.memory = new byte[memorySize][4];
    }

    public int getMemorySize() {
        return memorySize;
    }

    public int getInitialDataIndex() {
        return initialDataIndex;
    }

    public byte[] read(int position) {
        byte[] values = memory[position];
        System.out.printf("Reading position [%d] values -> %s%n", position, Util.toString(memory[position]));
        return values;
    }

    public void write(int position, byte[] content) {
        if (content.length > 4) throw new RuntimeException("The content to write are grater than the space available");
        System.out.printf("Writing position [%d] values -> %s%n", position, Util.toString(content));
        this.memory[position] = content;
    }


}
