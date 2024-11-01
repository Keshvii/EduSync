package com.amucs.edusync.entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "lab")
public class Lab {
    @Id
    @Column(name = "course_code")
    private String courseCode;

    @Column(name = "program",nullable = false)
    private String program;

    @Column(name = "semester",nullable = false)
    private short semester;

    @OneToMany(mappedBy = "lab")
    private List<Week> weeks;

    //Constructor
    public Lab() {
    }

    public Lab(String courseCode, String program, short semester) {
        this.courseCode = courseCode;
        this.program = program;
        this.semester = semester;
    }

    // Getters and Setters

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public short getSemester() {
        return semester;
    }

    public void setSemester(short semester) {
        this.semester = semester;
    }

    public List<Week> getWeeks() {
        return weeks;
    }

    public void setWeeks(List<Week> weeks) {
        this.weeks = weeks;
    }

    //toString

    @Override
    public String toString() {
        return "Lab{" +
                "courseCode='" + courseCode + '\'' +
                ", program='" + program + '\'' +
                ", semester=" + semester +
                '}';
    }
}