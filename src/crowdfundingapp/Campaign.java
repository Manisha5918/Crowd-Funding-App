package crowdfundingapp;

import java.util.ArrayList;
import java.util.Date;

public class Campaign {
    private int campaignId;
    private String title;
    private double goalAmount;
    private String status;
    private ArrayList<Pledge> pledges;
    private Date deadline;

    public Campaign(int campaignId, String title, double goalAmount, Date deadline) {
        this.campaignId = campaignId;
        this.title = title;
        this.goalAmount = goalAmount;
        this.status = "ACTIVE";
        this.pledges = new ArrayList<>();
        this.deadline = deadline;
    }

    public void addPledge(User backer, double amt) {
        addPledge(backer, amt, "Standard");
    }

    public void addPledge(User backer, double amt, String reward) {
        if (backer.withdraw(amt)) {
            if (backer instanceof VIPBacker) {
                ((VIPBacker) backer).cashback(amt);
            }
            pledges.add(new Pledge(pledges.size() + 1, backer, amt, reward));
        }
    }

    public double getTotal() { return pledges.stream().mapToDouble(Pledge::getAmount).sum(); }
    public double progress() { return (getTotal() / goalAmount) * 100; }

    public void settle() {
        if (getTotal() >= goalAmount) status = "FUNDED";
        else status = "FAILED";
    }

    public String getTitle() { return title; }
    public ArrayList<Pledge> getPledges() { return pledges; }
    public String getStatus() { return status; }
    public double getGoalAmount() { return goalAmount; }
    public Date getDeadline() { return deadline; }

    @Override
    public String toString() {
        return "Campaign{" + title + ", goal=" + goalAmount +
               ", pledged=" + getTotal() + ", progress=" + String.format("%.1f", progress()) +
               "%, status=" + status + "}";
    }
}
