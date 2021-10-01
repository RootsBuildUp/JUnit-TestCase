package com.rashed.testcaseproject.model;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Abstract entity structure which contains the UUID identifier (as String)
 * generated by application and then stored in database. <br>
 * 
 * @author Imtiaz Rahi
 * @since 2021-01-18
 * @param <T> Entity type
 * @see AbstractEntity
 */
@MappedSuperclass
public abstract class AbstractEntityStringId<T extends AbstractEntityStringId<T>> extends AbstractEntity<T> {

	/** Unique object reference / identifier. Generated using UUID generator. */
	@JsonView({ JsonViews.Brief.class, JsonViews.Small.class })
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	String id;

	public String getId() {
		return id;
	}

	@SuppressWarnings("unchecked")
	public T setId(String id) {
		this.id = id;
		return (T) this;
	}

}