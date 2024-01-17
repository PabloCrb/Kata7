package software.ulpgc.MoneyCalculator.Fixer;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import software.ulpgc.MoneyCalculator.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;

public class FixerExchangeRateLoader implements ExchangeRateLoader {

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        try {
            String json = loadJson(from.code(), to.code());
            return toExchangeRate(json, from, to);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private ExchangeRate toExchangeRate(String json, Currency from, Currency to) {
        JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);
        JsonObject rates = jsonObject.getAsJsonObject("rates");

        double rate1 = rates.get(from.code()).getAsDouble();
        double rate2 = rates.get(to.code()).getAsDouble();
        return new ExchangeRate(from, to, LocalDate.now(), rate2/rate1);
    }

    private String loadJson(String from, String to) throws IOException {
        URL url = new URL("http://data.fixer.io/api/latest?access_key=" + FixerAPI.exhangeRateKey);
        try (InputStream is = url.openStream()) {
            return new String(is.readAllBytes());
        }
    }
}
