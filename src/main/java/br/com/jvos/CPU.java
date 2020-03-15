package br.com.jvos;

public class CPU {

    private int PC = 0;
    private int[] registers = new int[8];
    private Memory memory;

    public CPU(Memory memory) {
        this.memory = memory;
    }

    public int getPC() {
        return PC;
    }

    public void setPC(int PC) {
        this.PC = PC;
    }

    public int getRegister(int position) {
        return registers[position];
    }

    public void setRegister(int position, int value) {
        this.registers[position] = value;
    }

    public int getMemoryRow(int position) {
        return memory.getRow(position);
    }

    public void setMemoryRow(int position, int value) {
        this.memory.setRow(position, value);
    }

    void run(Program program){
        program.run(this);
    }

}
