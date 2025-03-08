class Spot {
    private final String spotId;
    private final String spotType;
    private boolean isOccupied;

    public Spot(String spotId, String spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.isOccupied = false;
    }

    public void occupy() { isOccupied = true; }
    public void free() { isOccupied = false; }
    public boolean isOccupied() { return isOccupied; }
    public String getSpotId() { return spotId; }
    public String getSpotType() { return spotType; }
}
