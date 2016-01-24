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

    @Test
    public void testSub() throws Exception {

        /**
         * Run basic-sub.sml program
         *
         * Expected state of registers = [0, 6, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]         *
         */

        String program = "com/sdp/cwone/programs/basic-sub.sml";
        translator = new Translator(program);
        translator.readAndTranslate(machine.getLabels(), machine.getProg());
        machine.execute();

        registers = machine.getRegisters();

        assertTrue(registers.getRegister(3) == 5);

    }

    @Test
    public void testLin() throws Exception {

        /**
         * Run basic-sub.sml program
         *
         * Expected state of registers = [10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10]         *
         */

        String program = "com/sdp/cwone/programs/basic-lin.sml";
        translator = new Translator(program);
        translator.readAndTranslate(machine.getLabels(), machine.getProg());
        machine.execute();

        registers = machine.getRegisters();

        assertTrue(registers.getRegister(0) == 10);
        assertTrue(registers.getRegister(13) == 10);
        assertTrue(registers.getRegister(31) == 10);

    }

}
