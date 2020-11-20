package lbk.group.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lbk.group.entity.Career;
import lbk.group.model.CareerModel;

@Component("careerConverter")
public class CareerConverter {

	@Autowired
	@Qualifier("studyPlanConverter")
	private StudyPlanConverter studyPlanConverter;

	public Career convertModel2Entity(CareerModel model) {
		
		return new Career(model.getId(), model.getCareer_name(), model.getCareer_title(), model.getSpeciality(),
				model.getResolution(), model.isStatus(), model.getUsername(), model.getLast_upDate());
	}

	public CareerModel convertEntity2Model(Career entity) {


		return new CareerModel(entity.getId(), entity.getCareer_name(), entity.getCareer_title(),
				entity.getSpeciality(), entity.getResolution(), entity.isStatus(), entity.getUsername(),
				entity.getLast_update());
	}
}
