class Bike implements Vehicle {
    private final String licensePlate;

    public Bike(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String getType() { return "Bike"; }

    @Override
    public String getLicensePlate() { return licensePlate; }

    @Override
    public String getSpotType() { return "bike"; }
}
