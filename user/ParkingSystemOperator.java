class ParkingSystemOperator {
    private final ParkingSystem parkingSystem;

    public ParkingSystemOperator(ParkingSystem parkingSystem) {
        this.parkingSystem = parkingSystem;
    }

    public boolean initiateExit(Driver driver) {
        return parkingSystem.removeVehicle(driver);
    }

    public boolean processPayment(Driver driver) {
        Ticket ticket = driver.getTicket();
        if (ticket == null) return false;
        System.out.printf("Payment of $%.2f processed via %s\n", 
                         ticket.getPaymentDue(), driver.getPaymentMethod());
        return true;
    }

    public void openGate() {
        System.out.println("Gate opened. Safe travels!");
    }
}