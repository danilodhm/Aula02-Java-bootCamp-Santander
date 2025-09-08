
public non-sealed class Manager extends Employee{

    private String login;
    private String password;
    private double commission;

    public Manager(String name, String code, String address, int age, double salary,
                    String login, String password, double commission) {
        super(name, code, address, age, salary);
        this.login = login;
        this.password = password;
        this.commission = commission;
    }
    
    public Manager() {
    }

    @Override
    public String getCode(){
        return "MN_" + super.getCode();
    }

    
    public double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public double getFullSalary() {
        return this.salary + this.commission;
    }

    
}
