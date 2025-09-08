package crowdfundingapp;

import java.util.Arrays;
import java.util.List;

public class CrowdfundAppMain {
    public static void main(String[] args) {
        FundingService service = new FundingService();

        // Users
        Creator manisha = new Creator(1, "Manisha", "manisha@mail.com", 1000);
        User sreya = new User(2, "Sreya", "sreya@mail.com", "Backer", 500);
        VIPBacker ram = new VIPBacker(3, "Ram", "ram@mail.com", 800);

        System.out.println("=== Users Registered ===");
        System.out.println(manisha);
        System.out.println(sreya);
        System.out.println(ram);

        // Normal Campaign
        Campaign gadget = service.createCampaign("Smart Gadget", 1000);
        gadget.addPledge(sreya, 200);
        gadget.addPledge(ram, 300, "Gold");

        // Flexible Campaign
        FlexibleCampaign flexibleBook = new FlexibleCampaign(2, "Flexible E-Book Launch", 600, new java.util.Date());
        service.getCampaigns().add(flexibleBook);
        flexibleBook.addPledge(sreya, 150);
        flexibleBook.addPledge(ram, 200, "Silver");

        System.out.println("\n=== Campaigns Before Settlement ===");
        service.showReports();

        // Settle campaigns
        gadget.settle();
        flexibleBook.settle();

        System.out.println("\n=== Campaigns After Settlement ===");
        service.showReports();

        // Top Campaign
        Campaign topCampaign = service.getTopCampaign();
        System.out.println("\nTop Campaign:");
        System.out.println(topCampaign);

        // Backer contributions
        System.out.println("\n--- Backer Contributions ---");
        List<User> backers = Arrays.asList(sreya, ram);
        for (User b : backers) {
            double total = service.getTotalContribution(b);
            System.out.println(b.getName() + " contributed: " + total);
        }

        System.out.println("\n=== Wallet Balances ===");
        System.out.println(manisha);
        System.out.println(sreya);
        System.out.println(ram);
    }
}
