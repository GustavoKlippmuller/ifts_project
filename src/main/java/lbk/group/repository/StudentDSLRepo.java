package lbk.group.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQuery;

import lbk.group.entity.QStudent;
import lbk.group.entity.Student;

@Repository("studentDSLRepo")
public class StudentDSLRepo {

	private QStudent qStudent = QStudent.student;
	@PersistenceContext
	private EntityManager eManager;

	public List<Student> listByLastName(String lastname) {
		JPAQuery<Student> query = new JPAQuery<>(eManager);

		return query.select(qStudent).from(qStudent).where(qStudent.lastname.contains(lastname)).fetch();

	}

}
