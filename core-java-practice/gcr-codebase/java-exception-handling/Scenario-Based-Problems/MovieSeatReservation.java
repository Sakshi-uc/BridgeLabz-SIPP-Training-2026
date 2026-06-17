public class MovieSeatReservation {
	private int[] seats={101,102,103,104,105};
	public int getSeat(int index) {
		try {
			if(index<0||index>=seats.length) {
				throw new ArrayIndexOutOfBoundsException("Invalid seat index");
			}
			return seats[index];
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Error: "+e.getMessage());
			return -1;
		}
	}
	public static void main(String[] args) {
		MovieSeatReservation reservation=new MovieSeatReservation();
		int seat1=reservation.getSeat(2);
		System.out.println("Seat at index 2: "+seat1);
		int seat2=reservation.getSeat(8);
		System.out.println("Seat at index 8: "+seat2);
	}
}
