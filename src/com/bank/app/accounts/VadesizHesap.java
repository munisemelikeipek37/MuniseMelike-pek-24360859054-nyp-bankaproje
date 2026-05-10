package com.bank.app.accounts;

import com.bank.app.cards.KrediKarti;

public class VadesizHesap extends BankaHesabi {
	private String hesapTuru = "Vadesiz";
	
	public VadesizHesap(double bakiye) {
        super(bakiye);
    }
	//para transfer işlemi
	public void paraTransferi(BankaHesabi alici, BankaHesabi gonderen, double miktar) {
        if (gonderen.getBakiye() >= miktar) {
            gonderen.setBakiye(gonderen.getBakiye() - miktar); 
            alici.setBakiye(alici.getBakiye() + miktar); 
            System.out.println("Transfer başarılı.");
        }
        else {
        	System.out.println("Yetersiz bakiye.");
        }
	}
	//kredi kartı borç ödeme
	public void krediKartiBorcOdeme(KrediKarti kart, double miktar) {
		if(this.getBakiye() >= miktar) {
			this.setBakiye(this.getBakiye() - miktar);
			kart.setGuncelBorc(kart.getGuncelBorc() - miktar);
			System.out.println("Borç ödendi.");
		}
		else {
			System.out.println("Yetersiz bakiye.");
		}
	}
	@Override
    public String toString() {
        // Üst sınıftaki IBAN ve bakiye bilgilerine hesap türünü ekleniyor 
        return "Hesap Türü: " + hesapTuru + " | " + super.toString();
    }
}
