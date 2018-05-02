package co.unruly.cpudojo;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import static co.unruly.cpudojo.Operation.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CPUTest {

    private CPU cpu;

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Before
    public void setUp() {
        cpu = new CPU(new int[16]);
    }

    @Test
    public void shouldInitialiseACPUWithMemoryOfSize16() {
        assertThat(cpu.getMemory().length, is(16));
    }

    @Test
    public void shouldInitialiseACPUWithProgramCounterAt0() {
        assertThat(cpu.getProgramCounter(), is(0));
    }

    @Test
    public void shouldInitialiseACPUWithRegisterAAs0() {
        assertThat(cpu.getRegisterA(), is(0));
    }

    @Test
    public void shouldHandleBRKOperation() {
        int[] memory = new int[16];

        exit.expectSystemExit();

        CPU cpu = new CPU(memory);
        cpu.start();

        assertThat(cpu.getRegisterA(), is(0));
        assertThat(cpu.getProgramCounter(), is(1));
    }

    @Test
    public void shouldHandleLDAOperation() {
        int[] memory = new int[16];
        memory[0] = LDA.getOpCode();
        memory[1] = 100;

        exit.expectSystemExit();

        CPU cpu = new CPU(memory);
        cpu.start();

        assertThat(cpu.getRegisterA(), is(100));
        assertThat(cpu.getProgramCounter(), is(2));
    }

    @Test
    public void shouldHandleADCOperation() {
        int[] memory = new int[16];
        memory[0] = LDA.getOpCode();
        memory[1] = 100;
        memory[2] = ADC.getOpCode();
        memory[3] = 100;

        exit.expectSystemExit();

        CPU cpu = new CPU(memory);
        cpu.start();

        assertThat(cpu.getRegisterA(), is(200));
        assertThat(cpu.getProgramCounter(), is(4));
    }

    @Test
    public void shouldHandleSTAOperation() {
        int[] memory = new int[16];
        memory[0] = LDA.getOpCode();
        memory[1] = 100;
        memory[2] = STA.getOpCode();
        memory[3] = 15;

        exit.expectSystemExit();

        CPU cpu = new CPU(memory);
        cpu.start();

        assertThat(cpu.getRegisterA(), is(100));
        assertThat(cpu.getProgramCounter(), is(4));
        assertThat(cpu.getMemory()[15], is(100));
    }
}
