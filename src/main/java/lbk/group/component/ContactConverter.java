package lbk.group.component;

import org.springframework.stereotype.Component;

import lbk.group.entity.Contact;
import lbk.group.model.ContactModel;

@Component("contactConverter")
public class ContactConverter {

	public Contact convertContactModel2Contact(ContactModel contactModel) {
		Contact contact = new Contact(contactModel.getId(), contactModel.getFirstname(), contactModel.getLastname(),
				contactModel.getTelephone(), contactModel.getCity());
		return contact;
	}

	public ContactModel convertContact2ContactModel(Contact contact) {
		ContactModel contactModel = new ContactModel(contact.getId(), contact.getFirstname(), contact.getLastname(),
				contact.getTelephone(), contact.getCity());
		return contactModel;
	}

}
