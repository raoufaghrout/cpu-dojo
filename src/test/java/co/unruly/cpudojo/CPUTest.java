package co.unruly.cpudojo;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

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

    @Ignore
    @Test
    public void shouldLoad100IntoRegisterA() {
        Integer[] memory = new Integer[16];
        memory[0] = 1;
        memory[1] = 100;

        CPU cpu = new CPU(memory);
        cpu.start();

        assertThat(cpu.getRegisterA(), is(100));
    }
}
