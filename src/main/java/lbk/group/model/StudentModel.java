package lbk.group.model;

import java.util.Date;

public class StudentModel {
	private int id;
	private String firstname;
	private String lastname;
	private String telephone;
	private String celphone;
	private String typeDocument;
	private String documentNumber;	
	private String username;
	private Date last_update;
	
	public StudentModel() {
		super();
	}

	public StudentModel(int id, String firstname, String lastname, String telephone, String celphone,
			String typeDocument, String documentNumber, String username, Date last_update) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.telephone = telephone;
		this.celphone = celphone;
		this.typeDocument = typeDocument;
		this.documentNumber = documentNumber;
		this.username = username;
		this.last_update = last_update;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCelphone() {
		return celphone;
	}

	public void setCelphone(String celphone) {
		this.celphone = celphone;
	}

	public String getTypeDocument() {
		return typeDocument;
	}

	public void setTypeDocument(String typeDocument) {
		this.typeDocument = typeDocument;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getLast_update() {
		return last_update;
	}

	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}

	@Override
	public String toString() {
		return "StudentModel [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", telephone="
				+ telephone + ", celphone=" + celphone + ", typeDocument=" + typeDocument + ", documentNumber="
				+ documentNumber + ", username=" + username + ", last_update=" + last_update + "]";
	}
	
}
