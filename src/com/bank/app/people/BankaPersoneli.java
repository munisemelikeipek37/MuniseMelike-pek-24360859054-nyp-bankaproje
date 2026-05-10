package com.bank.app.people;

import java.util.ArrayList;
import java.util.Random;

public class BankaPersoneli extends Kisi {
	// Kisi sınıfından miras alınır.
	
	private String personelID;
	private ArrayList<Musteri> musteriler;
	
	public BankaPersoneli(String ad, String soyad, String email, int telefonNumarasi) {
		super(ad, soyad, email, telefonNumarasi);
		//random ıd uretimi
		Random random= new Random();
		this.personelID = "P" + (1000 + random.nextInt(9000));
		this.musteriler = new ArrayList<>();
		
	}
	public void musteriEkle(Musteri musteri) {
		musteriler.add(musteri)	;
	}
	public String getPersonelID() {
		return personelID;
	}
	
	@Override
	public String toString() {
		return "Personal ID:" + personelID;	
	}
}
