package com.titanhelix.mathematica.dataaccessobjects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gcd {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer gcd;

	public Gcd() {
	}

	public Gcd(Integer gcd) {
		this.gcd = gcd;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getGcd() {
		return gcd;
	}

	public void setGcd(Integer gcd) {
		this.gcd = gcd;
	}

}
