package software.ulpgc.MoneyCalculator;

public interface ExchangeRateLoader {
    ExchangeRate load(Currency from, Currency to);
}
