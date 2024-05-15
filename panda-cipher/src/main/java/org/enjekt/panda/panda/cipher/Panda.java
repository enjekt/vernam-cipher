package org.enjekt.panda.panda.cipher;

import org.enjekt.panda.cipher.CipherData;

public class Panda {

	String PAN, BIN, lastFour,token;
	CipherData cipherData;
	public Panda setCipherData(CipherData cipherData) {
		this.cipherData=cipherData;
		return this;
	}
	public String getPAN() {
		return PAN;
	}
	public Panda setPAN(String pAN) {
		PAN = pAN;
		return this;
	}
	public String getBIN() {
		return BIN;
	}
	public Panda setBIN(String bIN) {
		BIN = bIN;
		return this;
	}
	public String getLastFour() {
		return lastFour;
	}
	public Panda setLastFour(String lastFour) {
		this.lastFour = lastFour;
		return this;
	}
	public String getToken() {
		return token;
	}
	public Panda setToken(String token) {
		this.token = token;
		return this;
	}
	public CipherData getCipherData() {
		return cipherData;
	}
	@Override
	public String toString() {
		return "Panda [PAN=" + PAN + ", BIN=" + BIN + ", lastFour=" + lastFour + ", token=" + token + ", cipherData="
				+ cipherData + "]";
	}

}
