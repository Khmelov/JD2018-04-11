package by.it.tarasiuk.jd02_06;

public class Runner {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger();
        for (int i = 1; i <= 5; i++) {
            logger.logError("Error #" + i);
        }
    }
}
