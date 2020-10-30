package lbk.group.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import lbk.group.component.CourseConverter;
import lbk.group.entity.Course;
import lbk.group.model.CourseModel;
import lbk.group.repository.CourseRepository;
import lbk.group.service.CourseService;

@Service
@RequestMapping("courseServiceImpl")
public class CourseServiceImpl implements CourseService {

	@Autowired
	@Qualifier("courseRepository")
	private CourseRepository courseRepository;
	
	@Autowired
	@Qualifier("courseConverter")
	private CourseConverter courseConverter;
	
	@Override
	public CourseModel addCourse(CourseModel courseModel) {
		Course entity = courseRepository.save(courseConverter.convertModel2Entity(courseModel));
		return courseConverter.convertEntity2Model(entity);
	}

	@Override
	public List<CourseModel> listCourse() {
		List<CourseModel> list = new ArrayList<>();
		for(Course course : courseRepository.findAll()) {
			list.add(courseConverter.convertEntity2Model(course));
		}
		return list;
	}

	@Override
	public Course findCourseById(int id) {
		return courseRepository.findById(id);
	}

	@Override
	public void removeCourse(int id) {
		courseRepository.delete(findCourseById(id));
		
	}

	@Override
	public CourseModel findCourseByIdModel(int id) {
		return courseConverter.convertEntity2Model(findCourseById(id));
	}

}
