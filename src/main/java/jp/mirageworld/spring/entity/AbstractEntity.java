package jp.mirageworld.spring.entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@SuppressWarnings("serial")
public abstract class AbstractEntity<ID> implements Serializable {

	abstract ID getId();

	@Override
	public final String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public final int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public final boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
}
