package geekyAnts;

import java.math.BigDecimal;

public class Break {
    String txnRef;
    BreakType type;
    BigDecimal ourAmount;
    BigDecimal theirAmount;
    public Break(String txnRef, BreakType type, BigDecimal ourAmount, BigDecimal theirAmount) {
        this.txnRef = txnRef;
        this.type = type;
        this.ourAmount = ourAmount;
        this.theirAmount = theirAmount;
    }

    @Override
    public String toString() {
        return "txnRef=" + txnRef + ", type=" + type + ", ourAmount=" + ourAmount + ", theirAmount="
                + theirAmount ;
    }

}
