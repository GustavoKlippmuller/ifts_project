package lbk.group.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import lbk.group.component.StudyPlanConverter;
import lbk.group.entity.StudyPlan;
import lbk.group.model.StudyPlanModel;
import lbk.group.repository.StudyPlanDSLRepo;
import lbk.group.repository.StudyPlanRepository;
import lbk.group.service.StudyPlanService;

@Service
@RequestMapping("studyPlanServiceImpl")
public class StudyPlanServiceImpl implements StudyPlanService {

	@Autowired
	@Qualifier("studyPlanRepository")
	private StudyPlanRepository studyPlanRepository;

	@Autowired
	@Qualifier("studyPlanDSLRepo")
	private StudyPlanDSLRepo studyPlanDSLRepo;

	@Autowired
	@Qualifier("studyPlanConverter")
	private StudyPlanConverter studyPlanConverter;

	@Override
	public StudyPlanModel addStudyPlan(StudyPlanModel model) {
		StudyPlan entity = studyPlanRepository.save(studyPlanConverter.convertModel2Entity(model));
		return studyPlanConverter.convertEntity2Model(entity);
	}

	@Override
	public List<StudyPlanModel> listStudyPlans() {
		List<StudyPlanModel> list = new ArrayList<>();
		for (StudyPlan entity : studyPlanRepository.findAll()) {
			list.add(studyPlanConverter.convertEntity2Model(entity));
		}
		return list;
	}

	@Override
	public StudyPlan findStudyPlanById(int id) {
		return studyPlanRepository.findById(id);
	}

	@Override
	public void removeStudyPlan(int id) {
		studyPlanRepository.delete(findStudyPlanById(id));

	}

	@Override
	public StudyPlanModel findStudyPlanByIdModel(int id) {
		return studyPlanConverter.convertEntity2Model(findStudyPlanById(id));
	}
	
	@Override	
	public List<StudyPlanModel> listPlansByCareer(int idCareer){
		List<StudyPlanModel> list = new ArrayList<>();
		for (StudyPlan entity : studyPlanDSLRepo.listByIdCareer(idCareer)) {
			list.add(studyPlanConverter.convertEntity2Model(entity));
		}
		return list;
	}

}
