package lbk.group.component;

import org.springframework.stereotype.Component;


import lbk.group.entity.Course;
import lbk.group.model.CourseModel;

@Component("courseConverter")
public class CourseConverter {
	
	public Course convertModel2Entity(CourseModel model) {
		return new Course(model.getId(), model.getCourse_name(), model.getDuration(), model.getWorkload(), model.getUsername(), model.getLast_update());
	}
	
	public CourseModel convertEntity2Model(Course entity) {
		return new CourseModel(entity.getId(), entity.getCourse_name(), entity.getDuration(), entity.getWorkload(), entity.getUsername(), entity.getLast_update());
	}
}
