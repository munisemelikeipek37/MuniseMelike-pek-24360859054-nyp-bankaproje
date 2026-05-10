package com.bank.app.people;

import com.bank.app.accounts.*;
import com.bank.app.cards.KrediKarti;
import java.util.ArrayList;
import java.util.Random;
//müsteri sınıfı
public class Musteri extends Kisi {
	
	private String musteriNumarasi;
	
	//müşteri hesapları
	private ArrayList<BankaHesabi>hesaplar;
	//müşteri kredi kartları
	private ArrayList<KrediKarti>krediKartlari;
	
	public Musteri(String ad, String soyad, String email,  int telefonNumarasi) {
        super(ad, soyad, email, telefonNumarasi);
        Random random= new Random();
        this.musteriNumarasi= "M" + (10000 + random.nextInt(90000));
        this.hesaplar = new ArrayList<>();
        this.krediKartlari = new ArrayList<>();
	}
	//hesap ekleme
	public void hesapEkle(String hesapTuru, double bakiye) {

        if(hesapTuru.equalsIgnoreCase("vadesiz")) {
            hesaplar.add(new VadesizHesap(bakiye));
        }
        else if(hesapTuru.equalsIgnoreCase("yatirim")) {
            hesaplar.add(new YatirimHesabi(bakiye));
        }
    }
	//hesap silme
	public void hesapSil(BankaHesabi hesap) {

	        if(hesap.getBakiye() > 0) {
	            System.out.println("Lütfen öncelikle bakiyenizi başka bir hesaba aktarınız.");
	        }
	        else {
	            hesaplar.remove(hesap);
	            System.out.println("Hesabınız silindi.");
	        }
	}
	//kredi kartı ekleme	
	public void krediKartiEkle(double limit) {
	        krediKartlari.add(new KrediKarti(limit, 0));
	     
	} 
	//kredi kartı silme
	public void krediKartiSil(KrediKarti kart) {
		 if(kart.getGuncelBorc() == 0) {
             krediKartlari.remove(kart);
             System.out.println("Kartınız silindi.");
         }
         else {
             System.out.println("Lütfen öncelikle borç ödemesi yapınız.");
         }
	 }
	 public ArrayList<BankaHesabi> getHesaplar() {
	        return hesaplar;
	 }

	 public ArrayList<KrediKarti> getKrediKartlari() {
	        return krediKartlari;
	 }
	 public String getmusteriNumarasi() {
	    	return musteriNumarasi;
	 }

	 @Override
	 public String toString() {
	        return super.toString() + " |Müşteri No: " + musteriNumarasi;
	    }
	}
