class Driver {
    private final Vehicle vehicle;
    private final String paymentMethod;
    private Ticket ticket;

    public Driver(Vehicle vehicle, String paymentMethod) {
        this.vehicle = vehicle;
        this.paymentMethod = paymentMethod;
    }

    public boolean parkVehicle(ParkingSystem parkingSystem) {
        return parkingSystem.parkVehicle(this);
    }

    public Vehicle getVehicle() { return vehicle; }
    public Ticket getTicket() { return ticket; }
    public void setTicket(Ticket ticket) { this.ticket = ticket; }
    public String getPaymentMethod() { return paymentMethod; }
}
