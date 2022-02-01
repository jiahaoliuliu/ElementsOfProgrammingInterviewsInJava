package com.jiahaoliuliu.chapter4.primitivetypes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Write a program that takes a 64-bit unsigned integer and returns the 640bit unsigned integer consistent
 * of the bits of the input in the reverse order
 * Example:
 * - Input:  1110 0000 0000 0000 0001
 * - Output: 1000 0000 0000 0000 0111
 */
public class Q3ReverseBits {

    private static int INTEGER_BIT_LENGTH = 32;

    /**
     * The size of the int is 4 bytes, that's 4 x 8 bits.
     * @param number
     * @return
     */
    private int reverseBits(int number) {
        // Special cases
        if (number == 0) return 0;
        int result = 0;
        int currentPositionRtl = 31;

        while (currentPositionRtl >= 0) {
            int lastBit = (number & 1) > 0 ? 1 : 0;
            result += lastBit;
            result = result << 1;
            number = number >> 1;
            currentPositionRtl --;
            if (number == 0) {
                result = result << currentPositionRtl;
                return result;
            }
        }

        return result;
    }

    @Test
    public void testReverseBits1() {
        // Given
        int number = 0;

        // When
        int result = reverseBits(number);

        // Then
        assertEquals(0, result);
    }

    @Test
    public void testReverseBits2() {
        // Given
        int number = 1;

        // When
        int result = reverseBits(number);

        // Then
        assertEquals(Integer.MIN_VALUE, result);
    }

    @Test
    public void testReverseBits3() {
        // Given
        String valueOnString = "1101";
        int number = Integer.parseInt(valueOnString, 2);

        // When
        int result = reverseBits(number);

        // Then
        String expectedValue = "1011 0000 0000 0000 0000 0000 0000 0000".replace(" ", "");
        assertEquals(expectedValue, Integer.toBinaryString(result));
    }
}
