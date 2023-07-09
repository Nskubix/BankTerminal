package bank;

public class Konto extends AccountManager {

    private int balance = 0;
    private String password;
    private String login;

    public int getBalance() {
        return balance;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public void createAccount(){

    }

}
