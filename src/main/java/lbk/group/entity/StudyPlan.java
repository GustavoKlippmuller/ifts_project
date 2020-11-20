package lbk.group.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "study_plan")
public class StudyPlan {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "id_career")	
	private int idCareer;
	@Column(name = "study_plan_name", nullable = false, length = 30)
	private String studyPlanName;
	@Column(name = "duration", length = 6)
	private String duration;
	@Column(name = "start_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	@Column(name = "quantity_materials")
	private int quantityMaterials;
	@Column(name = "status")
	private boolean status;
	@Column(name = "username", nullable = false, length = 45)
	private String username;
	@Column(name = "last_update")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;

	public StudyPlan() {
		super();
	}

	public StudyPlan(int id, int idCareer, String studyPlanName, String duration, Date startDate,
			int quantityMaterials, boolean status, String username, Date lastUpdate) {
		super();
		this.id = id;
		this.idCareer = idCareer;
		this.studyPlanName = studyPlanName;
		this.duration = duration;
		this.startDate = startDate;
		this.quantityMaterials = quantityMaterials;
		this.status = status;
		this.username = username;
		this.lastUpdate = lastUpdate;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public int getIdCareer() {
		return idCareer;
	}

	public void setIdCareer(int idCareer) {
		this.idCareer = idCareer;
	}

	@Override
	public String toString() {
		return "StudyPlan [id=" + id + ", idCareer=" + idCareer + ", studyPlanName=" + studyPlanName + ", duration="
				+ duration + ", startDate=" + startDate + ", quantityMaterials=" + quantityMaterials + ", status="
				+ status + ", username=" + username + ", lastUpdate=" + lastUpdate + "]";
	}

}
