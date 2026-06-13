public class NullPointerDemo{
	public static void generateException(){
		String text=null;
		System.out.println(text.length());
	}
	public static void handleException(){
		String text=null;
		try{
			System.out.println(text.length());
		}catch(NullPointerException e){
			System.out.println("NullPointerException caught: "+e.getMessage());
		}
	}
	public static void main(String[] args){
		System.out.println("--- Generating NullPointerException ---");
		generateException();
		System.out.println("--- Handling NullPointerException ---");
		handleException();
	}
}
