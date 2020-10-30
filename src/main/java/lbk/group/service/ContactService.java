package lbk.group.service;

import java.util.List;

import lbk.group.entity.Contact;
import lbk.group.model.ContactModel;

public interface ContactService {
	public abstract ContactModel addContact(ContactModel contactModel);

	public abstract List<ContactModel> listContacts();

	public abstract Contact findContactById(int id);

	public abstract void removeContact(int id);

	public abstract ContactModel findContactByIdModel(int id);
}
