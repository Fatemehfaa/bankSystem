package bankSystem.account;

import bankSystem.Repository2;
import bankSystem.employee.EmployeeEn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserAccountDao {

    private static PreparedStatement preparedStatement;

    public UserAccountDao() {
    }

    public static void insert(UserAccountEn userAccountEn) throws Exception{
        preparedStatement = Repository2.getConnection().prepareStatement("insert into useraccount" +
                " (username,password,roleaccount) values (?,?,?)");
        preparedStatement.setString(1 , userAccountEn.getUsername());
        preparedStatement.setString(2,userAccountEn.getPassword());
        preparedStatement.setString(3,userAccountEn.getRole().name());
        preparedStatement.executeUpdate();
    }

    public static void update(UserAccountEn userAccountEn) throws Exception{
        preparedStatement =Repository2.getConnection().prepareStatement("update useraccount=?, password=? where idaccount=?");
        preparedStatement.setString(1, userAccountEn.getUsername());
        preparedStatement.setString(2, userAccountEn.getUsername());
        preparedStatement.setInt(3,userAccountEn.getIdAccount());
        preparedStatement.executeUpdate();
    }

    public static void delete(int idAccount) throws Exception{
        preparedStatement =Repository2.getConnection().prepareStatement("delete from useraccount where idaccount=?");
        preparedStatement.setInt(1,idAccount);
        preparedStatement.executeUpdate();
    }

    public static ArrayList<UserAccountEn> select() throws Exception{
        preparedStatement = Repository2.getConnection().prepareStatement("select * from useraccount");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<UserAccountEn> accountEnArrayList = new ArrayList<>();

        while(resultSet.next()){
            UserAccountEn accountEn = new UserAccountEn();
            accountEn.setIdAccount(resultSet.getInt("idAccount"));
            accountEn.setUsername(resultSet.getString("username"));
            accountEn.setPassword(resultSet.getString("password"));
            accountEnArrayList.add(accountEn);
        }
        return accountEnArrayList;
    }


}
