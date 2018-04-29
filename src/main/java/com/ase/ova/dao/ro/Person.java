package com.ase.ova.dao.ro;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.ImageView;

/**
 * Simple model class for a person.
 * 
 * @author Goga Gabriel
 */
public class Person {

	private final StringProperty idpoza;
	private final StringProperty numele;
	private final StringProperty prenumele;
	private final StringProperty sex;

	
	public Person(String idpoza, String numele, String prenumele, String sex) {
		this.idpoza = new SimpleStringProperty(idpoza);
		this.numele = new SimpleStringProperty(numele);
		this.prenumele = new SimpleStringProperty(prenumele);
		this.sex = new SimpleStringProperty(sex);
	}
	
	
	public void setIdpoza(String idpoza) {
		this.idpoza.set(idpoza);
	}
	
	public String getIdpoza() {
		return idpoza.get();
	}
	
	public String getSex() {
		return sex.get();
	}
	
	public void setSex(String sex) {
		this.sex.set(sex);
	}
	
	public String getNumele() {
		return numele.get();
	}

	public void setNumele(String numele) {
		this.numele.set(numele);
	}
	
	public StringProperty numeleProperty() {
		return numele;
	}

	public String getPrenumele() {
		return prenumele.get();
	}

	public void setPrenumele(String prenumele) {
		this.prenumele.set(prenumele);
	}
	
	public StringProperty prenumeleProperty() {
		return prenumele;
	}
	
	public StringProperty idpozaProperty() {
		return idpoza;
	}
	
	@Override
	public String toString() {
		return getNumele() + " " + getPrenumele();
	}
}