package StreamPractice;

import java.io.IOException;
import java.sql.Time;
import java.util.List;

import static java.util.Arrays.*;
import static java.util.Comparator.comparing;

public class solve {
    public solve() {
    }

    public static void main(String[] args) throws IOException {
        double a = System.currentTimeMillis();
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        List<Integer> transaction1 = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .toList();

        double b = System.currentTimeMillis();
        System.out.println("transaction1 = " + transaction1);
        System.out.println(b-a/1000);
    }



}
