package lbk.group.model;

import java.util.Date;
import java.util.List;

public class CareerModel {

	private int id;
	private String career_name;
	private String career_title;
	private String speciality;
	private String resolution;
	private List<StudyPlanModel> studyPlanModels;
	private boolean status;
	private String estado;
	private String username;
	private Date last_upDate;

	public CareerModel() {
		super();
	}

	public CareerModel(int id, String career_name, String career_title, String speciality, String resolution,
			List<StudyPlanModel> studyPlanModels, boolean status, String username, Date last_upDate) {
		super();
		this.id = id;
		this.career_name = career_name;
		this.career_title = career_title;
		this.speciality = speciality;
		this.resolution = resolution;
		this.studyPlanModels = studyPlanModels;
		this.status = status;
		this.username = username;
		this.last_upDate = last_upDate;
		this.estado = this.status ? "Activa" : "Inactiva";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCareer_name() {
		return career_name;
	}

	public void setCareer_name(String career_name) {
		this.career_name = career_name;
	}

	public String getCareer_title() {
		return career_title;
	}

	public void setCareer_title(String career_title) {
		this.career_title = career_title;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public List<StudyPlanModel> getStudyPlanModels() {
		return studyPlanModels;
	}

	public void setStudyPlanModels(List<StudyPlanModel> studyPlanModels) {
		this.studyPlanModels = studyPlanModels;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
		this.estado = status ? "Activa" : "Inactiva";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getLast_upDate() {
		return last_upDate;
	}

	public void setLast_upDate(Date last_upDate) {
		this.last_upDate = last_upDate;
	}

	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "CareerModel [id=" + id + ", career_name=" + career_name + ", career_title=" + career_title
				+ ", speciality=" + speciality + ", resolution=" + resolution + ", studyPlanModels=" + studyPlanModels.toString()
				+ ", status=" + status + ", estado=" + estado + ", username=" + username + ", last_upDate="
				+ last_upDate + "]";
	}



}
