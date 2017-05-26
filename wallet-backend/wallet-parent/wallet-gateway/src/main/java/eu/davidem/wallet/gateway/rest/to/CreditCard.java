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

	private Integer dateExpMonth;
	
	private Integer dateExpYear;
	
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

	

	public Integer getDateExpMonth() {
		return dateExpMonth;
	}

	public CreditCard setDateExpMonth(Integer dateExpMonth) {
		this.dateExpMonth = dateExpMonth;
		return this;
	}

	public Integer getDateExpYear() {
		return dateExpYear;
	}

	public CreditCard setDateExpYear(Integer dateExpYear) {
		this.dateExpYear = dateExpYear;
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
