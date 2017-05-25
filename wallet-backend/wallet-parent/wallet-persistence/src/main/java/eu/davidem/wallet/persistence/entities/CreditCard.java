package eu.davidem.wallet.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Davide Martorana
 *
 */

@Entity
@Table(name="credit_cards")
public class CreditCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name= "card_number")
	private String cardNumber;

	@Column(name="date_exp")
	private String dateExp;
	
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="name_holder")
	private String nameHolder;

	public CreditCard() {
	}
	
	public CreditCard(final String cardNumber, final String dateExp, final Long userId, final String nameHolder) {
		this.cardNumber = cardNumber;
		this.dateExp = dateExp;
		this.userId = userId;
		this.nameHolder = nameHolder;
	}

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getNameHolder() {
		return nameHolder;
	}

	public void setNameHolder(String nameHolder) {
		this.nameHolder = nameHolder;
	}
	
	
}
