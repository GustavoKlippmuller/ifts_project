package lbk.group.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import lbk.group.component.ContactConverter;
import lbk.group.entity.Contact;
import lbk.group.model.ContactModel;
import lbk.group.repository.ContactRepository;
import lbk.group.service.ContactService;

@Service
@RequestMapping("contactServiceImpl")
public class ContactServiceImpl implements ContactService {

	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;

	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;

	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact = contactRepository.save(contactConverter.convertContactModel2Contact(contactModel));
		return contactConverter.convertContact2ContactModel(contact);
	}

	@Override
	public List<ContactModel> listContacts() {
		List<ContactModel> listContactModels = new ArrayList<>();
		for(Contact contact : contactRepository.findAll()) {
			listContactModels.add(contactConverter.convertContact2ContactModel(contact));
		}
		return listContactModels;
	}

	@Override
	public Contact findContactById(int id) {
		return contactRepository.findById(id);
	}

	public ContactModel findContactByIdModel(int id) {
		return contactConverter.convertContact2ContactModel(findContactById(id));
	}
	
	@Override
	public void removeContact(int id) {
		Contact contact = findContactById(id);
		if(contact != null) { contactRepository.delete(contact); }
	}

}
