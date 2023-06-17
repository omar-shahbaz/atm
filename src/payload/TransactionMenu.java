package payload;

public class TransactionMenu {

    private String[] transactionInfo = new String[4];
    private String num;

    public TransactionMenu(){
        transactionInfo[0] = "MBS Transactions (1024)";
        transactionInfo[1] = "Withdraw";
        transactionInfo[2] = "Deposit";
        transactionInfo[3] = "Check Balance";
        num = "*";
    }

    public String[] createTransactionWindow(){
        String infoAlignment = "| %-2s | %-24s|%n";
        System.out.format("+------------------------------+%n");
        System.out.format(infoAlignment, num, transactionInfo[0]);
        System.out.format("+------------------------------+%n");
        for(int i=1;i<4;i++) {
            System.out.format(infoAlignment,i,transactionInfo[i]);
        }
        System.out.format("+------------------------------+%n");



        return null;
    }
}
