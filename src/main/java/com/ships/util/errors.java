package com.ships.util;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class errors {
	@Id
	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
