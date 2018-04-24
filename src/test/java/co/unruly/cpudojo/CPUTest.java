package co.unruly.cpudojo;

import org.junit.Before;
import org.junit.Test;

import static co.unruly.cpudojo.Operation.ADC;
import static co.unruly.cpudojo.Operation.BRK;
import static co.unruly.cpudojo.Operation.LDA;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

public class CPUTest {

    private CPU cpu;

    @Before
    public void setUp() {
        cpu = new CPU(new Integer[16]);
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
    public void shouldInitialiseACPUWithRegisterAEmpty() {
        assertThat(cpu.getRegisterA(), nullValue());
    }

    @Test
    public void shouldHandleBRKOperation() {
        Integer[] memory = new Integer[16];
        memory[0] = BRK.getOpCode();

        CPU cpu = new CPU(memory);
        cpu.start();

        assertThat(cpu.getRegisterA(), nullValue());
        assertThat(cpu.getProgramCounter(), is(1));
    }

    @Test
    public void shouldHandleLDAOperation() {
        Integer[] memory = new Integer[16];
        memory[0] = LDA.getOpCode();
        memory[1] = 100;

        CPU cpu = new CPU(memory);
        cpu.start();

        assertThat(cpu.getRegisterA(), is(100));
        assertThat(cpu.getProgramCounter(), is(2));
    }

    @Test
    public void shouldHandleADCOperation() {
        Integer[] memory = new Integer[16];
        memory[0] = ADC.getOpCode();
        memory[1] = 100;

        CPU cpu = new CPU(memory);
        cpu.start();

        assertThat(cpu.getRegisterA(), is(100));
        assertThat(cpu.getProgramCounter(), is(2));
    }
}
