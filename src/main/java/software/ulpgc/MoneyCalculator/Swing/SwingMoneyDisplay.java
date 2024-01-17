package software.ulpgc.MoneyCalculator.Swing;

import software.ulpgc.MoneyCalculator.*;
import javax.swing.*;

public class SwingMoneyDisplay extends JLabel implements MoneyDisplay {
    @Override
    public void show(Money money) {
        this.setText(money.toString());
    }
}
