package com.amucs.edusync.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "week")
public class Week {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "week_seq")
    @SequenceGenerator(name = "week_seq", sequenceName = "week_seq", allocationSize = 1)
    @Column(name = "week_id")
    private int weekID;

    @Column(name = "week_no", nullable = false)
    private int weekNo;

    @Column(name = "start_date",nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date",nullable = false)
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "course_code",nullable = false)
    private Lab lab;

    @OneToMany(mappedBy = "week")
    private List<Question> questions;

    //Constructor

    public Week() {
    }

    public Week(int weekNo, Lab lab, LocalDateTime startDate, LocalDateTime endDate) {
        this.weekNo = weekNo;
        this.lab = lab;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    // Getters and Setters

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Lab getLab() {
        return lab;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public int getWeekID() {
        return weekID;
    }

    public void setWeekID(int weekID) {
        this.weekID = weekID;
    }

    public int getWeekNo() {
        return weekNo;
    }

    public void setWeekNo(int weekNo) {
        this.weekNo = weekNo;
    }

    //toString

    @Override
    public String toString() {
        return "Week{" +
                "weekID=" + weekID +
                ", weekNo=" + weekNo +
                ", lab=" + lab +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", questions=" + questions +
                '}';
    }
}


