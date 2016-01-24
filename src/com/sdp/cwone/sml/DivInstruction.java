package com.sdp.cwone.sml;

/**
 * Created by Basil on 24/01/2016.
 */
public class DivInstruction extends Instruction {

    private int result;
    private int op1;
    private int op2;

    public DivInstruction(String label, String op) {
        super(label, op);
    }

    public DivInstruction(String label, int result, int op1, int op2) {
        this(label, "div");
        this.result = result;
        this.op1 = op1;
        this.op2 = op2;
    }

    @Override
    public void execute(Machine m) {
        int value1 = m.getRegisters().getRegister(op1);
        int value2 = m.getRegisters().getRegister(op2);

        if (value2 == 0)
            throw new ArithmeticException("Cannot divide by zero");

        m.getRegisters().setRegister(result, value1 / value2);
    }

    @Override
    public String toString() {
        return super.toString() + " " + op1 + " / " + op2 + " to " + result;
    }

}
