package org.enjekt.panda.panda.cipher;

import java.security.SecureRandom;

import org.enjekt.panda.cipher.VernamCipher;

public class CreditCardCipher 
{
    VernamCipher engine = new VernamCipher();
	private static final SecureRandom random = new SecureRandom();

    public Panda encipher(String pan) {
    	Panda p = new Panda();
    
    	if (LuhnChecker.isValidLuhn(pan)) {
    		p.setPAN(pan);
    		p.setCipherData(engine.encipher(pan));
    		p.setBIN(pan.substring(0,5));
    		p.setLastFour(pan.substring(pan.length()-4));
    		p.setToken(createToken(p.getBIN(),p.getLastFour(),pan));
    	}
    	return p;
    }

	private String createToken(String bin, String lastFour, String pan) {
		//Token will not be Luhn check valid. It is not a "real" credit card PAN
		String token =null;
		int rndLength = pan.length()-9;
		while (token==null || LuhnChecker.isValidLuhn(token)) {
			token=bin+getDigits(rndLength)+lastFour;
		}
		return token;
	}

	private String getDigits(int rndLength) {
		StringBuffer digits = new StringBuffer();
		for (int i=0;i<rndLength;i++) {
			digits.append(random.nextInt(9));
		}
		return digits.toString();
	}

}
