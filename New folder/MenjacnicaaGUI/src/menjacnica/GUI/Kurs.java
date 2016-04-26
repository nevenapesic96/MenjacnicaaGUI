package menjacnica.GUI;

public class Kurs {
	private String Sifra;
	private String Naziv;
	private String Prodajni;
	private String Kupovni;
	private String Srednji;
	private String SkraceniNaziv;
	public Kurs(String sifra, String naziv, String prodajni, String kupovni, String srednji, String skraceniNaziv) {
		super();
		Sifra = sifra;
		Naziv = naziv;
		Prodajni = prodajni;
		Kupovni = kupovni;
		Srednji = srednji;
		SkraceniNaziv = skraceniNaziv;
	}
	public String getSifra() {
		return Sifra;
	}
	public void setSifra(String sifra) {
		Sifra = sifra;
	}
	public String getNaziv() {
		return Naziv;
	}
	public void setNaziv(String naziv) {
		Naziv = naziv;
	}
	public String getProdajni() {
		return Prodajni;
	}
	public void setProdajni(String prodajni) {
		Prodajni = prodajni;
	}
	public String getKupovni() {
		return Kupovni;
	}
	public void setKupovni(String kupovni) {
		Kupovni = kupovni;
	}
	public String getSrednji() {
		return Srednji;
	}
	public void setSrednji(String srednji) {
		Srednji = srednji;
	}
	public String getSkraceniNaziv() {
		return SkraceniNaziv;
	}
	public void setSkraceniNaziv(String skraceniNaziv) {
		SkraceniNaziv = skraceniNaziv;
	}
	
	
}

