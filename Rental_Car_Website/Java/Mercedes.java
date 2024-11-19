package InchiriereMasini;

public class Mercedes extends Masina implements Comparable<Mercedes> {

	private Integer caiPutereMercedes;
	private String tractiuneMercedes;
	private Integer cupluMercedes;
	
	public Mercedes(String idMasina, String marca, String model,String nrInmatriculare, String anFabricatie, Integer nrLocuri,
			Integer capacCilindric, Integer caiPutere, String disponibila, String combustibil, String managerAuto,
			String idContract,Integer caiPutereMercedes,String tractiuneMercedes,Integer cupluMercedes) 
	{
		super(idMasina, marca, model, nrInmatriculare, anFabricatie, nrLocuri, capacCilindric, caiPutere, disponibila, combustibil, managerAuto
				);  
		
	}

	public Integer getCaiPutereMercedes() {
		return caiPutereMercedes; 
	}

	public void setCaiPutereMercedes(Integer caiPutereMercedes) {
		this.caiPutereMercedes = caiPutereMercedes;
	}

	public String getTractiuneMercedes() {
		return tractiuneMercedes;
	}

	public void setTractiuneMercedes(String tractiuneMercedes) {
		this.tractiuneMercedes = tractiuneMercedes;
	}

	public Integer getCupluMercedes() {
		return cupluMercedes;
	}

	public void setCupluMercedes(Integer cupluMercedes) {
		this.cupluMercedes = cupluMercedes;
	}

	@Override
	public String toString() {
		return "Mercedes [caiPutereMercedes=" + caiPutereMercedes + ", tractiuneMercedes=" + tractiuneMercedes
				+ ", cupluMercedes=" + cupluMercedes + "]";  
	}

	@Override
	public int compareTo(Mercedes objMercedes) {
	if(this.equals(objMercedes))
		return 0;
	else if (getCaiPutereMercedes()>objMercedes.getCaiPutereMercedes())
		return -1;
	else
		return 1;
	}

	

}
