class ChargingStation {
    static int totalStations = 0;
    static double electricityRate = 10.5;

    private String stationId;
    private double unitsConsumed;

    public ChargingStation(String stationId, double unitsConsumed) {
        this.stationId = stationId;
        this.unitsConsumed = unitsConsumed;
        totalStations++;
    }

    public double calculateBill() {
        return unitsConsumed * electricityRate;
    }

    public void displayStationDetails() {
        System.out.println("Station: " + stationId +
                ", Units: " + unitsConsumed +
                ", Bill: Rs." + calculateBill());
    }
}

public class ChargingStationDemo {
    public static void main(String[] args) {
        ChargingStation[] stations = {
                new ChargingStation("C1", 100),
                new ChargingStation("C2", 150),
                new ChargingStation("C3", 120),
                new ChargingStation("C4", 180),
                new ChargingStation("C5", 90)
        };

        for (ChargingStation s : stations) {
            s.displayStationDetails();
        }

        System.out.println("Total Stations: " + ChargingStation.totalStations);

        ChargingStation.electricityRate = 10;

        System.out.println("\nAfter Rate Change:");
        for (ChargingStation s : stations) {
            s.displayStationDetails();
        }
    }
}
