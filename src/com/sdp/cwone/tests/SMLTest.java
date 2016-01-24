package com.sdp.cwone.tests;

import com.sdp.cwone.sml.Machine;
import com.sdp.cwone.sml.Registers;
import com.sdp.cwone.sml.Translator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Basil on 24/01/2016.
 */
public class SMLTest {

    private Machine machine;
    private Translator translator;
    private Registers registers;

    @Before
    public void setUp() throws Exception {

        machine = new Machine();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAdd() throws Exception {

        /**
         * Run basic-add.sml program
         *
         * Expected state of registers = [0, 6, 1, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]         *
         */

        String program = "com/sdp/cwone/programs/basic-add.sml";
        translator = new Translator(program);
        translator.readAndTranslate(machine.getLabels(), machine.getProg());
        machine.execute();

        registers = machine.getRegisters();

        assertTrue(registers.getRegister(3) == 7);

    }

}
