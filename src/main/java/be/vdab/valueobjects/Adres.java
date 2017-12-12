package be.vdab.valueobjects;

import java.io.Serializable;

import javax.persistence.Embeddable;

/////WERELDWIJNEN/////

@Embeddable
public class Adres implements Serializable {

	private static final long serialVersionUID = 1L;
	private String straat;
	private String huisNr;
	private String postCode;
	private String gemeente;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// getters, geen setters - IMMUTABLE

	protected Adres() {

		// Default nullary constructor, calls nullary of super and set own var to
		// default

	}

	public Adres(String straat, String huisnr, String postcode, String gemeente) {

		this.straat = straat;
		this.huisNr = huisnr;
		this.postCode = postcode;
		this.gemeente = gemeente;

	}

	public String getStraat() {
		return straat;
	}

	public String getHuisNr() {
		return huisNr;
	}

	public String getPostcode() {
		return postCode;
	}

	public String getGemeente() {
		return gemeente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gemeente == null) ? 0 : gemeente.hashCode());
		result = prime * result + ((huisNr == null) ? 0 : huisNr.hashCode());
		result = prime * result + ((postCode == null) ? 0 : postCode.hashCode());
		result = prime * result + ((straat == null) ? 0 : straat.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Adres))
			return false;
		Adres other = (Adres) obj;
		if (gemeente == null) {
			if (other.gemeente != null)
				return false;
		} else if (!gemeente.equals(other.gemeente))
			return false;
		if (huisNr == null) {
			if (other.huisNr != null)
				return false;
		} else if (!huisNr.equals(other.huisNr))
			return false;
		if (postCode == null) {
			if (other.postCode != null)
				return false;
		} else if (!postCode.equals(other.postCode))
			return false;
		if (straat == null) {
			if (other.straat != null)
				return false;
		} else if (!straat.equals(other.straat))
			return false;
		return true;
	}

}
