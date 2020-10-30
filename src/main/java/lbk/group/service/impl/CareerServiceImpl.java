package lbk.group.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import lbk.group.component.CareerConverter;
import lbk.group.entity.Career;
import lbk.group.model.CareerModel;
import lbk.group.repository.CareerRepository;
import lbk.group.service.CareerService;

@Service
@RequestMapping("careerServiceImpl")
public class CareerServiceImpl implements CareerService{
	
	@Autowired
	@Qualifier("careerRepository")
	private CareerRepository careerRepository;
	
	@Autowired
	@Qualifier("careerConverter")
	private CareerConverter careerConverter;

	@Override
	public CareerModel addCareer(CareerModel careerModel) {
		Career entity = careerRepository.save(careerConverter.convertModel2Entity(careerModel));
		return careerConverter.convertEntity2Model(entity);
	}

	@Override
	public List<CareerModel> listCareers() {
		List<CareerModel> list = new ArrayList<>();
		for(Career career : careerRepository.findAll()) {
			list.add(careerConverter.convertEntity2Model(career));
		}
		return list;
	}

	@Override
	public Career findCareerById(int id) {
		return careerRepository.findById(id);
	}

	@Override
	public void removeCareer(int id) {
		careerRepository.delete(findCareerById(id));
		
	}

	@Override
	public CareerModel findCareerByIdModel(int id) {
		return careerConverter.convertEntity2Model(findCareerById(id));
	}

}
