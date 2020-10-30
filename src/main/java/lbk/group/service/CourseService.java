package lbk.group.service;

import java.util.List;

import lbk.group.entity.Course;
import lbk.group.model.CourseModel;

public interface CourseService {
	public abstract CourseModel addCourse(CourseModel courseModel);

	public abstract List<CourseModel> listCourse();

	public abstract Course findCourseById(int id);

	public abstract void removeCourse(int id);

	public abstract CourseModel findCourseByIdModel(int id);
}
