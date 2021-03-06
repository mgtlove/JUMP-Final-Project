package com.collabera.finalProject.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Client implements  Serializable, Model {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "client_id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "imagePath", nullable = true, length = 100)
	private String imagePath;
	
	@Column(name = "name", nullable = false, length = 50)
	private String name;
	
	@Column(name = "phone", nullable = true, length = 10)
	private String phone;
	
	@Column(name = "description", nullable = true, length = 250)
	private String description;
	
	//Address
	@ManyToOne
	@JoinColumn(name = "address_id")
	private Address address;
	
	//Students
	@ManyToMany(mappedBy = "clients")
	private Set<Student> students = new HashSet<>();
	
	public Client () {
		
	}

	public Client(String imagePath, String name, String phone, String description) {

		this.imagePath = imagePath;
		this.name = name;
		this.phone = phone;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	 public void addStudent(Student student) {
	        students.add(student);
	    }
	 
	 public void removeStudent(Student student) {
		 students.remove(student);
	 }
}
