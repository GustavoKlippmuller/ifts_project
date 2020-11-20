package lbk.group.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQuery;

import lbk.group.entity.QStudyPlan;
import lbk.group.entity.StudyPlan;

@Repository("studyPlanDSLRepo")
public class StudyPlanDSLRepo {

	private QStudyPlan qStudyPlan = QStudyPlan.studyPlan;
	@PersistenceContext
	private EntityManager eManager;

	public List<StudyPlan> listByIdCareer(int idCareer) {
		JPAQuery<StudyPlan> query = new JPAQuery<>(eManager);

		return query.select(qStudyPlan).from(qStudyPlan).where(qStudyPlan.idCareer.eq(idCareer)).fetch();

	}

}
