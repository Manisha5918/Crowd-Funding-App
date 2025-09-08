package crowdfundingapp;

public class Creator extends User {
    private int campaignsCreated;
    private double totalEarnings;
    private String bio;
    private int rating;

    public Creator(int userId, String name, String email, double wallet) {
        super(userId, name, email, "Creator", wallet);
        this.campaignsCreated = 0;
        this.totalEarnings = 0;
        this.bio = "No bio";
        this.rating = 0;
    }

    public void addEarnings(double amt) {
        deposit(amt);
        totalEarnings += amt;
    }

    public void incrementCampaigns() { campaignsCreated++; }
    public void setBio(String bio) { this.bio = bio; }

    public int getCampaignsCreated() { return campaignsCreated; }
    public double getTotalEarnings() { return totalEarnings; }
    public int getRating() { return rating; }

    @Override
    public String toString() {
        return "Creator{" + getName() + ", wallet=" + getWallet() +
               ", campaigns=" + campaignsCreated + ", earnings=" + totalEarnings + "}";
    }
}
