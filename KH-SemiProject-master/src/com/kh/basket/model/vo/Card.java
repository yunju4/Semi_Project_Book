package com.kh.basket.model.vo;

public class Card {
	
	private int cardNo;
	private String cardCom;
	private String cardPwd;
	private String cNum;
	
	public Card() {
		super();
	}

	public Card(String cardCom, String cardPwd, String cNum) {
		super();
		this.cardCom = cardCom;
		this.cardPwd = cardPwd;
		this.cNum = cNum;
	}

	public int getCardNo() {
		return cardNo;
	}

	public void setCardNo(int cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardCom() {
		return cardCom;
	}

	public void setCardCom(String cardCom) {
		this.cardCom = cardCom;
	}

	public String getCardPwd() {
		return cardPwd;
	}

	public void setCardPwd(String cardPwd) {
		this.cardPwd = cardPwd;
	}

	public String getcNum() {
		return cNum;
	}

	public void setcNum(String cNum) {
		this.cNum = cNum;
	}

	@Override
	public String toString() {
		return "Card [cardNo=" + cardNo + ", cardCom=" + cardCom + ", cardPwd=" + cardPwd + ", cNum=" + cNum
				+ "]";
	}

	
	
	
	
}
