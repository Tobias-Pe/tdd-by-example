package guru.springframework;

import java.util.HashMap;

public class Bank {

    private final HashMap<Pair, Integer> rateMap = new HashMap<>();

    public Money reduce(Expression expression, String currency) {
        return expression.reduce(this, currency);
    }

    public void addRate(String currencyFrom, String currencyTo, int rate) {
        rateMap.put(new Pair(currencyFrom, currencyTo), rate);
    }

    public Integer rate(String currencyFrom, String currencyTo) {
        if (currencyFrom.equals(currencyTo)) {
            return 1;
        }
        return rateMap.get(new Pair(currencyFrom, currencyTo));
    }
}
