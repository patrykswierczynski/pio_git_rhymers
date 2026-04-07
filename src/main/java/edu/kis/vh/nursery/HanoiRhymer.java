package edu.kis.vh.nursery;

/**
 * Implementacja wariantu CountingOutRhymer inspirowanego problemem wież Hanoi.
 *
 * Klasa pozwala dodawać liczby tylko wtedy, gdy są mniejsze lub równe
 * ostatnio dodanej liczbie. Jeśli liczba jest większa, zostaje odrzucona.
 * Liczba odrzuceń jest zapisywana w polu totalRejected.
 */
public class HanoiRhymer extends DefaultCountingOutRhymer {

    private int totalRejected = 0;

    /**
     * Zwraca liczbę odrzuconych elementów.
     *
     * @return liczba elementów, które nie zostały dodane do struktury
     */
    public int reportRejected() {
        return totalRejected;
    }

    /**
     * Dodaje element do struktury tylko wtedy,
     * gdy jest mniejszy lub równy ostatniemu elementowi.
     * W przeciwnym razie zwiększa licznik odrzuceń.
     *
     * @param in liczba, która ma zostać dodana do struktury
     */
    @Override
    public void countIn(int in) {
        if (!callCheck() && in > peekaboo())
            totalRejected++;
        else
            super.countIn(in);
    }

    /**
     * Zwraca liczbę odrzuconych elementów.
     *
     * @return liczba odrzuconych wartości
     */
    public int getTotalRejected() {
        return totalRejected;
    }

}