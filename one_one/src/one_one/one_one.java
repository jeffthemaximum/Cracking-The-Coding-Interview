// Implement an algorithm to determine if a string has all unique characters.
package one_one;
import java.util.HashMap;

public class one_one {	
	public static void main(String[] args) {
		String test_string = "pqwefopqwebfpoqwbef[oqhwepirufhqpouef2-39kbqw";
		String unique_test_string = "abcdefghijklmnopqrstuvwxyz";
		
		// test my implementation
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		System.out.println(test_overlap(hm, test_string));
		HashMap<Character, Integer> hm2 = new HashMap<Character, Integer>();
		System.out.println(test_overlap(hm2, unique_test_string));
		
		// test book implementation... lol maybe they're wrong...
		System.out.println(book_test_overlap(test_string));
		System.out.println(book_test_overlap(unique_test_string));
	}
	
	// my first solution: iterates across string one char at a time. puts chars into hashmap, then returns as soon as it finds a collision.
	public static boolean test_overlap(HashMap<Character, Integer> hash, String my_test_string) {
		int length = my_test_string.length();
		for (int i = 0; i < length; i++) {
			char test_char = my_test_string.charAt(i);
			if (hash.containsKey(test_char)){
				return false;
			}
			else {
				hash.put(test_char, 1);
			}
		}
		return true;
	}
	
	// book solution: iterates across a string one char at a time. puts bool into array at index of char's ASCII value, 
	// returns as soon as it finds a collision
	public static boolean book_test_overlap(String my_test_string){
		if (my_test_string.length() > 256) {
			return false;
		}
		boolean[] test_array = new boolean[256];
		for (int i = 0; i < my_test_string.length(); i++){
			int val = my_test_string.charAt(i);
			if (test_array[val]) {
				return false;
			}
			else {
				test_array[val] = true;
			}
		}
		return true;
	}
}
