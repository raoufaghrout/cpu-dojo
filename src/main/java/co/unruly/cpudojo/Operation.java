package co.unruly.cpudojo;

public enum Operation {

    BRK(0, 1, "BRK", "Stops the program."),
    LDA(1, 2, "LDA", "Load the value in the next memory address into register A."),
    ADC(2, 2, "ADC", "Add the value in the next memory address to the value in register A."),
    STA(3, 2, "STA", "Store the value of register A into the memory location specified by the value in the next memory address.");

    private int opCode;
    private int length;
    private String name;
    private String description;

    Operation(int opCode, int length, String name, String description) {
        this.opCode = opCode;
        this.length = length;
        this.name = name;
        this.description = description;
    }

    public static Operation getOperationFromOpCode(int opCode) throws InvalidOperationInMemory {
        for(Operation operation : Operation.values()) {
            if (operation.getOpCode() == opCode) return operation;
        }

        throw new InvalidOperationInMemory();
    }

    public int getOpCode() {
        return opCode;
    }

    public int getLength() {
        return length;
    }

}
