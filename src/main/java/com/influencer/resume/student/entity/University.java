package com.influencer.resume.student.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Audited;

import java.util.List;

@Entity(name = "University")
@Table(name = "university")
public class University {

    @Id
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "university",
            targetEntity = Student.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @JsonIgnore
    private List<Student> student;

    public Integer getId() {
        return id;
    }

    public University setId(final Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }
}
