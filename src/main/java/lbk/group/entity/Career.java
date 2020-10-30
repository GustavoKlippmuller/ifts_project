package lbk.group.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "career")
public class Career {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "career_name", nullable = false, length = 30)
	private String career_name;
	@Column(name = "career_title", nullable = false, length = 50)
	private String career_title;
	@Column(name = "speciality", nullable = false, length = 20)
	private String speciality;
	@Column(name = "resolution", length = 10)
	private String resolution;
	@OneToMany(mappedBy = "career")
	private List<StudyPlan> studyPlans;
	@Column(name = "status")
	private boolean status;
	@Column(name = "username", nullable = false, length = 45)
	private String username;
	@Column(name = "last_update")
	@Temporal(TemporalType.TIMESTAMP)
	private Date last_update;

	public Career() {
		super();
	}

	public Career(int id, String career_name, String career_title, String speciality, String resolution,
			List<StudyPlan> studyPlans, boolean status, String username, Date last_update) {
		super();
		this.id = id;
		this.career_name = career_name;
		this.career_title = career_title;
		this.speciality = speciality;
		this.resolution = resolution;
		this.studyPlans = studyPlans;
		this.status = status;
		this.username = username;
		this.last_update = last_update;
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

	public Date getLast_update() {
		return last_update;
	}

	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}

	public List<StudyPlan> getStudyPlans() {
		return studyPlans;
	}

	public void setStudyPlans(List<StudyPlan> studyPlans) {
		this.studyPlans = studyPlans;
	}

	@Override
	public String toString() {
		return "Career [id=" + id + ", career_name=" + career_name + ", career_title=" + career_title + ", speciality="
				+ speciality + ", resolution=" + resolution + ", studyPlans=" + studyPlans.toString() + ", status="
				+ status + ", username=" + username + ", last_update=" + last_update + "]";
	}

}
