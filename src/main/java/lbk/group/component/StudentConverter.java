package lbk.group.component;

import org.springframework.stereotype.Component;

import lbk.group.entity.Student;
import lbk.group.model.StudentModel;

@Component("studentConverter")
public class StudentConverter {

	public Student convertModel2Entity(StudentModel model) {
		return new Student(model.getId(), model.getFirstname(), model.getLastname(), model.getTelephone(), model.getCelphone(), model.getTypeDocument(), model.getDocumentNumber(), model.getUsername(), model.getLast_update());
	}
	
	public StudentModel convertEntity2Model(Student entity) {
		return new StudentModel(entity.getId(), entity.getFirstname(), entity.getLastname(), entity.getTelephone(), entity.getCelphone(), entity.getTypeDocument(), entity.getDocumentNumber(), entity.getUsername(), entity.getLast_update());
	}
}
