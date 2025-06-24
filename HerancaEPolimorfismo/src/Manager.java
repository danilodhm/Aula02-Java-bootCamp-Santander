
public non-sealed class Manager extends Employee{

    private String login;

    private String password;

    private int commission;
    
    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
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
}
