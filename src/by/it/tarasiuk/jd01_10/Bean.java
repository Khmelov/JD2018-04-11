package by.it.tarasiuk.jd01_10;

class Bean {

    @Param(a=1, b=0)
    double sum(int a, int b) {
        return a + b;
    }

    @Param(a=5, b=2)
    static double max(int a, int b) {
        return a > b ? a : b;
    }

    @Param(a=4, b=3)
    static double min(int a, int b) {
        return a < b ? a : b;
    }

    double avg(int a, int b) {
        return (a + b) / 2.0;
    }
}
