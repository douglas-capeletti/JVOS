package br.com.jvos;

import java.util.Arrays;

public class Memory {

    private int[] row;
    private int nextPartition = 0;
    private int timesAllocated;
    private int partitionStart;
    private int partitionAmount;
    private boolean[] freePartitions;

    public Memory(int size) {
        this.row = new int[size];
        this.partitionAmount = 4;
        this.timesAllocated = 0;
        this.partitionStart = this.nextPartition;
        this.nextPartition = size / this.partitionAmount + this.nextPartition;
        freePartitions = new boolean[this.row.length / partitionAmount];
        Arrays.fill(this.freePartitions, true);
    }

    public int getRow(int position) {
        return row[position];
    }

    public void setRow(int position, int value) {
        this.row[position + (this.timesAllocated * this.row.length / this.partitionAmount)] = value;
    }

    public void printBlock() {
        for (int i = 0;  i < this.nextPartition; i++) {
            if (i >= this.partitionStart) {
                System.out.println("[" + i + "]\t-> " + row[i]);
            }
        }
        System.out.println("==================================");

        allocateMemory();
    }

    public void allocateMemory() {
        if(this.partitionStart < row.length) {
            this.partitionStart = this.nextPartition;
            this.nextPartition = row.length / 4 + this.nextPartition;
            this.timesAllocated++;
        }
    }
}
