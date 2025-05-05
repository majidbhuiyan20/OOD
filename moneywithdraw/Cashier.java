class Cashier extends Approver {
    @Override
    public void processRequest(double amount) {
        if (amount < 10000) {
            System.out.println("Cashier approved the withdrawal of Tk. " + amount);
        } else if (nextApprover != null) {
            System.out.println("Cashier forwarded the request of Tk. " + amount + " to Senior Officer.");
            nextApprover.processRequest(amount);
        }
    }
}

class SeniorOfficer extends Approver {
    @Override
    public void processRequest(double amount) {
        if (amount >= 10000 && amount <= 1000000) {
            System.out.println("Senior Officer approved the withdrawal of Tk. " + amount);
        } else if (amount > 1000000 && nextApprover != null) {
            System.out.println("Senior Officer forwarded the request of Tk. " + amount + " to Manager.");
            nextApprover.processRequest(amount);
        } else {
            System.out.println("Senior Officer cannot approve Tk. " + amount);
        }
    }
}

class Manager extends Approver {
    @Override
    public void processRequest(double amount) {
        if (amount > 1000000) {
            System.out.println("Manager approved the withdrawal of Tk. " + amount);
        } else {
            System.out.println("Manager not needed for Tk. " + amount);
        }
    }
}
