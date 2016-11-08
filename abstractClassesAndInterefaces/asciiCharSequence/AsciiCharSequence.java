package abstractClassesAndInterefaces.asciiCharSequence;

import java.util.Arrays;

/**
 * Created by Roman Horilyi on 01.10.2016.
 */
public class AsciiCharSequence implements CharSequence{
    private byte[] asciiChars;

    public AsciiCharSequence(byte[] asciiChars) {
        this.asciiChars = asciiChars;
    }

    @Override
    public int length() {
        return asciiChars.length;
    }

    @Override
    public char charAt(int index) {
        return (char) asciiChars[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] subSequenceOfAsciiChars = Arrays.copyOfRange(asciiChars, start, end);
        return new AsciiCharSequence(subSequenceOfAsciiChars);
    }

    @Override
    public String toString() {
        return new String(asciiChars);
    }
}
