package crowdfundingapp;

import java.util.Date;

public class Pledge {
    private int pledgeId;
    private User backer;
    private double amount;
    private String rewardTier;
    private Date date;

    public Pledge(int pledgeId, User backer, double amount, String rewardTier) {
        this.pledgeId = pledgeId;
        this.backer = backer;
        this.amount = amount;
        this.rewardTier = rewardTier;
        this.date = new Date();
    }

    public double getAmount() { return amount; }
    public User getBacker() { return backer; }
    public String getRewardTier() { return rewardTier; }
    public int getPledgeId() { return pledgeId; }
    public Date getDate() { return date; }

    @Override
    public String toString() {
        return "Pledge#" + pledgeId + " by " + backer.getName() +
               ", amount=" + amount + ", tier=" + rewardTier + ", date=" + date;
    }
}
