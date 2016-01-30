package com.sdp.cwone.tests;

import com.sdp.cwone.sml.Machine;
import com.sdp.cwone.sml.Registers;
import com.sdp.cwone.sml.Translator;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

/**
 * Created by Basil on 24/01/2016.
 */
public class SMLTest {

    private Machine machine;
    private Translator translator1, translator2;
    private Registers registers;

    @Before
    public void setUp() throws Exception {

        machine = new Machine();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testAdd() throws Exception {

        /**
         * Run basic-add.sml program
         *
         * Expected state of registers = [0, 6, 1, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]         *
         */

        String program = "com/sdp/cwone/programs/basic-add.sml";
        translator1 = new Translator(program);
        translator1.readAndTranslate(machine.getLabels(), machine.getProg());
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
        translator1 = new Translator(program);
        translator1.readAndTranslate(machine.getLabels(), machine.getProg());
        machine.execute();

        registers = machine.getRegisters();

        assertTrue(registers.getRegister(3) == 5);

    }

    @Test
    public void testLin() throws Exception {

        /**
         * Run basic-lin.sml program
         *
         * Expected state of registers = [10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10]         *
         */

        String program = "com/sdp/cwone/programs/basic-lin.sml";
        translator1 = new Translator(program);
        translator1.readAndTranslate(machine.getLabels(), machine.getProg());
        machine.execute();

        registers = machine.getRegisters();

        assertTrue(registers.getRegister(0) == 10);
        assertTrue(registers.getRegister(13) == 10);
        assertTrue(registers.getRegister(31) == 10);

    }

    @Test
    public void testMul() throws Exception {

        /**
         * Run basic-mul.sml program
         *
         * Expected state of registers = [0, 6, 6, 36, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]         *
         */

        String program = "com/sdp/cwone/programs/basic-mul.sml";
        translator1 = new Translator(program);
        translator1.readAndTranslate(machine.getLabels(), machine.getProg());
        machine.execute();

        registers = machine.getRegisters();

        assertTrue(registers.getRegister(3) == 36);

    }

    @Test
    public void testDiv() throws Exception {

        /**
         * Run basic-div.sml & error-div.sml program
         *
         * Expected state of registers = [0, 100, 10, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]         *
         */

        String program1 = "com/sdp/cwone/programs/basic-div.sml";
        translator1 = new Translator(program1);
        translator1.readAndTranslate(machine.getLabels(), machine.getProg());
        machine.execute();

        registers = machine.getRegisters();

        assertTrue(registers.getRegister(3) == 10);

        String program2 = "com/sdp/cwone/programs/error-div.sml";
        translator2 = new Translator(program2);
        translator2.readAndTranslate(machine.getLabels(), machine.getProg());

        thrown.expect(ArithmeticException.class);       // expect arithmetic exception
        machine.execute();

    }

    @Test
    public void testOut() throws Exception {

        /**
         * Run basic-out.sml program
         *
         * Expected state of registers = [0, 0, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]         *
         */

        String program = "com/sdp/cwone/programs/basic-out.sml";
        translator1 = new Translator(program);
        translator1.readAndTranslate(machine.getLabels(), machine.getProg());
        machine.execute();

    }

    @Test
    public void testBnz() throws Exception {

        /**
         * Run basic-bnz.sml program
         *
         * Expected state of registers = [0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]         *
         */

        String program = "com/sdp/cwone/programs/basic-bnz.sml";
        translator1 = new Translator(program);
        translator1.readAndTranslate(machine.getLabels(), machine.getProg());
        machine.execute();

        registers = machine.getRegisters();

        assertTrue(registers.getRegister(1) == 0);

    }

    @Test
    public void testFactorial() throws Exception {

        /**
         * Run factorial.sml program
         *
         * Expected state of registers = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 720, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0]         *
         */

        String program = "com/sdp/cwone/programs/factorial.sml";
        translator1 = new Translator(program);
        translator1.readAndTranslate(machine.getLabels(), machine.getProg());
        machine.execute();

        registers = machine.getRegisters();

        assertTrue(registers.getRegister(21) == 720);

    }

}
