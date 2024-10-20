package model;

import java.io.Serializable;

public class Beer implements Serializable
{
	private Integer id;
	private Integer corona;
	private Integer budweiser;
	private Integer heineken;
	private Integer skol;
	private Integer asahi;
	private Integer sum;
	
	public Beer() {
		super();		
	}
	
	public Beer(Integer corona, Integer budweiser, Integer heineken, Integer skol, Integer asahi) {
		super();
		this.corona = corona;
		this.budweiser = budweiser;
		this.heineken = heineken;
		this.skol = skol;
		this.asahi = asahi;
		sum=corona*120+budweiser*120+heineken*110+skol*130+asahi*150;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCorona() {
		return corona;
	}

	public void setCorona(Integer corona) {
		this.corona = corona;
	}

	public Integer getBudweiser() {
		return budweiser;
	}

	public void setBudweiser(Integer budweiser) {
		this.budweiser = budweiser;
	}

	public Integer getHeineken() {
		return heineken;
	}

	public void setHeineken(Integer heineken) {
		this.heineken = heineken;
	}

	public Integer getSkol() {
		return skol;
	}

	public void setSkol(Integer skol) {
		this.skol = skol;
	}

	public Integer getAsahi() {
		return asahi;
	}

	public void setAsahi(Integer asahi) {
		this.asahi = asahi;
	}

	public Integer getSum() {
		sum=corona*120+budweiser*120+heineken*110+skol*130+asahi*150;
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}
		

}
