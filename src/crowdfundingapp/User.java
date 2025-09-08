package crowdfundingapp;

public class User {
    private int userId;
    private String name;
    private String email;
    private String role;
    private double wallet;

    public User(int userId, String name, String email, String role, double wallet) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.role = role;
        this.wallet = wallet;
    }

    public boolean withdraw(double amt) {
        if (amt <= wallet) {
            wallet -= amt;
            return true;
        }
        return false;
    }

    public void deposit(double amt) {
        wallet += amt;
    }

    public int getUserId() { return userId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
    public double getWallet() { return wallet; }

    public void setRole(String role) { this.role = role; }

    @Override
    public String toString() {
        return role + "{" + name + ", wallet=" + wallet + "}";
    }
}
