package com.bank.app.service;

import com.bank.app.accounts.BankaHesabi;
import com.bank.app.accounts.VadesizHesap;
import com.bank.app.accounts.YatirimHesabi;
import com.bank.app.cards.KrediKarti;
import com.bank.app.people.Musteri;

public class BankaService {
	public Musteri musteriOlustur(String ad, String soyad, String email, int telefonNumarasi) {
		Musteri musteri=new Musteri(ad,soyad,email,telefonNumarasi);
		System.out.println("Müşteri oluşturuldu.");
		return musteri;
	}
	
	//para yatırma
	public void paraYatir(YatirimHesabi hesap,double miktar) {
		hesap.paraEkle(miktar);
		System.out.println("Para yatırma işlemi başarılı.");
	}
	
	//para transferi
	public void paraTransferi(VadesizHesap gonderen, BankaHesabi alici,double miktar) {
		gonderen.paraTransferi(alici,gonderen, miktar);
		System.out.println("Transfer işlemi başarılı.");
	}
	
	// Kredi kartı oluşturma
    public void krediKartiOlustur(Musteri musteri,double limit) {
    	musteri.krediKartiEkle(limit);
    	System.out.println("Kredi kartı oluşturuldu.");
    }
    
    // Kart borcu ödeme
    public void krediKartiBorcOde(VadesizHesap hesap,KrediKarti kart, double miktar) {
    	hesap.krediKartiBorcOdeme(kart,miktar);
    	 System.out.println("Kart borcu ödendi.");
    
    	
    }

}
