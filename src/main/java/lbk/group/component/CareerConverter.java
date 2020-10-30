package lbk.group.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lbk.group.entity.Career;
import lbk.group.entity.StudyPlan;
import lbk.group.model.CareerModel;
import lbk.group.model.StudyPlanModel;

@Component("careerConverter")
public class CareerConverter {

	@Autowired
	@Qualifier("studyPlanConverter")
	private StudyPlanConverter studyPlanConverter;

	public Career convertModel2Entity(CareerModel model) {

		List<StudyPlan> studyPlans = new ArrayList<>();
		for (StudyPlanModel studyPlanModel : model.getStudyPlanModels())
			studyPlans.add(studyPlanConverter.convertModel2Entity(studyPlanModel));

		return new Career(model.getId(), model.getCareer_name(), model.getCareer_title(), model.getSpeciality(),
				model.getResolution(), studyPlans, model.isStatus(), model.getUsername(), model.getLast_upDate());
	}

	public CareerModel convertEntity2Model(Career entity) {

		List<StudyPlanModel> studyPlanModel = new ArrayList<>();
		for (StudyPlan studyPlan : entity.getStudyPlans())
			studyPlanModel.add(studyPlanConverter.convertEntity2Model(studyPlan));

		return new CareerModel(entity.getId(), entity.getCareer_name(), entity.getCareer_title(),
				entity.getSpeciality(), entity.getResolution(), studyPlanModel, entity.isStatus(), entity.getUsername(),
				entity.getLast_update());
	}
}
