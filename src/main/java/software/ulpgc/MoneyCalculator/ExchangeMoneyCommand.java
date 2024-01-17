package software.ulpgc.MoneyCalculator;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import static java.lang.Double.parseDouble;

public class ExchangeMoneyCommand implements Command {
    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final ExchangeRateLoader exchangeRateLoader;
    private final MoneyDisplay moneyDisplay;

    public ExchangeMoneyCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, ExchangeRateLoader exchangeRateLoader, MoneyDisplay moneyDisplay) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.exchangeRateLoader = exchangeRateLoader;
        this.moneyDisplay = moneyDisplay;
    }

    @Override
    public void execute() {
        Money money = moneyDialog.get();
        Currency currency = currencyDialog.get();
        ExchangeRate exchangeRate = exchangeRateLoader.load(money.getCurrency(), currency);
        NumberFormat formatter = new DecimalFormat("#######.######");
        double result = exchangeRate.rate() * parseDouble(money.getAmount());
        moneyDisplay.show(new Money(formatter.format(result), currency));
    }
}
