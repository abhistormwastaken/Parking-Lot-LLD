class Ticket {
    private final Vehicle vehicle;
    private final String spotId;
    private final String spotType;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double paymentDue;

    public Ticket(Vehicle vehicle, String spotId, String spotType, LocalDateTime entryTime) {
        this.vehicle = vehicle;
        this.spotId = spotId;
        this.spotType = spotType;
        this.entryTime = entryTime;
    }

    public void calculatePayment(Map<String, Double> hourlyRates) {
        if (exitTime == null) throw new IllegalStateException("Exit time not set");
        Duration duration = Duration.between(entryTime, exitTime);
        double hours = duration.toMinutes() / 60.0;
        paymentDue = hours * hourlyRates.get(spotType);
    }

    public void setExitTime(LocalDateTime exitTime) { this.exitTime = exitTime; }
    public double getPaymentDue() { return paymentDue; }
}