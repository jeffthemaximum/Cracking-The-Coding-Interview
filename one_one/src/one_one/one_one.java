// Implement an algorithm to determine if a string has all unique characters.
package one_one;
import java.util.HashMap;

public class one_one {	
	public static void main(String[] args) {
		String test_string = "pqwefopqwebfpoqwbef[oqhwepirufhqpouef2-39kbqw";
		String unique_test_string = "abcdefghijklmnopqrstuvwxyz";
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		System.out.println(test_overlap(hm, test_string));
		HashMap<Character, Integer> hm2 = new HashMap<Character, Integer>();
		System.out.println(test_overlap(hm2, unique_test_string));
	}
	
	// iterates across string one char at a time. puts chars into hashmap, then returns as soon as it finds a collision.
	public static boolean test_overlap(HashMap<Character, Integer> hash, String my_test_string) {
		for (int i = 0; i < my_test_string.length(); i++) {
			if (hash.containsKey(my_test_string.charAt(i))){
				return false;
			}
			else {
				hash.put(my_test_string.charAt(i), 1);
			}
		}
		return true;
	}
}
