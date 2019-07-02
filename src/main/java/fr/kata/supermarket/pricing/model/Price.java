package fr.kata.supermarket.pricing.model;

import java.math.BigDecimal;

import org.apache.commons.lang3.ObjectUtils;

public class Price {

	private BigDecimal value;
	private Weight unit;

	public Price(BigDecimal value, Weight unit) {
		this.value = ObjectUtils.defaultIfNull(value, BigDecimal.ZERO);
		this.unit = ObjectUtils.defaultIfNull(unit, Weight.NO_UNIT);
	}


	public Weight getUnit() {
		return unit;
	}

	public BigDecimal multiply(double quantity) {
		return value.multiply(new BigDecimal(quantity));
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		final Price other = (Price) obj;
		return ObjectUtils.equals(value, other.value) && ObjectUtils.equals(unit, other.unit);
	}

}
