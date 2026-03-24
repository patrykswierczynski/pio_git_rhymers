package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    public static final int EMPTY = -1;
    public static final int IF_EMPTY = -1;
    public static final int CAPACITY = 12;
    public static final int FULL = CAPACITY - 1;

    private final int[] NUMBERS = new int[CAPACITY];

    public int total = EMPTY;

    public void countIn(int in) {
        if (!isFull())
            NUMBERS[++total] = in;
    }

    public boolean callCheck() {
        return total == EMPTY;
    }

    public boolean isFull() {
        return total == FULL;
    }

    protected int peekaboo() {
        if (callCheck())
            return IF_EMPTY;
        return NUMBERS[total];
    }

    public int countOut() {
        if (callCheck())
            return IF_EMPTY;
        return NUMBERS[total--];
    }

}
