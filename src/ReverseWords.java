public class ReverseWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "abc  cde hik";
		System.out.println(reverseString(string));

	}

	public static String reverseString(String s) {
		if (s.isEmpty()) {
			return null;
		} else {
			String[] items = s.trim().split(" ");
			String resultString = "";
			for (int i = items.length - 1; i > -1; i--) {
				if (!items[i].trim().isEmpty()) {
					resultString += items[i] + " ";
				}
			}
			return resultString.substring(0, resultString.length() - 1);
		}
	}

}
