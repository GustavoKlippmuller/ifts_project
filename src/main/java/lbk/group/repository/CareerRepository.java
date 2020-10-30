package lbk.group.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lbk.group.entity.Career;

@Repository("careerRepository")
public interface CareerRepository extends JpaRepository<Career, Serializable> {
	public abstract Career findById(int id);
}
