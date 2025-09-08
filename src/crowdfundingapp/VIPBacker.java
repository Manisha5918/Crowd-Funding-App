package crowdfundingapp;

public class VIPBacker extends User {
    private double cashbackPercent;
    private int vipLevel;
    private int rewardPoints;
    private String perks;

    public VIPBacker(int userId, String name, String email, double wallet) {
        super(userId, name, email, "VIPBacker", wallet);
        this.cashbackPercent = 5.0;
        this.vipLevel = 1;
        this.rewardPoints = 0;
        this.perks = "Priority Support";
    }

    public void cashback(double amt) {
        double cb = amt * cashbackPercent / 100;
        deposit(cb);
        rewardPoints += (int) amt / 10;
    }

    public void upgradeLevel() {
        vipLevel++;
        cashbackPercent += 1.0;
    }

    public double getCashbackPercent() { return cashbackPercent; }
    public int getVipLevel() { return vipLevel; }
    public int getRewardPoints() { return rewardPoints; }
    public String getPerks() { return perks; }
    public void setPerks(String perks) { this.perks = perks; }

    @Override
    public String toString() {
        return super.toString() + " VIPLevel=" + vipLevel + " Cashback=" + cashbackPercent + "% Points=" + rewardPoints;
    }
}
