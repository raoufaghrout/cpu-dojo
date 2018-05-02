package co.unruly.cpudojo;

import static co.unruly.cpudojo.Operation.getOperationFromOpCode;
import static java.lang.System.exit;

public class CPU {

    private int[] memory;
    private int registerA;
    private int programCounter;

    public CPU(int[] memory) {
        this.memory = memory;
    }

    public int[] getMemory() {
        return memory;
    }

    public int getProgramCounter() {
        return programCounter;
    }

    public int getRegisterA() {
        return registerA;
    }

    public void start() {
        for (int i = 0; i < memory.length; i++) {
            Operation operation = getOperationFromOpCode(memory[i]);
            programCounter = i;
            System.out.println(programCounter);

            switch (operation) {
                case BRK:
                    exit(0);
                case LDA:
                    this.registerA = memory[i + 1];
                    i += 1;
                    break;
                case ADC:
                    this.registerA += memory[i + 1];
                    i += 1;
                    break;
                case STA:
                    memory[memory[i + 1]] = registerA;
                    i += 1;
                    break;
            }
        }
    }
}
