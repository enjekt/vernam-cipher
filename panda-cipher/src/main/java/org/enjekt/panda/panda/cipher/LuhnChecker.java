package org.enjekt.panda.panda.cipher;

public class LuhnChecker {
	public static boolean isValidLuhn(String number) {
	    int n = number.length();
	    int total = 0;
	    boolean even = true;
	    // iterate from right to left, double every 'even' value
	    for (int i = n - 2; i >= 0; i--) {
	        int digit = number.charAt(i) - '0';
	        if (digit < 0 || digit > 9) {
	            // value may only contain digits
	            return false;
	        }
	        if (even) {
	            digit <<= 1; // double value
	        }
	        even = !even;
	        total += digit > 9 ? digit - 9 : digit;
	    }
	    int checksum = number.charAt(n - 1) - '0';
	    return (total + checksum) % 10 == 0;
	}
	
}
