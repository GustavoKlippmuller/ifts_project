package lbk.group.service;

import java.util.List;

import lbk.group.entity.Student;
import lbk.group.model.StudentModel;

public interface StudentService {
	public abstract StudentModel addStudent(StudentModel studentModel);

	public abstract List<StudentModel> listStudent();

	public abstract Student findStudentById(int id);

	public abstract void removeStudent(int id);

	public abstract StudentModel findStudentByIdModel(int id);
}
