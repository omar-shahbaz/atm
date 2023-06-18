package payload;

public class TransactionMenu {

    private String[] transactionInfo = new String[5];
    private String num;

    public TransactionMenu(){
        transactionInfo[0] = "MBS Transactions (1024)";
        transactionInfo[1] = "Withdraw";
        transactionInfo[2] = "Deposit";
        transactionInfo[3] = "Check Balance";
        transactionInfo[4] = "Transaction History";
        num = "*";
    }

    public String[] createTransactionWindow(){
        String infoAlignment = "| %-2s | %-24s|%n";
        System.out.format("+------------------------------+%n");
        System.out.format(infoAlignment, num, transactionInfo[0]);
        System.out.format("+------------------------------+%n");
        for(int i=1;i<5;i++) {
            System.out.format(infoAlignment,i,transactionInfo[i]);
        }
        System.out.format("+------------------------------+%n");



        return null;
    }
}
