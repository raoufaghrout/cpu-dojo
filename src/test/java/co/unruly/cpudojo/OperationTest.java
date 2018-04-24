package co.unruly.cpudojo;

import org.junit.Test;

import static co.unruly.cpudojo.Operation.*;
import static co.unruly.cpudojo.Operation.getOperationFromOpCode;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class OperationTest {

    @Test
    public void shouldGetOperationFromOpCode() throws InvalidOperationInMemory {
        Operation operationBRK = getOperationFromOpCode(0);
        Operation operationLDA = getOperationFromOpCode(1);
        Operation operationADC = getOperationFromOpCode(2);
        Operation operationSTA = getOperationFromOpCode(3);

        assertThat(operationBRK, is(BRK));
        assertThat(operationLDA, is(LDA));
        assertThat(operationADC, is(ADC));
        assertThat(operationSTA, is(STA));
    }

    @Test(expected = InvalidOperationInMemory.class)
    public void shouldThrowInvalidOperationInMemoryExceptionForUnknownOpCode() throws InvalidOperationInMemory {
        getOperationFromOpCode(11);
    }
}
