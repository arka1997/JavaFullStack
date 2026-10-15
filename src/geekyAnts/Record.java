package geekyAnts;

import java.math.BigDecimal;

public class Record {
    String txnRef;
    BigDecimal amount;

    Record(String txnRef, BigDecimal amount) {
        this.txnRef = txnRef;
        this.amount = amount;
    }
}
