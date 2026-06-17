public class SensorReadings {
	public static boolean isStrictlyIncreasing(int[] readings) {
		return isStrictlyIncreasingHelper(readings, 0);
	}
	private static boolean isStrictlyIncreasingHelper(int[] readings, int index) {
		if(index==readings.length-1) {
			return true;
		}
		if(readings[index]>=readings[index+1]) {
			return false;
		}
		return isStrictlyIncreasingHelper(readings, index+1);
	}
	public static void main(String[] args) {
		int[] readings1={12,15,18,22,30};
		int[] readings2={12,15,14,22};
		System.out.println(isStrictlyIncreasing(readings1));
		System.out.println(isStrictlyIncreasing(readings2));
	}
}
