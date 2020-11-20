package lbk.group.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import lbk.group.entity.StudyPlan;

public interface StudyPlanRepository extends JpaRepository<StudyPlan, Serializable> {
	public abstract StudyPlan findById(int id);
}
