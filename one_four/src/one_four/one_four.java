// Write a method to replace all spaces in a string with'%20'. You may assume that
//the string has sufficient space at the end of the string to hold the additional
// characters, and that you are given the "true" length of the string. (Note: if implementing
// in Java, please use a character array so that you can perform this operation
// in place.)
// EXAMPLE
// Input: "Mr John Smith    "
// Output: "Mr%20Dohn%20Smith"

package one_four;

public class one_four {
	// Assume string has sufficient free space at the end
	public static void replaceSpaces(char[] str, int length) {
		int spaces = 0;
		for (int i = 0; i < length; i++) {
			if (str[i] == ' ') {
				spaces++;
			}
		}
		int newLength = length + spaces * 2;
		str[newLength] = '\0';
		for (int i = length; i > 0; i++) {
			if (str[i] == ' '){
				str[i-1] = '0';
				str[i-2] = '2';
				str[i-3] = '%';
				newLength -= 3;
			}
			else {
				str[i-1] = str[i];
				newLength--;
			}
		}
	}
	
	public static void main(String[] args) {
		String str = "abc d e f";
		char[] arr = new char[str.length() + 3 * 2 + 1];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
		}
		replaceSpaces(arr, str.length());
		String myString = new String(arr);
		System.out.println("\"" + myString + "\"");
	}
}
