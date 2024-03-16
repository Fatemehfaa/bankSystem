package bankSystem.account;

// login
public class UserAccountEn {
    private int idAccount;
    private String username;
    private String password;
    private RoleAccount role;
/*
    private EmployeeEn employee;


    public EmployeeEn getEmployee() {
        return employee;
    }

    public UserAccountEn setEmployee(EmployeeEn employee) {
        this.employee = employee;
        return this;
    }

*/


    public UserAccountEn() {
    }

    public int getIdAccount() {
        return idAccount;
    }

    public UserAccountEn setIdAccount(int idAccount) {
        this.idAccount = idAccount;
        return this;
    }

    public UserAccountEn(String username, String password, RoleAccount role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public UserAccountEn setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserAccountEn setPassword(String password) {
        this.password = password;
        return this;
    }

    public RoleAccount getRole() {
        return role;
    }

    public UserAccountEn setRole(RoleAccount role) {
        if (role.equals("BOSS")) {
            this.setUsername("admin");
            this.setPassword("1234");
            this.role =role;

        }
        return this;
    }

    @Override
    public String toString() {
        return "UserAccountEn{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }

}
