public class VolumeOfEarth {
    public static void main(String[] args) {
        double pi = Math.PI;
        double radius = 6378;
        double volumeKm = (4.0 / 3)*pi*Math.pow(radius, 3);
        double volumeMiles = volumeKm*0.2399;  
        System.out.println("The volume of earth in cubic kilometers is " + volumeKm + " and cubic miles is " + volumeMiles);
    }
}