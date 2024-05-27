package edu.umb.cs680.hw02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class SingletonPrimeGeneratorTest {
    @Test
    public void getInstanceIsNotNull(){
        SingletonPrimeGenerator gen = SingletonPrimeGenerator.getInstance();
        assertNotNull(gen);
    }
    @Test
    public void getInstanceReturnsIdenticalInstance(){
        SingletonPrimeGenerator gen1 = SingletonPrimeGenerator.getInstance();
        SingletonPrimeGenerator gen2 = SingletonPrimeGenerator.getInstance();
        assertSame(gen1,gen2);
    }

    @Test
    public void generatePrimesBetween1to10(){

        SingletonPrimeGenerator primegen = SingletonPrimeGenerator.getInstance();
        primegen.setRangeValues(1L,10L);
        primegen.generatePrimes();
        LinkedList<Long> actualprimes = primegen.getPrimes();
        Long[] expectedPrimes={2L,3L,5L,7L};
        assertIterableEquals(Arrays.asList(expectedPrimes),actualprimes);

    }

    @Test
    public void getExceptionForNegativeRange() {
        try {
            SingletonPrimeGenerator primegen = SingletonPrimeGenerator.getInstance();
            primegen.setRangeValues(-10L,-1L);
            primegen.generatePrimes();
            fail("NegativeRange");
        } catch (RuntimeException ex) {
            String expected = "Wrong input values: from=-10 to=-1";
            assertEquals(expected, ex.getMessage());
        }
    }
    @Test
    public void getExceptionIfRangeIs100to80() {
        try {
            SingletonPrimeGenerator primegen = SingletonPrimeGenerator.getInstance();
            primegen.setRangeValues(100L, 80L);
            primegen.generatePrimes();
            fail("From Value Higher than To Value");
        } catch (RuntimeException ex) {
            String expected = "Wrong input values: from=100 to=80";
            assertEquals(expected, ex.getMessage());
        }
    }
}