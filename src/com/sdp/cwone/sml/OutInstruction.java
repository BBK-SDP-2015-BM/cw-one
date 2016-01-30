package com.sdp.cwone.sml;

/**
 * Created by Basil on 24/01/2016.
 */
public class OutInstruction extends Instruction {

    private int op;

    public OutInstruction(String label, int op) {
        super(label, "out");
        this.op = op;
    }

    @Override
    public void execute(Machine m) {
        int value = m.getRegisters().getRegister(op);
        System.out.println(value);
    }

    @Override
    public String toString() {
        return super.toString() + " " + op;
    }

}
