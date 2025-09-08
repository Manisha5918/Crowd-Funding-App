package crowdfundingapp;

import java.util.ArrayList;

public class FundingService {
    private ArrayList<Campaign> campaigns;

    public FundingService() {
        campaigns = new ArrayList<>();
    }

    public Campaign createCampaign(String title, double goal) {
        Campaign c = new Campaign(campaigns.size() + 1, title, goal, new java.util.Date());
        campaigns.add(c);
        return c;
    }

    public void showReports() {
        for (Campaign c : campaigns) System.out.println(c);
    }

    public Campaign getTopCampaign() {
        if (campaigns.isEmpty()) return null;
        Campaign top = campaigns.get(0);
        for (Campaign c : campaigns) {
            if (c.getTotal() > top.getTotal()) top = c;
        }
        return top;
    }

    public double getTotalContribution(User backer) {
        double total = 0.0;
        for (Campaign c : campaigns) {
            for (Pledge p : c.getPledges()) {
                if (p.getBacker() == backer) total += p.getAmount();
            }
        }
        return total;
    }

    public ArrayList<Campaign> getCampaigns() { return campaigns; }
}
