package br.com.jvos;

import static br.com.jvos.Util.lineHeader;

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

    public void printBlock(int start, int size) {
        for (int i = start;  i < start + size; i++) {
            System.out.println(lineHeader("[" + i + "]") + (row[i]));
        }
    }
}
