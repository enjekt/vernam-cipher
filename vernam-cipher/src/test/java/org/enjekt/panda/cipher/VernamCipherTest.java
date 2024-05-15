package org.enjekt.panda.cipher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class VernamCipherTest {
	String original = "4929695988240755";
	/**
	 */
	@Test
	public void basicEncipher() {
		VernamCipher cipherEngine = new VernamCipher();
		CipherData d = cipherEngine.encipher(original);
		System.out.println(d);
		var dec=cipherEngine.decipher(d);
		System.out.println(dec);
		assertEquals(original,dec);
	}
}
