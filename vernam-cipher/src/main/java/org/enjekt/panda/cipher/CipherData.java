package org.enjekt.panda.cipher;

import java.util.Arrays;

public class CipherData {

	
	int[] enciphered;
	int[] pad;

	public int[] getEnciphered() {
		return enciphered;
	}

	public CipherData setEnciphered(int[] enciphered) {
		this.enciphered = enciphered;
		return this;
	}

	public int[] getPad() {
		return pad;
	}

	public CipherData setPad(int[] pad) {
		this.pad = pad;
		return this;
	}

	@Override
	public String toString() {
		return "CipherData [enciphered=" + Arrays.toString(enciphered) + ", pad=" + Arrays.toString(pad) + "]";
	}



	

}