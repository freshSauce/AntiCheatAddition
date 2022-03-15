package de.photon.anticheataddition.util.mathematics;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MathUtil
{
    /**
     * Simple method to calculate the absolute offset of two numbers.
     *
     * @return the absolute offset, always positive or 0 if the numbers are equal.
     */
    public static int absDiff(final int a, final int b)
    {
        return a > b ? (a - b) : (b - a);
    }


    /**
     * Simple method to calculate the absolute offset of two numbers.
     *
     * @return the absolute offset, always positive or 0 if the numbers are equal.
     */
    public static long absDiff(final long a, final long b)
    {
        return a > b ? (a - b) : (b - a);
    }

    /**
     * Simple method to calculate the absolute offset of two numbers.
     *
     * @return the absolute offset, always positive or 0 if the numbers are equal.
     */
    public static double absDiff(final double a, final double b)
    {
        return a > b ? (a - b) : (b - a);
    }

    /**
     * Shortcut for number >= min && number <= max
     */
    public static boolean inRange(final int min, final int max, final int number)
    {
        return number >= min && number <= max;
    }

    /**
     * Shortcut for number >= min && number <= max
     */
    public static boolean inRange(final double min, final double max, final double number)
    {
        return number >= min && number <= max;
    }

    /**
     * Bounds a value between two bonds.
     *
     * @return a value of at least min and at most max. If value is smaller than max and greater than min, it is
     * returned unchanged, otherwise either min (value smaller than min) or max (value greater than max) is returned.
     */
    public static double bound(final double min, final double max, final double value)
    {
        return Math.min(Math.max(min, value), max);
    }

    /**
     * Calculates the sum of the elements from 0 to n.
     *
     * @param n the maximum number to sum to (0, 1, 2, 3, 4, ..., n)
     */
    public static int gaussianSumFormulaTo(final int n)
    {
        return (n * (n + 1)) >> 1;
    }

    /**
     * Uses the standard {@link Math#sqrt(double)} call to calculate the hypot of two numbers.
     * Make sure that the absolute value of both numbers are sufficiently small (smaller than 100,000) to avoid overflows.
     */
    public static double fastHypot(final double a, final double b)
    {
        return Math.sqrt(a * a + b * b);
    }

    /**
     * Fast squaring for streams.
     */
    public static int square(final int n)
    {
        return n * n;
    }

    /**
     * Fast squaring for streams.
     */
    public static double square(final double d)
    {
        return d * d;
    }

    public static int pow(int base, int power)
    {
        // 0^0 is defined as 1 here.
        if (power == 0) return 1;

        // Some standard bases that can be calculated very fast.
        if (base == 0) return 0;
        if (base == 1) return 1;
        if (base == 2) return 1 << power;

        switch (power) {
            // Default cases for fast normal usages.
            case 1: return base;
            case 2: return base * base;
            case 3: return base * base * base;
            // Fast exponentiation algorithm.
            default:
                int result = 1;
                while (power > 0) {
                    if ((power & 1) == 1) result *= base;
                    base *= base;
                    power >>= 1;
                }
                return result;
        }
    }
}
