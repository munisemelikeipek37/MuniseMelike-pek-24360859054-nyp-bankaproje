package com.bank.app.main;

import com.bank.app.people.*;
import com.bank.app.accounts.*;
import com.bank.app.cards.KrediKarti;
import com.bank.app.service.BankaService;
public class Main {

	public static void main(String[] args) {
		//müşteri oluşturma
		Musteri musteri = new Musteri("Melike", "İpek", "ipek@gmail.com", 537373373);
		System.out.println("Müşteri kaydedildi:"+ musteri);
		
		//rastgele oluşturulan musteri numarası yazdırılır
		System.out.println("Müşteri no:"+ musteri.getmusteriNumarasi());
		
		//müşteri adına hesap açma
		musteri.hesapEkle("vadesiz", 7500);
		musteri.hesapEkle("yatirim", 10000);
		BankaHesabi h1 = musteri.getHesaplar().get(0);
        BankaHesabi	h2 = musteri.getHesaplar().get(1);
        System.out.println("hesaplar açıldı: \n1."+h1+"\n2."+h2);
        
        //hesaba para yatırma
        System.out.println("--Hesaba Para Yatırılıyor.");
        h1.setBakiye(h1.getBakiye() + 1000);
        System.out.println("Yeni Bakiye: " + h1.getBakiye());
        
        //hesaplar arası para transferi
        System.out.println("--Transfer Yapılıyor.");
        ((VadesizHesap) h1).paraTransferi(h2, h1, 1500);
        System.out.println("H1 Güncel Bakiye: " + h1.getBakiye());
        System.out.println("H2 Güncel Bakiye: " + h2.getBakiye());
        
        //müşteriye kredi kartı tanımlama
        musteri.krediKartiEkle(15000);
        KrediKarti kart =musteri.getKrediKartlari().get(0);
        kart.setGuncelBorc(4000);
        System.out.println("--Kredi Kartı Tanımlandı:"+kart);
        
        //kredikartı borç ödeme
        System.out.println("--Borç Ödeniyor.");
        ((VadesizHesap) h1).krediKartiBorcOdeme(kart, 2000);
        System.out.println("Kalan Kart Borcu: " + kart.getGuncelBorc());
        System.out.println("H1 Kalan Bakiye: " + h1.getBakiye());
        
        //hesap silme bakiyesi olan çünkü hata vermesi lazım
        System.out.print("Bakiyesi olan H1 siliniyor: ");
        musteri.hesapSil(h1);
        
        //hesap silme bakiyeyi sıfırlayıp
        h1.setBakiye(0);
        System.out.print("Bakiyesi sıfırlanan H1 tekrar siliniyor: ");
        musteri.hesapSil(h1);
        System.out.println("Kalan hesap sayısı: " + musteri.getHesaplar().size());
        
	}

}
