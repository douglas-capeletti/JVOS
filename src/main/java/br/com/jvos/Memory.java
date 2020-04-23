package br.com.jvos;

public class Memory {

    private int[] row;

//    public Memory(int size) { this.row = new int[size]; }

    public int getRow(int position) {
        return row[position];
    }

    public void setRow(int position, int value) {
        this.row[position + (this.timesAllocated * this.partitionStart)] = value;
    }

    public void printBlock() {
        for (int i = 0;  i < this.nextPartition; i++) {
            if (i >= this.partitionStart) {
                System.out.println("[" + i + "]\t-> " + row[i]);
            }
        }
    }

    public void allocateMemory() {
        if(this.partitionStart >= row.length) {
            System.out.println("Maximum memory reached. Aborting.");
        } else {
            this.partitionStart = this.nextPartition;
            this.nextPartition = row.length / 4 + this.nextPartition;
            this.timesAllocated++;
        }
    }

    private int nextPartition = 0;
    private int timesAllocated;
    private int partitionStart;

    public Memory(int size) {
        this.row = new int[size];
        this.timesAllocated = 0;
        this.partitionStart = this.nextPartition;
        this.nextPartition = size / 4 + this.nextPartition;
    }
}
