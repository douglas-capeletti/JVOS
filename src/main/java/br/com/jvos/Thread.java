package br.com.jvos;

public class Thread {

    private int PC = 0;
    private int[] registers = new int[8];
    private Memory memory;

    public Thread(Memory memory) {
        this.memory = memory;
    }

    public int getPC() {
        return PC;
    }

    public void setPC(int PC) {
        this.PC = PC - 1;
    }

    public void nextPC() {
        this.PC += 1;
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
