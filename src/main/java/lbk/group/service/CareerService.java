package lbk.group.service;

import java.util.List;

import lbk.group.entity.Career;
import lbk.group.model.CareerModel;

public interface CareerService {
	public abstract CareerModel addCareer(CareerModel careerModel);

	public abstract List<CareerModel> listCareers();

	public abstract Career findCareerById(int id);

	public abstract void removeCareer(int id);

	public abstract CareerModel findCareerByIdModel(int id);
}
