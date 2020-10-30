package lbk.group.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lbk.group.entity.StudyPlan;

@Repository("studyPlanRepository")
public interface StudyPlanRepository extends JpaRepository<StudyPlan, Serializable> {
	public abstract StudyPlan findById(int id);
}
