package co.unruly.cpudojo;

public class CPU {

    private Integer[] memory;
    private Integer registerA;
    private Integer programCounter = 0;

    public CPU(Integer[] memory) {
        this.memory = memory;
    }

    public Integer[] getMemory() {
        return memory;
    }

    public Integer getProgramCounter() {
        return programCounter;
    }

    public Integer getRegisterA() {
        return registerA;
    }

    public void start() {}
}
