package com.bank.app.accounts;

public class YatirimHesabi extends BankaHesabi {
	private String hesapTuru = "Yatırım";
	
	public YatirimHesabi(double bakiye) {
        super(bakiye);
    }
	//para ekle
	public void paraEkle(double miktar) {
        this.setBakiye(this.getBakiye() + miktar); 
    }
    //para çek
    public void paraCek(double miktar) {
        if (this.getBakiye() >= miktar) {
            this.setBakiye(this.getBakiye() - miktar);
            System.out.println("Para çekilmiştir.");
        }
        else {
        	System.out.println("Yetersiz bakiye.");
        }
    }
    @Override
    public String toString() {
        // Raporun için daha açıklayıcı bir çıktı sağlar 
        return "Hesap Türü: " + hesapTuru + " | " + super.toString();
    }

}
