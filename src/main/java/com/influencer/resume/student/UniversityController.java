package com.influencer.resume.student;

import com.influencer.resume.student.entity.University;
import com.influencer.resume.student.repo.MyDataUniversityRepo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/universities")
public class UniversityController {

    private final MyDataUniversityRepo dataRepo;

    public UniversityController(final MyDataUniversityRepo dataRepo) {
        this.dataRepo = dataRepo;
    }

    @GetMapping
    public List<University> getList(){
            return dataRepo.findAll();
    }
}
