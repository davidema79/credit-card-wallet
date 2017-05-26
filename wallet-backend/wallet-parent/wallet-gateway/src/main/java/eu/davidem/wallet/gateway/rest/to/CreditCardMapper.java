package eu.davidem.wallet.gateway.rest.to;

/**
 * Mappers from Persistence Data To Rest and viceversa
 * 
 * @author Davide Martorana
 *
 */
public final class CreditCardMapper {

	private CreditCardMapper() {
		throw new IllegalAccessError("CreditCardMapper cannot be instanciate at Runtime");
	}
	
	public final static CreditCard mapToRestTO(final eu.davidem.wallet.persistence.entities.CreditCard entity){
		return new CreditCard()
				.setCardNumber(entity.getCardNumber())
				.setDateExpMonth(entity.getDateExpMonth())
				.setDateExpYear(entity.getDateExpYear())
				.setId(entity.getId())
				.setNameHolder(entity.getNameHolder());
	}
	
}
