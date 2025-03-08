class Car implements Vehicle {
    private final String licensePlate;

    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String getType() { return "Car"; }

    @Override
    public String getLicensePlate() { return licensePlate; }

    @Override
    public String getSpotType() { return "car"; }
}
