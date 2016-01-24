package com.sdp.cwone.sml;

import java.util.Arrays;

/**
 * This class is the superclass of the classes for machine instructions
 *
 * @author someone
 */

public abstract class Instruction {

    protected final String[] language = {"add", "sub", "mul", "div", "out", "lin", "bnz"};

    protected String label;
    protected String opcode;

    // Constructor: an instruction with label l and opcode op
    // (op must be an operation of the language)
    public Instruction(String l, String op) {

        // check for whitespace
        for (char c : l.toCharArray()) {

            if (Character.isWhitespace(c))
                throw new RuntimeException(l + " is not a valid label.");

        }

        // check valid SML opcode
        if (!Arrays.asList(language).contains(op))
            throw new RuntimeException(op + " is not a valid SML operation.");

        // set label and opcode
        this.label = l;
        this.opcode = op;
    }

    // = the representation "label: opcode" of this Instruction

    @Override
    public String toString() {
        return label + ": " + opcode;
    }

    // Execute this instruction on machine m.

    public abstract void execute(Machine m);
}
