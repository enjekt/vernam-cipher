package org.enjekt.panda.panda.cipher;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.enjekt.panda.panda.cipher.CreditCardCipher;
import org.enjekt.panda.panda.cipher.Panda;
import org.junit.jupiter.api.Test;

public class CreditCardCipherTest {
	String knownGood = "4929695988240757";
	String knownBad = "4929695988240755";

	@Test
	public void testCreditCardEncipherDecipher() {
		CreditCardCipher engine = new CreditCardCipher();
		
		Panda p = engine.encipher(knownGood);
		assertNotNull(p.getCipherData().getEnciphered());
		
		System.out.println(p);
		
		
		p = engine.encipher(knownBad);
		assertNull(p.cipherData);
	}
}
