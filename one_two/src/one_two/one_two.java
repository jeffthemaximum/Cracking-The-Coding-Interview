package one_two;

import java.util.Arrays;

// my solution:
// sort both strings
// compare and see if equal
// ?? more optimal sorting solutions ??
public class one_two {
	public static void main(String[] args) {
		String first_string = "edcba";
		String second_string = "abcde";
		
		// check my solution
		String sorted_first_string = sort_string(first_string);
		String sorted_second_string = sort_string(second_string);
		System.out.println(check_equality(sorted_first_string, sorted_second_string));
		
		// check book solution
		System.out.println(permutations(first_string, second_string));
	}
	
	// my solution:
	// sort both strings
	// compare and see if equal
	// ?? more optimal sorting solutions ??
	public static String sort_string(String unsorted_string) {
		char[] chars = unsorted_string.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	public static boolean check_equality(String string_one, String string_two){
		if (string_one.equals(string_two)){
			return true;
		}
		else {
			return false;
		}
	}
	
	// book's fancy solution
	// first book solution involved a similar sort/compare algorithm to me...
	// fancy solution	
	// first check the lengths and see if they're equal
	// make empty int array, populate int array with how many times char exists, indexed at ASCII value of char
	// iterate over second char array, check if count of char's at respective ASCII value is equal
	// fancy "if (--letters[x]) < 0" conditional decrements count in int array
	public static boolean permutations (String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] letters = new int[256];
		char[] s_array = s.toCharArray();
		for (char c:s_array) {
			letters[c]++;
		}
		for (int i = 0; i < t.length(); i++){
			int x = (int) t.charAt(i);
			if (--letters[x] < 0){
				return false;
			}
		}
		return true;
	}
}
