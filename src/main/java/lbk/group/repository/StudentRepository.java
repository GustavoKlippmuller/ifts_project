package lbk.group.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lbk.group.entity.Student;

@Repository("studentRepository")
public interface StudentRepository extends JpaRepository<Student, Serializable> {
	public abstract Student findById(int id);
}
