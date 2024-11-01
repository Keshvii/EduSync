package com.amucs.edusync.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "submission")
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "submission_seq")
    @SequenceGenerator(name = "submission_seq", sequenceName = "submission_seq", allocationSize = 1)
    @Column(name = "submit_id")
    private String submitID;

    @ManyToOne
    @JoinColumn(name = "faculty_no", referencedColumnName = "faculty_no", insertable = false, updatable = false)
    private Student student; // Reference to the associated student

    @ManyToOne
    @JoinColumn(name = "week_id", referencedColumnName = "week_id", nullable = false)
    private Week week; // Reference to the associated week

    @ManyToOne
    @JoinColumn(name = "course_code", referencedColumnName = "course_code", nullable = false)
    private Lab lab; // Reference to the associated lab

    @Column(name = "submit_time")
    private LocalDateTime submitTime;

    @Column(name = "is_accepted")
    private String isAccepted;

    @Column(name = "feedback")
    private String feedback;

    @OneToMany(mappedBy = "submission")
    private List<Solution> solutions;

    //Constructor

    public Submission() {
    }

    public Submission(Student student, Lab lab, String submitID, Week week, LocalDateTime submitTime, List<Solution> solutions, String isAccepted, String feedback) {
        this.student = student;
        this.lab = lab;
        this.submitID = submitID;
        this.week = week;
        this.submitTime = submitTime;
        this.solutions = solutions;
        this.isAccepted = isAccepted;
        this.feedback = feedback;
    }

    // Getters and Setters

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(String isAccepted) {
        this.isAccepted = isAccepted;
    }

    public Lab getLab() {
        return lab;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }

    public List<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<Solution> solutions) {
        this.solutions = solutions;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getSubmitID() {
        return submitID;
    }

    public void setSubmitID(String submitID) {
        this.submitID = submitID;
    }

    public LocalDateTime getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(LocalDateTime submitTime) {
        this.submitTime = submitTime;
    }

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }

    //toString

    @Override
    public String toString() {
        return "Submission{" +
                "submitID='" + submitID + '\'' +
                ", student=" + student +
                ", lab=" + lab +
                ", week=" + week +
                ", submitTime=" + submitTime +
                ", solutions=" + solutions +
                ", feedback='" + feedback + '\'' +
                ", isAccepted='" + isAccepted + '\'' +
                '}';
    }
}