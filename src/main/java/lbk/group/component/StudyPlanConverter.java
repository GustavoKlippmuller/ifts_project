package lbk.group.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import lbk.group.entity.StudyPlan;
import lbk.group.model.StudyPlanModel;

@Component("studyPlanConverter")
public class StudyPlanConverter {
	
	@Autowired
	@Qualifier("careerConverter")
	private CareerConverter careerConverter;

	public StudyPlan convertModel2Entity(StudyPlanModel model) {
		return new StudyPlan(model.getId(), null, model.getStudyPlanName(), model.getDuration(),
				model.getStartDate(), model.getQuantityMaterials(), model.isStatus(), model.getUsername(),
				model.getLastUpdate());
	}

	public StudyPlanModel convertEntity2Model(StudyPlan entity) {
		return new StudyPlanModel(entity.getId(),entity.getCareer().getId(), entity.getStudyPlanName(), entity.getDuration(),
				entity.getStartDate(), entity.getQuantityMaterials(), entity.isStatus(), entity.getUsername(),
				entity.getLastUpdate());
	}
}
