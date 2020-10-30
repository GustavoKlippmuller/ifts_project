package lbk.group.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Student {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "firstname")
	private String firstname;
	@Column(name = "lastname")
	private String lastname;
	@Column(name = "telephone")
	private String telephone;
	@Column(name = "celphone")
	private String celphone;
	@Column(name = "type_document")
	private String typeDocument;
	@Column(name = "document_number")
	private String documentNumber;
	public Student() {
		super();
	}
	public Student(int id, String firstname, String lastname, String telephone, String celphone, String typeDocument,
			String documentNumber) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.telephone = telephone;
		this.celphone = celphone;
		this.typeDocument = typeDocument;
		this.documentNumber = documentNumber;
	}
	
	

}
