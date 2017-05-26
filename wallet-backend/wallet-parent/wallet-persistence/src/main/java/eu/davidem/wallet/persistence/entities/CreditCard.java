package eu.davidem.wallet.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity managed by Hiberante to store the data
 * 
 * @author Davide Martorana
 *
 */

@Entity
@Table(name="credit_cards")
public class CreditCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name= "card_number")
	private String cardNumber;

	@Column(name="month_exp")
	private Integer dateExpMonth;
	
	@Column(name="year_exp")
	private Integer dateExpYear;
	
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="name_holder")
	private String nameHolder;

	public CreditCard() {
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

	public Integer getDateExpMonth() {
		return dateExpMonth;
	}

	public void setDateExpMonth(Integer dateExpMonth) {
		this.dateExpMonth = dateExpMonth;
	}

	public Integer getDateExpYear() {
		return dateExpYear;
	}

	public void setDateExpYear(Integer dateExpYear) {
		this.dateExpYear = dateExpYear;
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
