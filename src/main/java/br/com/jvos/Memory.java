package br.com.jvos;

public class Memory {

    private int[] row;

    public Memory(int size) {
        this.row = new int[size];
    }

    public int getRow(int position) {
        return row[position];
    }

    public void setRow(int position, int value) {
        this.row[position] = value;
    }

    public void printBlock() {
        for (int i = 0; i < row.length; i++) {
            System.out.println("[" + i + "]\t-> " + row[i]);
        }
    }
}
