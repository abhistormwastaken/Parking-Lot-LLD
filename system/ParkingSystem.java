import java.util.HashMap;
import java.util.Map;

class ParkingSystem {
    private final ParkingLot parkingLot;
    private final Map<String, Double> hourlyRates;
    private final Map<String, Ticket> tickets = new HashMap<>();

    public ParkingSystem(ParkingLot parkingLot, Map<String, Double> hourlyRates) {
        this.parkingLot = parkingLot;
        this.hourlyRates = hourlyRates;
    }

    public boolean parkVehicle(Driver driver) {
        Vehicle vehicle = driver.getVehicle();
        String spotId = parkingLot.parkVehicle(vehicle);
        if (spotId == null) return false;

        Ticket ticket = new Ticket(
            vehicle, 
            spotId, 
            vehicle.getSpotType(), 
            LocalDateTime.now()
        );
        driver.setTicket(ticket);
        tickets.put(vehicle.getLicensePlate(), ticket);
        return true;
    }

    public boolean removeVehicle(Driver driver) {
        Vehicle vehicle = driver.getVehicle();
        Ticket ticket = tickets.get(vehicle.getLicensePlate());
        if (ticket == null) return false;

        ticket.setExitTime(LocalDateTime.now());
        ticket.calculatePayment(hourlyRates);
        boolean success = parkingLot.removeVehicle(vehicle);
        if (success) tickets.remove(vehicle.getLicensePlate());
        return success;
    }
}