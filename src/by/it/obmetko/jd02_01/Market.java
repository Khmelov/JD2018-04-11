package by.it.obmetko.jd02_01;




public class Market {


    static int countBuyers = 0;

    static int countBuyersInShop = 0;

    public static void main(String[] args) throws InterruptedException {


        for (int i = 1; i < 121; i++) {
            Thread.sleep(1000);
            if (i == 1 || i == 60 && countBuyersInShop <= 10) {
                int count = Util.random(5, 10);
                for (int j = 0; j < count; j++) {
                    countBuyersInShop++;
                    countBuyers++;
                    Buyer buyer = new Buyer(countBuyers);
                    buyer.start();
                }
            }
            if (i > 1 && i < 31 && countBuyersInShop <= (i + 10) || i > 60 && i < 91 && countBuyersInShop <= (i + 10)) {
                int count = Util.random(0, 2);
                for (int j = 0; j < count; j++) {
                    countBuyersInShop++;
                    countBuyers++;
                    Buyer buyer = new Buyer(countBuyers);
                    buyer.start();
                }
            }

            if (i > 30 && i < 61 && countBuyersInShop <= (40 + (30 - i)) || i > 90 && i < 121 && countBuyersInShop <= (40 + (30 - i))) {
                int count = Util.random(0, 2);
                for (int j = 0; j < count; j++) {
                    countBuyersInShop++;
                    countBuyers++;
                    Buyer buyer = new Buyer(countBuyers);
                    buyer.start();
                }
            }
        }




    }
}
