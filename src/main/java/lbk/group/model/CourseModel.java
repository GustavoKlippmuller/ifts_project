package lbk.group.model;

import java.util.Date;

public class CourseModel {
	
	private int id;
	private String course_name;
	private int duration;
	private int workload;
	private String  username;
	private Date last_update;
	
	public CourseModel() {
		super();
	}

	public CourseModel(int id, String course_name, int duration, int workload, String username, Date last_update) {
		super();
		this.id = id;
		this.course_name = course_name;
		this.duration = duration;
		this.workload = workload;
		this.username = username;
		this.last_update = last_update;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getWorkload() {
		return workload;
	}

	public void setWorkload(int workload) {
		this.workload = workload;
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

	@Override
	public String toString() {
		return "CourseModel [id=" + id + ", course_name=" + course_name + ", duration=" + duration + ", workload="
				+ workload + ", username=" + username + ", last_update=" + last_update + "]";
	}
	
	
}
