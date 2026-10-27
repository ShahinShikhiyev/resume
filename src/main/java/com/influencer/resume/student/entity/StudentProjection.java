package com.influencer.resume.student.entity;

import jakarta.persistence.Id;

public interface StudentProjection {
    public Integer getId();

    public String getName();

    public String getSurname();

    public Integer getAge();

    public String getEmail();

    public String getUniversity();

    public String getPassword();

    public String getFullname();

}
