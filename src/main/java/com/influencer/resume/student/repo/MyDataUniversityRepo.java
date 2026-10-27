package com.influencer.resume.student.repo;

import com.influencer.resume.student.entity.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyDataUniversityRepo extends JpaRepository<University, Integer> {

}
