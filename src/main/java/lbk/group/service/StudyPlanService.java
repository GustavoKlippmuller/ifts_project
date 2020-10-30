package lbk.group.service;

import java.util.List;

import lbk.group.entity.StudyPlan;
import lbk.group.model.StudyPlanModel;

public interface StudyPlanService {

	public abstract StudyPlanModel addStudyPlan(StudyPlanModel studyPlanModel);

	public abstract List<StudyPlanModel> listStudyPlans();

	public abstract StudyPlan findStudyPlanById(int id);

	public abstract void removeStudyPlan(int id);

	public abstract StudyPlanModel findStudyPlanByIdModel(int id);

}
