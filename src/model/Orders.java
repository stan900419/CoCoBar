package model;

import java.io.Serializable;

public class Orders implements Serializable{
	private int id;
	private String membername;
	private String memberaccount;
	private int beeramount;
	private int cocktailamount;
	private int softdrinkamount;
	private int price;
	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(String membername, String memberaccount, int beeramount, int cocktailamount, int softdrinkamount) {
		super();
		this.membername = membername;
		this.memberaccount = memberaccount;
		this.beeramount = beeramount;
		this.cocktailamount = cocktailamount;
		this.softdrinkamount = softdrinkamount;		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getMemberaccount() {
		return memberaccount;
	}

	public void setMemberaccount(String memberaccount) {
		this.memberaccount = memberaccount;
	}

	public int getBeeramount() {
		return beeramount;
	}

	public void setBeeramount(int beeramount) {
		this.beeramount = beeramount;
	}

	public int getCocktailamount() {
		return cocktailamount;
	}

	public void setCocktailamount(int cocktailamount) {
		this.cocktailamount = cocktailamount;
	}

	public int getSoftdrinkamount() {
		return softdrinkamount;
	}

	public void setSoftdrinkamount(int softdrinkamount) {
		this.softdrinkamount = softdrinkamount;
	}

	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	public void setPrice(int beersum, int cocktailsum, int softdrinksum) {
		this.price = (int)((beersum + cocktailsum + softdrinksum)*1.1);
	}
	

}
