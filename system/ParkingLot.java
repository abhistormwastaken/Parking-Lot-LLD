class ParkingLot {
    private final List<ParkingFloor> floors;

    public ParkingLot(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public String parkVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            String spotId = floor.parkVehicle(vehicle);
            if (spotId != null) return spotId;
        }
        return null;
    }

    public boolean removeVehicle(Vehicle vehicle) {
        for (ParkingFloor floor : floors) {
            if (floor.removeVehicle(vehicle)) return true;
        }
        return false;
    }
}