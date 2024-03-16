package bankSystem.employee;

import bankSystem.Repository2;
import bankSystem.scanner.ScannerSingleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmployeeDao {
    private static PreparedStatement preparedStatement;

    public EmployeeDao() {
    }

    public static void insert(EmployeeEn employeeEn) throws Exception {
        preparedStatement = Repository2.getConnection().prepareStatement("insert into bank (id , firstName," +
                "lastName,employeeCode,nationalCode,bankCode)values (?,?,?,?,?,?)");
        preparedStatement.setInt(1, employeeEn.getId());
        preparedStatement.setString(2, employeeEn.getFirstName());
        preparedStatement.setString(3, employeeEn.getLastName());
        preparedStatement.setInt(4, employeeEn.getEmployeeCode());
        preparedStatement.setString(5, employeeEn.getNationalCode());
        preparedStatement.setInt(6, employeeEn.getBankCode());
        preparedStatement.executeUpdate();
    }

    public static void update(EmployeeEn employeeEn) throws Exception {
        preparedStatement = Repository2.getConnection().prepareStatement("update bank set firstName =? ,lastName=?" +
                "employeeCode=?,nationalCode=?,nationalCode=?,bankCode=? where id=?");
        preparedStatement.setString(1, employeeEn.getFirstName());
        preparedStatement.setString(2, employeeEn.getLastName());
        preparedStatement.setInt(3, employeeEn.getEmployeeCode());
        preparedStatement.setString(4, employeeEn.getNationalCode());
        preparedStatement.setInt(5, employeeEn.getBankCode());
        preparedStatement.setInt(6, employeeEn.getId());
        preparedStatement.executeUpdate();
    }

    public static void delete(int id) throws Exception {
        preparedStatement = Repository2.getConnection().prepareStatement("delete bank where id =?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }


    public static ArrayList<EmployeeEn> select() throws Exception {
        preparedStatement = Repository2.getConnection().prepareStatement("select * from bank");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<EmployeeEn> employeeEns = new ArrayList<>();
        while (resultSet.next()) {

            EmployeeEn employeeEn = new EmployeeEn();
            employeeEn.setId(resultSet.getInt("id"));
            employeeEn.setFirstName(resultSet.getString("firstName"));
            employeeEn.setLastName(resultSet.getString("lastName"));
            employeeEn.setEmployeeCode(resultSet.getInt("employeeCode"));
            employeeEn.setNationalCode(resultSet.getString("nationalCode"));
            employeeEn.setBankCode(resultSet.getInt("bankCode"));
            employeeEns.add(employeeEn);
        }
        return employeeEns;
    }

    public static void creatAccount() throws Exception{
        preparedStatement = Repository2.getConnection().prepareStatement("insert into userAccount(idaccount,accountNumber,firstname" +
                ",lastname,nationalCode) values (?,?,?,?,?)");
        preparedStatement.setInt(1, ScannerSingleton.getScanner().nextInt());
        preparedStatement.setLong(2,ScannerSingleton.getScanner().nextLong());
        preparedStatement.setString(3,ScannerSingleton.getScanner().next());
        preparedStatement.setString(4,ScannerSingleton.getScanner().next());
        preparedStatement.executeUpdate();

    }



}
