package model;

import java.io.Serializable;

public class SoftDrink implements Serializable
{
	private Integer id;
	private Integer cola;
	private Integer soda;
	private Integer mountainDew;
	private Integer blackTea;
	private Integer appleJuice;
	private Integer sum;
	
	public SoftDrink() {
		super();
	}
	public SoftDrink(Integer cola, Integer soda, Integer mountainDew, Integer blackTea, Integer appleJuice) {
		super();
		this.cola = cola;
		this.soda = soda;
		this.mountainDew = mountainDew;
		this.blackTea = blackTea;
		this.appleJuice = appleJuice;
		sum = cola*120+soda*120+mountainDew*120+blackTea*80+appleJuice*80;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCola() {
		return cola;
	}

	public void setCola(Integer cola) {
		this.cola = cola;
	}

	public Integer getSoda() {
		return soda;
	}

	public void setSoda(Integer soda) {
		this.soda = soda;
	}

	public Integer getMountainDew() {
		return mountainDew;
	}

	public void setMountainDew(Integer mountainDew) {
		this.mountainDew = mountainDew;
	}

	public Integer getBlackTea() {
		return blackTea;
	}

	public void setBlackTea(Integer blackTea) {
		this.blackTea = blackTea;
	}

	public Integer getAppleJuice() {
		return appleJuice;
	}

	public void setAppleJuice(Integer appleJuice) {
		this.appleJuice = appleJuice;
	}

	public Integer getSum() {
		sum = cola*120+soda*120+mountainDew*120+blackTea*80+appleJuice*80;
		return sum;
	}

	public void setSum(Integer sum) {		
		this.sum = sum;
	}
	
}
