package com.infybuzz.app.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import javax.persistence.*;
import java.util.stream.Stream;

@Entity
@Table(name = "address")
public class Address {
	public enum Color {
		RED, BLUE, GREEN;

	}


	public enum Cylinders {
		TWO("2"), FOUR("4"), SIX("6"), EIGHT("8");

		public final String value;

		Cylinders(String value) {
			this.value = value;
		}

		@JsonCreator
		public static Cylinders decode(final String cylinders) {
			return Stream.of(Cylinders.values()).filter(targetEnum -> targetEnum.value.equals(cylinders)).findFirst().orElse(null);
		}

		@JsonValue
		public String getValue() {
			return value;
		}
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "street")
	private String street;

	@Column(name = "city")
	private String city;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


}
