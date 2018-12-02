public class HexColor{
	public static void main(String [] args){
		
		System.out.println(hexcolor(255, 99, 71));
		System.out.println(hexcolor(184, 134, 11));
		System.out.println(hexcolor(189, 183, 107));
		System.out.println(hexcolor(0, 0, 205));
		
	}

	private static String hexcolor(int red, int green, int blue){
		StringBuilder hexColor = new StringBuilder("#");
		hexColor.append(decimalToHex(red));
		hexColor.append(decimalToHex(green));
		hexColor.append(decimalToHex(blue));
		return hexColor.toString();
	}

	private static String decimalToHex(int decimal){
		String hex = String.format("%X", decimal);
		// handle preceding zeros
		if(hex.length() == 1) hex = "0".concat(hex);
		return hex;
	}
	
}
