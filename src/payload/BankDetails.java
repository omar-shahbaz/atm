package payload;


import authUser.UserAuth;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BankDetails {
    private String[] bankInfo = new String[6];
    private String spaces;

    public BankDetails(){
        bankInfo[0] = "My Banking System";
        bankInfo[1] = "Welcome!  ";
        bankInfo[2] = LocalDate.now().toString();
        bankInfo[3] = LocalDateTime.now().toLocalTime().toString();
        bankInfo[4] = "Branch : ISB, Pakistan";
        bankInfo[5] = "Branch Code : (1024)";
        spaces = "";
    }

    public String createBankLogin() {
        String bankNameAlignment = "|             %-30s| %n";
        System.out.format("+-------------------------------------------+%n");
        System.out.format(bankNameAlignment, bankInfo[0]);
        System.out.format("+-------------------------------------------+%n");
        return bankInfo[0];
    }
    public String[] createBankScreen(){


        String bankNameAlignment = "|                   %-30s       |%n";
        String spacesAlignment = "|                   %-30s       |%n";
        String branchTitleAlignment = "|                   %-30s       |%n";
        String greetUserAlignment = "|                   %-30s       |%n";
        String dateTimeAlignment = "| %-20s %33s | %n";
        for (int i=0;i<9;i++){
            if(i==0){
                System.out.format("+--------------------------------------------------------+%n");
                System.out.format(bankNameAlignment, bankInfo[i]);
                System.out.format("+--------------------------------------------------------+%n");
            }
            else if(i==1 || i==2 || i==6 || i==7){
                System.out.format(spacesAlignment, spaces);
            }
            else if(i==3){
                System.out.format(greetUserAlignment, bankInfo[1]+UserAuth.USERNAME);
            }
            else if(i==4){
                System.out.format(branchTitleAlignment, bankInfo[i]);
            }
            else if(i==5){
                System.out.format(branchTitleAlignment,bankInfo[i]);
            }
            else {
                System.out.format(dateTimeAlignment, bankInfo[2], bankInfo[3]);
                System.out.format("+--------------------------------------------------------+%n");
            }
        }
        return bankInfo;
    }
}
