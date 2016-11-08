package basicSyntax;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by Roman Horilyi on 10.10.2016.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(sumDigits(122));
        System.out.println(booleanExpression(true, false, true, true));
        System.out.println(leapYearCount(2017));
        System.out.println(doubleExpression(505, 100, 605));
        System.out.println(flipBit(123456, 4));
        System.out.println(isPowerOfTwo(1024));
    }

    /**
     * Sums digits of an input number.
     *
     * @param number
     * @return sum of <code>number</code> digits
     */
    public static int sumDigits(int number) {
        if (number < 0) {
            number = Math.abs(number);
        }

        int result = 0;
        while (number >= 10) {
            result += number % 10;
            number /= 10;
        }

        return result + number;
    }

    /**
     * Analyzes input bits in form of boolean variables and will return <code>true</code>
     * in case there are only 2 <code>true</code> variables among all of them. Otherwise, returns <code>false</code>.
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @return <code>true</code>, if there're only 2 <code>true</code> variables in input.
     */
    public static boolean booleanExpression(boolean a, boolean b, boolean c, boolean d) {
        if ((a || b || c || d) && !(a && b && c && d)) {
            return (a ^ b) == (c ^ d);
        } else {
            return false;
        }
    }

    /**
     * Calculates a number of leap years from 1 AD till the specified year.
     *
     * @param year max threshold for calculation of leap years
     * @return number of leap years
     */
    public static int leapYearCount(int year) {
        return (year >> 2) - (year / 100) + (year / 400);
    }

    /**
     * Determines whether <code>a + b = c</code> with admissible inaccuracy of 0.0001 (1E-4).
     *
     * @param a
     * @param b
     * @param c
     * @return <code>true</code>, if <code>a + b = c</code>
     */
    public static boolean doubleExpression(double a, double b, double c) {
        if (Math.abs(c - a - b) < 1e-4) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Flips one bit of the specified <code>value</code>.
     *
     * @param value integer number
     * @param bitIndex index of the bit to flip, 1 <= bitIndex <= 32
     * @return new value with one bit flipped
     */
    public static int flipBit(int value, int bitIndex) {
        return value ^ (int) Math.pow(2, bitIndex - 1);
    }

    /**
     * Checks if the specified <code>value</code> is a power of two.
     *
     * @param value integer number
     * @return <code>true</code>, if <code>value</code> is power of two, otherwise - <code>false</code>
     */
    public static boolean isPowerOfTwo(int value) {
        if (Integer.bitCount(Math.abs(value)) == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if the specified <code>text</code> is a palindrome.
     *
     * @param text text to check
     * @return <code>true</code>, if <code>text</code> is a palindrome, otherwise - <code>false</code>
     */
    public static boolean isPalindrome(String text) {
        String simplifiedText = text.toLowerCase().replaceAll("[^a-z0-9]", "");
        char[] textArray = simplifiedText.toCharArray();
        int textLength = textArray.length;
        char[] reversedText = new char[textLength];
        for (int i = 0; i < textLength; i++) {
            reversedText[i] = textArray[textLength - 1 - i];
        }

        if (Arrays.equals(textArray, reversedText)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Calculates factorial of the specified <code>value</code>.
     *
     * @param value positive number
     * @return factorial of <code>value</code>
     */
    public static BigInteger factorial(int value) {
        if (value == 1) {
            return BigInteger.valueOf(1);
        } else {
            return BigInteger.valueOf(value).multiply(factorial(value - 1));
        }
    }

    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        int[] mergedArray = new int[a1.length + a2.length];

        while (counter3 < a1.length + a2.length) {
            if (counter1 == a1.length) {
                while (counter3 < a1.length + a2.length) {
                    mergedArray[counter3++] = a2[counter2++];
                }
                break;
            }
            if (counter2 == a2.length) {
                while (counter3 < a1.length + a2.length) {
                    mergedArray[counter3++] = a1[counter1++];
                }
                break;
            }
            if (a1[counter1] <= a2[counter2]) {
                mergedArray[counter3++] = a1[counter1++];
            } else {
                mergedArray[counter3++] = a2[counter2++];
            }
        }

        return mergedArray;
    }

    /**
     * Reformats an input text of the play script in the form of cues for every role with sequence numbers.
     *
     * @param roles array of play role names
     * @param textLines script of the play in the form <code>"Role: Cue"</code>
     * @return text in the form of cues for every role with correspondent sequence numbers
     */
    public static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder resultPlayText = new StringBuilder();
        StringBuilder[] textPerEveryRole = new StringBuilder[roles.length];

        for (int i = 0; i < roles.length; i++) {
            textPerEveryRole[i] = new StringBuilder(roles[i] + ":\n");
            for (int j = 0; j < textLines.length; j++) {
                if (textLines[j].matches("^" + roles[i] + ": " + ".+")) {
                    int orderNumberOfCue = j + 1;
                    textPerEveryRole[i].append(orderNumberOfCue)
                            .append(") ")
                            .append(textLines[j].substring(roles[i].length() + 2)) //
                            .append("\n");
                }
            }
            resultPlayText.append(textPerEveryRole[i]).append("\n");
        }

        return resultPlayText.toString();
    }
}
