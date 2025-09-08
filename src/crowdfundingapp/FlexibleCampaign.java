package crowdfundingapp;

import java.util.Date;

public class FlexibleCampaign extends Campaign {

    public FlexibleCampaign(int campaignId, String title, double goalAmount, Date deadline) {
        super(campaignId, title, goalAmount, deadline);
    }

    // Override settle(): Flexible campaign keeps funds even if goal not reached
    @Override
    public void settle() {
        if (getTotal() >= getGoalAmount()) {
            super.settle(); // FUNDED
        } else {
            // Flexible: campaign gets pledged funds, status = PARTIALLY FUNDED
            System.out.println("Flexible campaign '" + getTitle() + "' partially funded: " + getTotal());
            try {
                java.lang.reflect.Field statusField = Campaign.class.getDeclaredField("status");
                statusField.setAccessible(true);
                statusField.set(this, "PARTIALLY FUNDED");
            } catch (Exception e) { e.printStackTrace(); }
        }
    }
}
