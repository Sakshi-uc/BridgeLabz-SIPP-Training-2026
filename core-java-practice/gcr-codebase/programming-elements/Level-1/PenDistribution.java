public class PenDistribution {
    public static void main(String[] args) {
        int pen= 14;
        int st= 3;
        int penPerSt= pen/st;
        int rem= pen% st;
        System.out.println("The Pen Per Student is " + penPerSt + " and the remaining pen not distributed is " + rem);
    }
}