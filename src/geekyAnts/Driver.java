package geekyAnts;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Driver {
    // T1-> [T1 , 100.0], T2 -> [T2 , 250.5], T4 -> [T4 , 75.0]
    // T1-> [T1 , 100.0], T2 -> [T2 , 250.5], T3 -> [T3 , 75.0]
    Break brk;
    public static void main(String[] args) {
        // As the code told, that the txnRef should be unique, so I have used HashMap, so that txnRef is not duplicate
        List<Break> record = new ArrayList<>();
        Map<String, Record> ours = new HashMap<>();
        ours.put("T1", new Record("T1", BigDecimal.valueOf(100.00)));
        ours.put("T2", new Record("T2", BigDecimal.valueOf(250.50)));
        ours.put("T3", new Record("T3", BigDecimal.valueOf(75.00)));


        Map<String, Record> theirs = new HashMap<>();
        theirs.put("T1", new Record("T1", BigDecimal.valueOf(100.00)));
        theirs.put("T2", new Record("T2", BigDecimal.valueOf(250.00)));
        theirs.put("T4", new Record("T4", BigDecimal.valueOf(75.00)));

        for (Map.Entry<String, Record> entry: ours.entrySet()){
            String txnRef = entry.getKey();
            BigDecimal amount = entry.getValue().amount;
            if(!theirs.containsKey(txnRef)){ // The reference doesnot exist out theirs
                record.add(new Break(txnRef, BreakType.MISSING_AT_SWITCH, amount, null));
            } else { //The reference exist in theirs, thatswhy we came to this block, to check if the amount mismatches or not
                Record switches = theirs.get(txnRef);
                if(switches.amount.compareTo(amount) != 0){ // we cannot check big decimal like this. we have to use compareTo, to see its values
                    record.add(new Break(txnRef, BreakType.AMOUNT_MISMATCH, amount, theirs.get(txnRef).amount));
                }
            }
        }

        for(Map.Entry<String, Record> entry : theirs.entrySet()) {
            String txnRef = entry.getKey();
            BigDecimal amount = entry.getValue().amount;
            if(!ours.containsKey(txnRef)){
                record.add(new Break(txnRef, BreakType.MISSING_AT_US, amount, null));
                System.out.println("");
            }
        }
        record.forEach(System.out::println);
    }
}
