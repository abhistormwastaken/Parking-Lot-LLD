class Truck implements Vehicle {
    private final String licensePlate;

    public Truck(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String getType() { return "Truck"; }

    @Override
    public String getLicensePlate() { return licensePlate; }

    @Override
    public String getSpotType() { return "truck"; }
}
