package com.codegym.dto;

import com.codegym.model.Account;
import com.codegym.model.ClassRoom;
import com.codegym.model.Course;

import javax.validation.constraints.NotBlank;
import java.util.Set;

public class StudentDto {
    private int id;
    @NotBlank(message = "tham hoa")
    private String name;
    private int gender;
    private int status = 1;
    private Account account;
    private ClassRoom classRoom;
    private Set<Course> courses;

    public StudentDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
