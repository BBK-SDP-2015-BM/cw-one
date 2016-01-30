package com.sdp.cwone.sml;

/**
 * Created by Basil on 30/01/2016.
 */
public class BnzInstruction extends Instruction {

    private int register, value;
    private String targetLabel;

    public BnzInstruction(String label, int register, String targetLabel) {
        super(label, "bnz");
        this.register = register;
        this.value = 0;
        this.targetLabel = targetLabel;
    }

    @Override
    public void execute(Machine m) {

        value = m.getRegisters().getRegister(register);

        if (value != 0)
            m.setPc(m.getLabels().indexOf(targetLabel));
    }

    @Override
    public String toString() {
        return super.toString() + " register " + register + " value is " + value;
    }

}
