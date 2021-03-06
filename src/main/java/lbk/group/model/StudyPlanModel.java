package lbk.group.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class StudyPlanModel {

	private int id;
	private int idCareer;
	private String studyPlanName;
	private String duration;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date startDate;
	private int quantityMaterials;
	private String estado;
	private boolean status;
	private String username;
	private Date lastUpdate;
	private String stringDate;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public StudyPlanModel() {
		super();
	}

	public StudyPlanModel(int id, int idCareer, String studyPlanName, String duration, Date startDate,
			int quantityMaterials, boolean status, String username, Date lastUpdate) {
		super();
		this.id = id;
		this.idCareer = idCareer;
		this.studyPlanName = studyPlanName;
		this.duration = duration;
		this.startDate = startDate;
		this.stringDate = sdf.format(startDate);
		this.quantityMaterials = quantityMaterials;
		this.status = status;
		this.username = username;
		this.lastUpdate = lastUpdate;
		this.estado = status ? "Activo" : "Inactivo";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCareer() {
		return idCareer;
	}

	public void setIdCareer(int idCareer) {
		this.idCareer = idCareer;
	}

	public String getStudyPlanName() {
		return studyPlanName;
	}

	public void setStudyPlanName(String studyPlanName) {
		this.studyPlanName = studyPlanName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
		this.stringDate = sdf.format(startDate);
	}

	public int getQuantityMaterials() {
		return quantityMaterials;
	}

	public void setQuantityMaterials(int quantityMaterials) {
		this.quantityMaterials = quantityMaterials;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
		this.estado = status ? "Activo" : "Inactivo";
	}

	public String getEstado() {
		return estado;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getStringDate() {
		return stringDate;
	}

	@Override
	public String toString() {
		return "StudyPlanModel by Gustavo[id=" + id + ", idCareer=" + idCareer + ", studyPlanName=" + studyPlanName
				+ ", duration=" + duration + ", startDate=" + startDate + ", quantityMaterials=" + quantityMaterials
				+ ", status=" + status + ", username=" + username + ", lastUpdate=" + lastUpdate + "]";
	}

}
