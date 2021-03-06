/*
Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become
a2blc5a3. If the "compressed" string would not become smaller than the original
string, your method should return the original string.
*/

package one_five;

public class one_five {

	public static void main(String[] args) {
		String line = "aabcccccaaa";
		StringBuilder sb = new StringBuilder();
		char last = line.charAt(0);
		int count = 1;
		int length = line.length();
		for (int i = 1; i < length; i++) {
			if (line.charAt(i) == last) {
				count++;
			} else {
				sb.append(last);
				sb.append(count);
				count = 1;
				last = line.charAt(i);
			}
		}
		sb.append(last);
		sb.append(count);
		System.out.println(whichIsLonger(line, sb.toString()));
	}
	public static String whichIsLonger(String line, String sb) {
		if (line.length() < sb.length()) {
			return line;
		} else {
			return sb;
		}
	}
}
