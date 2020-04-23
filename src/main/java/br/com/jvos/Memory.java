package br.com.jvos;

import java.util.Arrays;

public class Memory {

    private int[] row;

    private int partitionAmount;

    private boolean[] allocated;

    public Memory(int size) {
        this.row = new int[size];

        this.partitionAmount = 4;

        allocated = new boolean[partitionAmount];
        Arrays.fill(this.allocated, false);
    }

    public int getRow(int position) {
        return row[position];
    }

    public void setRow(int position, int value) { this.row[position] = value; }

    public void printBlock() {
        for (int i = 0;  i < 10; i++) {
                System.out.println("[" + i + "]\t-> " + row[i]);
        }
    }

    public void setPartitionAllocatedValue(int position, boolean value) { this.allocated[position] = value; }

    public boolean partitionIsAllocated(int position) { return this.allocated[position]; }
}
