package bankSystem.account;

import bankSystem.scanner.ScannerSingleton;

import java.util.ArrayList;

public class UserAccountSer {

    public UserAccountSer() {
    }

    public static ArrayList<UserAccountEn> getUserAccount(){
        ArrayList<UserAccountEn> userAccountEns=new ArrayList<>();
        try{
            UserAccountDao userAccountDao=new UserAccountDao();
            userAccountEns=userAccountDao.select();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return userAccountEns;
    }


    public static void getMenuUserAccount(){
        boolean t = true;
        while(t){
            System.out.println("menu");
            System.out.println("select on item: ");
            int select = ScannerSingleton.getScanner().nextInt();
            switch(select){
                case 1:
                    try {
                        UserAccountEn userAccountEn =new UserAccountEn();
                        System.out.println("enter user name \n enter password :");
                        String Role = ScannerSingleton.getScanner().next();
                        if(Role.equals(RoleAccount.BOSS.name())){
                            userAccountEn.setUsername("admin");
                        } else if (Role.equals(RoleAccount.CUSTOMER.name())) {
                            
                        } else if (Role.equals(RoleAccount.EMPLOYEE.name())) {
                            
                        }

                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
            }

        }

    }
}




