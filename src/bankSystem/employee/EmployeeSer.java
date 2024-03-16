package bankSystem.employee;

import bankSystem.account.RoleAccount;
import bankSystem.account.UserAccountDao;
import bankSystem.scanner.ScannerSingleton;

import java.util.ArrayList;

public class EmployeeSer {

    private static ArrayList<EmployeeEn> employeeEns() throws Exception {
        ArrayList<EmployeeEn> employeeEnArrayList = new ArrayList<>();
        employeeEnArrayList = EmployeeDao.select();
        return employeeEnArrayList;
    }

    public static void getMenuEmployee() {
        boolean t = true;
        while (t) {
            System.out.println("1.log in bankSystem.employee \n 2.creat an bankSystem.account \n");
            int selectUser = ScannerSingleton.getScanner().nextInt();
            switch (selectUser){
                case 1:
                    try {
                        EmployeeEn employeeEn = new EmployeeEn();
                        if (RoleAccount.BOSS.name().equals("BOSS"))
                            System.out.println("enter first name:");
                            employeeEn.setFirstName(ScannerSingleton.getScanner().next());
                            System.out.println("enter last name:");
                            employeeEn.setLastName(ScannerSingleton.getScanner().next());
                            System.out.println("enter bankSystem.employee code:");
                            employeeEn.setEmployeeCode(ScannerSingleton.getScanner().nextInt());
                            System.out.println("enter national code:");
                            employeeEn.setNationalCode(ScannerSingleton.getScanner().next());
                            System.out.println("bank code: ");
                            employeeEn.setBankCode(ScannerSingleton.getScanner().nextInt());
                            EmployeeDao.insert(employeeEn);
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    break;
                case 2:
                    try {
                        EmployeeEn employeeEn =new EmployeeEn();
                        EmployeeDao.creatAccount(employeeEn);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    break;
            }
        }

    }
}
