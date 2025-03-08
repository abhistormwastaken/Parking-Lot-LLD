public class Main {
    public static void main(String[] args) {
        // Initialize parking lot with 2 floors (10 spots each)
        List<ParkingFloor> floors = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ParkingFloor floor = new ParkingFloor();
            for (int j = 0; j < 10; j++) {
                floor.addSpot(new Spot("C-" + i + "-" + j, "car"));
            }
            floors.add(floor);
        }
        
        ParkingLot parkingLot = new ParkingLot(floors);
        Map<String, Double> rates = Map.of(
            "car", 5.0,
            "bike", 2.0,
            "truck", 10.0
        );
        ParkingSystem parkingSystem = new ParkingSystem(parkingLot, rates);
        ParkingSystemOperator operator = new ParkingSystemOperator(parkingSystem);

        // Driver arrives with a car
        Driver driver = new Driver(new Car("ABC123"), "Credit Card");
        driver.parkVehicle(parkingSystem);

        // At exit
        operator.initiateExit(driver);
        operator.processPayment(driver);
        operator.openGate();
    }
}