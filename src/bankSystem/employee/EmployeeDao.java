package bankSystem.employee;

import bankSystem.Repository2;
import bankSystem.account.RoleAccount;
import bankSystem.scanner.ScannerSingleton;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmployeeDao {
    private static PreparedStatement preparedStatement;

    public EmployeeDao() {
    }

    public static void insert(EmployeeEn employeeEn) throws Exception {
        preparedStatement = Repository2.getConnection().prepareStatement("insert into employee (idEmployee , firstName," +
                "lastName,employeeCode,nationalCode,bankCode,roleAccount)values (?,?,?,?,?,?,?)");
        preparedStatement.setInt(1, employeeEn.getIdEmployee());
        preparedStatement.setString(2, employeeEn.getFirstName());
        preparedStatement.setString(3, employeeEn.getLastName());
        preparedStatement.setInt(4, employeeEn.getEmployeeCode());
        preparedStatement.setString(5, employeeEn.getNationalCode());
        preparedStatement.setInt(6, employeeEn.getBankCode());
        preparedStatement.setString(7, RoleAccount.BOSS.name());
        preparedStatement.executeUpdate();
    }

    public static void update(EmployeeEn employeeEn) throws Exception {
        preparedStatement = Repository2.getConnection().prepareStatement("update employee set firstName =? ,lastName=?" +
                "employeeCode=?,nationalCode=?,nationalCode=?,bankCode=? where idEmployee=?");
        preparedStatement.setString(1, employeeEn.getFirstName());
        preparedStatement.setString(2, employeeEn.getLastName());
        preparedStatement.setInt(3, employeeEn.getEmployeeCode());
        preparedStatement.setString(4, employeeEn.getNationalCode());
        preparedStatement.setInt(5, employeeEn.getBankCode());
        preparedStatement.setInt(6, employeeEn.getIdEmployee());
        preparedStatement.executeUpdate();
    }

    public static void delete(int id) throws Exception {
        preparedStatement = Repository2.getConnection().prepareStatement("delete employee where id =?");
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }


    public static ArrayList<EmployeeEn> select() throws Exception {
        preparedStatement = Repository2.getConnection().prepareStatement("select * from employee ");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<EmployeeEn> employeeEns = new ArrayList<>();
        while (resultSet.next()) {

            EmployeeEn employeeEn = new EmployeeEn();
            employeeEn.setIdEmployee(resultSet.getInt("idEmployee"));
            employeeEn.setFirstName(resultSet.getString("firstName"));
            employeeEn.setLastName(resultSet.getString("lastName"));
            employeeEn.setEmployeeCode(resultSet.getInt("employeeCode"));
            employeeEn.setNationalCode(resultSet.getString("nationalCode"));
            employeeEn.setBankCode(resultSet.getInt("bankCode"));
            employeeEns.add(employeeEn);
        }
        return employeeEns;
    }

    public static void creatAccount(EmployeeEn employeeEn) throws Exception {
        preparedStatement = Repository2.getConnection().prepareStatement("insert into userAccount(idaccount,accountNumber,firstname" +
                ",lastname,nationalCode) values (?,?,?,?,?)");
        preparedStatement.setInt(1, employeeEn.getIdEmployee());
        preparedStatement.setString(3, employeeEn.getFirstName());
        preparedStatement.setString(4, employeeEn.getLastName());
        preparedStatement.setString(5,employeeEn.getNationalCode());
        preparedStatement.executeUpdate();
    }

}

