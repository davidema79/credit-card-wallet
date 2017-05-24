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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getDateExp() {
		return dateExp;
	}

	public void setDateExp(String dateExp) {
		this.dateExp = dateExp;
	}
	
	
	
}
