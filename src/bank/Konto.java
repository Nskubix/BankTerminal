package bank;

public class Konto extends AccountManager {

    private int balance = 0;
    private String password;
    private String login;

    public Konto(String[] lista) {
        this.login = lista[0];
        this.password = lista[1];
        this.balance = Integer.parseInt(lista[2]);



    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

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
    public String toString() {
        return "Konto{" +
                "balance=" + balance  +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
