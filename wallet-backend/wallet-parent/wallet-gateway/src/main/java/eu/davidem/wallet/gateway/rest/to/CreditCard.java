package eu.davidem.wallet.gateway.rest.to;

/**
 * Transporter Object for Credit Card
 * 
 * @author Davide Martorana
 *
 */
public class CreditCard {
	
	private Long id;
	
	private String cardNumber;

	private String dateExp;
	
	private String nameHolder;

	public Long getId() {
		return id;
	}

	public CreditCard setId(Long id)  {
		this.id = id;
		return this;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public CreditCard setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
		return this;
	}

	public String getDateExp() {
		return dateExp;
	}

	public CreditCard setDateExp(String dateExp) {
		this.dateExp = dateExp;
		return this;
	}

	public String getNameHolder() {
		return nameHolder;
	}

	public CreditCard setNameHolder(String nameHolder) {
		this.nameHolder = nameHolder;
		return this;
	}
	
	
	
}
