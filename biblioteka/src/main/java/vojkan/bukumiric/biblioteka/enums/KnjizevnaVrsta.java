package vojkan.bukumiric.biblioteka.enums;

public enum KnjizevnaVrsta {
	Pisac("Pisac"), Pesnik("Pesnik");

	private String vrsta;

	private KnjizevnaVrsta(String vrsta) {
		this.vrsta = vrsta;
	}

	public String getVrsta() {
		return vrsta;
	}

	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}

}
