package edu.umb.cs680.hw01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class PrimeGeneratorTest {

    @Test
    public void generatePrimesBetween1to10(){

        PrimeGenerator primegen = new PrimeGenerator(1L,20L);
        primegen.generatePrimes();
        LinkedList<Long> actualprimes = primegen.getPrimes();
        Long[] expectedPrimes={2L,3L,5L,7L,11L,13L,17L,19L};
        assertIterableEquals(Arrays.asList(expectedPrimes),actualprimes);

    }
    @Test
    public void getExceptionForNegativeRange() {
        try {
            PrimeGenerator primegen = new PrimeGenerator(-10L, -1L);
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
           PrimeGenerator primegen = new PrimeGenerator(100L, 80L);
           primegen.generatePrimes();
           fail("From Value Higher than To Value");
        } catch (RuntimeException ex) {
           String expected = "Wrong input values: from=100 to=80";
           assertEquals(expected, ex.getMessage());
        }
    }
    @Test
    public void getExceptionForEqualRangeValues(){
        try {
            PrimeGenerator primegen = new PrimeGenerator(3L, 3L);
            primegen.generatePrimes();
            fail("equal From and To values");
        } catch (RuntimeException ex) {
            String expected = "Wrong input values: from=3 to=3";
            assertEquals(expected, ex.getMessage());
        }
    }
    @Test
    public void getExceptionForRangeNegative10To10(){
        try {
            PrimeGenerator primegen = new PrimeGenerator(-10L, 10L);
            primegen.generatePrimes();
            fail("Negative From Value and Positive To Values");
        } catch (RuntimeException ex) {
            String expected = "Wrong input values: from=-10 to=10";
            assertEquals(expected, ex.getMessage());
        }
    }
    @Test
    public void getExceptionForRange0to20(){
        try {
            PrimeGenerator primegen = new PrimeGenerator(0L, 20L);
            primegen.generatePrimes();
            fail("Range values shouldn't include 0");
        } catch (RuntimeException ex) {
            String expected = "Wrong input values: from=0 to=20";
            assertEquals(expected, ex.getMessage());
        }
    }

 }
