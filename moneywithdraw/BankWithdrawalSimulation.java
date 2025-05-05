public class BankWithdrawalSimulation {
    public static void main(String[] args) {
        // Setup the chain
        Approver cashier = new Cashier();
        Approver seniorOfficer = new SeniorOfficer();
        Approver manager = new Manager();

        cashier.setNextApprover(seniorOfficer);
        seniorOfficer.setNextApprover(manager);

        // Simulate withdrawals
        double[] withdrawalRequests = {5000, 50000, 2000000};

        for (double amount : withdrawalRequests) {
            System.out.println("\nRequest to withdraw Tk. " + amount);
            cashier.processRequest(amount);
        }
    }
}
