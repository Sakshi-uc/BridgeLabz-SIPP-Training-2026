public class ExcelSheetColumnTitle {
	public static String convertToTitle(int columnNumber) {
		StringBuilder result=new StringBuilder();
		while(columnNumber>0) {
			columnNumber--;
			result.insert(0, (char)('A'+columnNumber%26));
			columnNumber/=26;
		}
		return result.toString();
	}
	public static void main(String[] args) {
		System.out.println(convertToTitle(1));
		System.out.println(convertToTitle(26));
		System.out.println(convertToTitle(27));
		System.out.println(convertToTitle(701));
	}
}
