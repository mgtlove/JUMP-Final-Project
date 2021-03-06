package com.collabera.finalProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.finalProject.model.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {

}
