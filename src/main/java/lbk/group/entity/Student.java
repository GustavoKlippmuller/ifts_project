package lbk.group.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "firstname", nullable = false, length = 45)
	private String firstname;
	@Column(name = "lastname", nullable = false, length = 45)
	private String lastname;
	@Column(name = "telephone")
	private String telephone;
	@Column(name = "celphone")
	private String celphone;
	@Column(name = "type_document")
	private String typeDocument;
	@Column(name = "document_number")
	private String documentNumber;
	
	@Column(name = "username", nullable = false, length = 45)
	private String username;
	@Column(name = "last_update")
	@Temporal(TemporalType.TIMESTAMP)
	private Date last_update;
	
	public Student() {
		super();
	}
	
	
	
	
	public Student(int id, String firstname, String lastname, String telephone, String celphone, String typeDocument,
			String documentNumber, String username, Date last_update) {
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
		return "Student [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", telephone=" + telephone
				+ ", celphone=" + celphone + ", typeDocument=" + typeDocument + ", documentNumber=" + documentNumber
				+ "]";
	}
	

}
