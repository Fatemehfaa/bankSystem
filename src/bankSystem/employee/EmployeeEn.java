package bankSystem.employee;

import bankSystem.account.UserAccountEn;

public class EmployeeEn {
    private int id;
    private String firstName;
    private String lastName;
    private int employeeCode;
    private String nationalCode;
    private int bankCode;

    @Override
    public String toString() {
        return "EmployeeEn{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employeeCode=" + employeeCode +
                ", nationalCode='" + nationalCode + '\'' +
                ", bankCode=" + bankCode +
                '}';
    }

    public EmployeeEn() {
    }

    public int getId() {
        return id;
    }

    public EmployeeEn setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public EmployeeEn setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public EmployeeEn setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public EmployeeEn setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
        return this;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public EmployeeEn setNationalCode(String nationalCode) {
        if(nationalCode.length()!=10){
            try {
                throw new IllegalAccessException("nationalCode is not valid");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        this.nationalCode = nationalCode;
        return this;
    }

    public int getBankCode() {
        return bankCode;
    }

    public EmployeeEn setBankCode(int bankCode) {
        this.bankCode = bankCode;
        return this;
    }
}
