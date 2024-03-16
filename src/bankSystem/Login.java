package bankSystem;

import bankSystem.account.RoleAccount;
import bankSystem.account.UserAccountDao;
import bankSystem.account.UserAccountEn;
import bankSystem.scanner.ScannerSingleton;

public class Login {

    public static void loginMenu(){
        System.out.println("enter username :");
        String username= ScannerSingleton.getScanner().next();

        UserAccountEn userAccount = UserAccountDao.getAccountByUsername(username);
        if (userAccount == null)
            throw new RuntimeException("account by username not found .... ");

        System.out.println("enter password :");
        String pass=ScannerSingleton.getScanner().next();
        if (userAccount.getPassword().equalsIgnoreCase(pass)){
            if(userAccount.getRole().name().equals(RoleAccount.BOSS.name())){
                System.out.println("menu Boss");


            } else if (userAccount.getRole().name().equals(RoleAccount.EMPLOYEE.name())) {
                System.out.println("menu Employee: ");


            } else if (userAccount.getRole().name().equals(RoleAccount.CUSTOMER.name())) {
                System.out.println("menu customer: ");


            }
        }else
            throw new RuntimeException("username or password is not valid .... ");

    }
}




