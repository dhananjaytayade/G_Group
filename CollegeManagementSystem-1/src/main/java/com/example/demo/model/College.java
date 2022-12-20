package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "college3")
public class College {

	public College() {
		super();
		// TODO Auto-generated constructor stub
	}

	public College(int id, String collegeName, String city, int rankNo) {
		super();
		this.id = id;
		this.collegeName = collegeName;
		this.city = city;
		this.rankNo = rankNo;
		/* this.studentDetails = studentDetails; */
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String collegeName;
	private String city;
	private int rankNo;
	/*
	 * @OneToOne(cascade = CascadeType.ALL) private StudentDetails studentDetails;
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getRankNo() {
		return rankNo;
	}

	public void setRankNo(int rankNo) {
		this.rankNo = rankNo;
	}
	/*
	 * public StudentDetails getStudentDetails() { return studentDetails; }
	 * 
	 * public void setStudentDetails(StudentDetails studentDetails) {
	 * this.studentDetails = studentDetails; }
	 */

	@Override
	public String toString() {
		return "College [id=" + id + ", collegeName=" + collegeName + ", city=" + city + ", rankNo=" + rankNo + "]";
	}

}
