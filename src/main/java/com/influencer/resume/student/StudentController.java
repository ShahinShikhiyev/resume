package com.influencer.resume.student;

import com.influencer.resume.student.entity.Student;
import com.influencer.resume.student.entity.University;
import com.influencer.resume.student.repo.StudentRepoData;
import com.influencer.resume.student.repo.CustomStudentRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepoData dataRepo;

    private final CustomStudentRepo studentRepo;

    public StudentController(final StudentRepoData dataRepo, final CustomStudentRepo studentRepo) {
        this.dataRepo = dataRepo;
        this.studentRepo = studentRepo;
    }

    @GetMapping
    public List<Student> getList(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String email,
            @RequestParam(required = false, name="university_id") Integer universityId,
            @RequestParam(required = false) Integer age) {
        return studentRepo.getList(name, surname, email, universityId, age);
    }

//    @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public void insert(@RequestBody Student student){
        dataRepo.save(student);
    }

    @PutMapping
    public void update(@RequestBody Student student){
        dataRepo.save(student);
    }

    @DeleteMapping
    public void delete(@RequestParam Integer id){
        dataRepo.deleteById(id);
    }

    @GetMapping("{id}")
    public Student findById(@PathVariable("id") Integer id) {
        return dataRepo.findById(id).get();
    }

    @GetMapping("{id}/universities/{universityId}")
    public University findByIdUniversity(
            @PathVariable("id") Integer id,
            @PathVariable("universityId") Integer universityId){
        return dataRepo.findById(id).get().getUniversity();
    }
}
