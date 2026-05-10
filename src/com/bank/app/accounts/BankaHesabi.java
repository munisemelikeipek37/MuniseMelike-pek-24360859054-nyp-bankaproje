package com.bank.app.accounts;

import java.util.Random;

//üst hesap sınıfı
public abstract class BankaHesabi {
	private String iban;
    private double bakiye;

    public BankaHesabi(double bakiye) {
        Random random = new Random();
        // IBAN random üretilir
        this.iban = "TR" + (100000 + random.nextInt(900000));
        this.bakiye = bakiye;
    }
    public String getIban() {
    	return iban;
    }
	public double getBakiye() {
		return bakiye;
	}
	public void setBakiye(double bakiye) {
		this.bakiye= bakiye;
	}
	@Override
    public String toString() {
		return "IBAN: " + iban + " |Bakiye: " + bakiye;
	}

}
