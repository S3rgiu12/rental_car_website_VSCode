package InchiriereMasini;

public class Audi extends Masina {
	private String modelAudi;
	private String culoare;
	private Integer anFabricatieAudi;
	
	public Audi(String idMasina, String marca, String model,String nrInmatriculare, String anFabricatie, Integer nrLocuri,
			Integer capacCilindric, Integer caiPutere, String disponibila, String combustibil, String managerAuto,
			String idContract, String modelAudi,String culoare,Integer anFabricatieAudi) {
		super(idMasina, marca, model, nrInmatriculare, anFabricatie, nrLocuri, capacCilindric, caiPutere, disponibila, combustibil, managerAuto
				); 
		
		this.modelAudi=modelAudi;
		this.anFabricatieAudi=anFabricatieAudi;
		this.culoare=culoare; 
		}

	public String getModelAudi() {
		return modelAudi;
	}

	public void setModelAudi(String modelAudi) {
		this.modelAudi = modelAudi;
	}

	public String getCuloare() {
		return culoare;
	}

	public void setCuloare(String culoare) {
		this.culoare = culoare;
	}

	public Integer getAnFabricatieAudi() {
		return anFabricatieAudi;
	}

	public void setAnFabricatieAudi(Integer anFabricatieAudi) {
		this.anFabricatieAudi = anFabricatieAudi;
	}

	@Override
	public String toString() {
		return "Audi [modelAudi=" + modelAudi + ", culoare=" + culoare + ", anFabricatieAudi=" + anFabricatieAudi + "]";
	}

	

	
}
