package model;

import java.io.Serializable;

public class Cocktail implements Serializable
{
	private Integer id;
	private Integer martini;
	private Integer tequilaSunShine;
	private Integer whiteRussian;
	private Integer magarita;	
	private Integer mojito;
	private Integer sum;
	

	public Cocktail() {
		super();
	}
	
	public Cocktail(Integer martini, Integer tequilaSunShine, Integer whiteRussian , Integer magarita , Integer mojito) {
		super();
		this.martini = martini;
		this.tequilaSunShine = tequilaSunShine;
		this.whiteRussian = whiteRussian;
		this.magarita = magarita;		
		this.mojito = mojito;
		sum=martini*280 + tequilaSunShine*300 + whiteRussian*350 + magarita*280 + mojito*250;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getMartini() {
		return martini;
	}


	public void setMartini(Integer martini) {
		this.martini = martini;
	}


	public Integer getTequilaSunShine() {
		return tequilaSunShine;
	}


	public void setTequilaSunShine(Integer tequilaSunShine) {
		this.tequilaSunShine = tequilaSunShine;
	}


	public Integer getMagarita() {
		return magarita;
	}


	public void setMagarita(Integer magarita) {
		this.magarita = magarita;
	}


	public Integer getWhiteRussian() {
		return whiteRussian;
	}


	public void setWhiteRussian(Integer whiteRussian) {
		this.whiteRussian = whiteRussian;
	}


	public Integer getMojito() {
		return mojito;
	}


	public void setMojito(Integer mojito) {
		this.mojito = mojito;
	}


	public Integer getSum() {
		sum=martini*280 + tequilaSunShine*300 + whiteRussian*350 + magarita*280 + mojito*250;
		return sum;
	}


	public void setSum(Integer sum) {		
		this.sum = sum;
	}

}
