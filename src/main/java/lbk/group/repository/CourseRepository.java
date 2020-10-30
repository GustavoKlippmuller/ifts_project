package lbk.group.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lbk.group.entity.Course;

@Repository("courseRepository")
public interface CourseRepository extends JpaRepository<Course, Serializable> {
	public abstract Course findById(int id);
}
