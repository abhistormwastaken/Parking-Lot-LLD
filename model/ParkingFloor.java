class ParkingFloor {
    private final Map<String, Spot> spots = new HashMap<>();
    private final Map<String, List<Spot>> spotTypeMap = new HashMap<>();
    private final Map<Vehicle, String> vehicleSpotMap = new HashMap<>();

    public ParkingFloor() {
        spotTypeMap.put("car", new ArrayList<>());
        spotTypeMap.put("bike", new ArrayList<>());
        spotTypeMap.put("truck", new ArrayList<>());
    }

    public void addSpot(Spot spot) {
        spots.put(spot.getSpotId(), spot);
        spotTypeMap.get(spot.getSpotType()).add(spot);
    }

    public String parkVehicle(Vehicle vehicle) {
        String spotType = vehicle.getSpotType();
        for (Spot spot : spotTypeMap.get(spotType)) {
            if (!spot.isOccupied()) {
                spot.occupy();
                vehicleSpotMap.put(vehicle, spot.getSpotId());
                return spot.getSpotId();
            }
        }
        return null;
    }

    public boolean removeVehicle(Vehicle vehicle) {
        String spotId = vehicleSpotMap.get(vehicle);
        if (spotId == null) return false;
        
        Spot spot = spots.get(spotId);
        spot.free();
        vehicleSpotMap.remove(vehicle);
        return true;
    }
}
