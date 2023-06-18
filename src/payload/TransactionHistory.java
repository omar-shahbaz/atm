package payload;

import java.time.LocalDate;
import java.time.LocalTime;

public class TransactionHistory {

    private String[] historyInfo = new String[7];

    public TransactionHistory(){
        historyInfo[0] = "Date";
        historyInfo[1] = "Time";
        historyInfo[2] = "Transaction";
        historyInfo[3] = "Amount";
        historyInfo[4] = "Current Balance";
        historyInfo[5] = "New Balance";
        historyInfo[6] = "Net Balance";
    }

    public String transactionHistory(){
        String transactionHistoryAlign = "|     %-12s|     %-12s| %-12s | %-8s| %-15s | %-13s|%n";
        System.out.format("+---------------------------------------------------------------------------------------------+%n");
        System.out.format(transactionHistoryAlign,historyInfo[0],historyInfo[1], historyInfo[2],
                historyInfo[3], historyInfo[4], historyInfo[5]);
        System.out.format("+---------------------------------------------------------------------------------------------+%n");

        return  null;
    }
}
