package org.enjekt.panda.cipher;

import java.security.SecureRandom;
import java.util.ArrayList;

public class VernamCipher {
	private static final SecureRandom random = new SecureRandom();
 


	public CipherData encipher(String original)  {
		char [] source = new char[original.length()];
		int[] pad = new int[original.length()];
		int [] enciphered = new int[original.length()];
		fill(original,source,pad);
		for (int i=0;i<source.length;i++) {
			enciphered[i]=source[i] ^ pad[i];
		}

		return new CipherData().setPad(pad).setEnciphered(enciphered);
	}

	public String decipher(CipherData d) {
		char[] deciphered=new char[d.enciphered.length];
		for (int i=0;i<d.enciphered.length;i++) {
			deciphered[i]=(char) (d.enciphered[i]^d.pad[i]);
		}
		return String.valueOf(deciphered);
	}
	

	private void fill(String original, char[] source, int[] pad) {
		for (int i=0;i<original.length();i++) {
			source[i]=original.charAt(i);
			pad[i]=(char) random.nextInt(255);

		}
	}



}
