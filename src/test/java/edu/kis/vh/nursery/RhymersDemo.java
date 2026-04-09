package edu.kis.vh.nursery;


import edu.kis.vh.nursery.factory.Rhymersfactory;

class RhymersDemo {

    public static final int INT = 15;
    public static final int INT1 = 3;

    public static void main(String[] args) {
        Rhymersfactory factory = new DefaultRhymersFactory();
        testRhymers(factory);
    }

    private static void testRhymers(Rhymersfactory factory) {
        DefaultCountingOutRhymer[] rhymers = { factory.getStandardRhymer(), factory.getFalseRhymer(),
                factory.getFIFORhymer(), factory.getHanoiRhymer()};

        for (int i = 1; i < INT; i++)
            for (int j = 0; j < INT1; j++)
                rhymers[j].countIn(i);

        java.util.Random rn = new java.util.Random();
        for (int i = 1; i < INT; i++)
            rhymers[INT1].countIn(rn.nextInt(20));

        for (int i = 0; i < rhymers.length; i++) {
            while (!rhymers[i].callCheck())
                System.out.print(rhymers[i].countOut() + "  ");
            System.out.println();
        }

        System.out.println("total rejected is "
                + ((HanoiRhymer) rhymers[INT1]).reportRejected());
    }
     static class DefaultRhymersFactory implements Rhymersfactory {

        @Override
        public DefaultCountingOutRhymer getStandardRhymer() {
            return new DefaultCountingOutRhymer();
        }

        @Override
        public DefaultCountingOutRhymer getFalseRhymer() {
            return new DefaultCountingOutRhymer();
        }

        @Override
        public DefaultCountingOutRhymer getFIFORhymer() {
            return new FIFORhymer();
        }

        @Override
        public DefaultCountingOutRhymer getHanoiRhymer() {
            return new HanoiRhymer();
        }

    }
}