package lbk.group.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import lbk.group.component.StudentConverter;
import lbk.group.entity.Student;
import lbk.group.model.StudentModel;
import lbk.group.repository.StudentDSLRepo;
import lbk.group.repository.StudentRepository;
import lbk.group.service.StudentService;

@Service
@RequestMapping("studentServiceImpl")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	@Qualifier("studentRepository")
	private StudentRepository studentRepository;
	
	@Autowired
	@Qualifier("studentDSLRepo")
	private StudentDSLRepo studentDSLRepo;
	
	@Autowired
	@Qualifier("studentConverter")
	private StudentConverter studentConverter;

	@Override
	public StudentModel addStudent(StudentModel studentModel) {
		Student entity = studentRepository.save(studentConverter.convertModel2Entity(studentModel));
		return studentConverter.convertEntity2Model(entity);
	}

	@Override
	public List<StudentModel> listStudent() {
		List<StudentModel> list = new ArrayList<>();
		for(Student student : studentRepository.findAll()) {
			list.add(studentConverter.convertEntity2Model(student));
		}
		return list;
	}

	@Override
	public Student findStudentById(int id) {
		return studentRepository.findById(id);
	}

	@Override
	public void removeStudent(int id) {
		studentRepository.delete(findStudentById(id));
		
	}

	@Override
	public StudentModel findStudentByIdModel(int id) {
		return studentConverter.convertEntity2Model(findStudentById(id));
	}

	@Override
	public List<StudentModel> listStudentByLastName(String lastname) {
		List<StudentModel> list = new ArrayList<>();
		for(Student student : studentDSLRepo.listByLastName(lastname))
			list.add(studentConverter.convertEntity2Model(student));			
		return list;
	}
}
