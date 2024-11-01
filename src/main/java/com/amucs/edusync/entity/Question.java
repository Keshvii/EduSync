package com.amucs.edusync.entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_seq")
    @SequenceGenerator(name = "question_seq", sequenceName = "question_seq", allocationSize = 1)
    @Column(name = "ques_id")
    private int quesID;

    @Column(name = "ques_no",nullable = false)
    private String quesNo;

    @Column(name = "ques_content", nullable = false)
    private String quesContent;

    @ManyToOne
    @JoinColumn(name = "week_id", insertable = false, updatable = false)
    private Week week;

    @OneToMany(mappedBy = "question")
    private List<Solution> solutions;

    //Constructor

    public Question() {
    }

    public Question(String quesNo, String quesContent, Week week) {
        this.quesNo = quesNo;
        this.quesContent = quesContent;
        this.week = week;
    }
    // Getters and Setters

    public String getQuesContent() {
        return quesContent;
    }

    public void setQuesContent(String quesContent) {
        this.quesContent = quesContent;
    }

    public int getQuesID() {
        return quesID;
    }

    public void setQuesID(int quesID) {
        this.quesID = quesID;
    }

    public String getQuesNo() {
        return quesNo;
    }

    public void setQuesNo(String quesNo) {
        this.quesNo = quesNo;
    }

    public List<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<Solution> solutions) {
        this.solutions = solutions;
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
        return "Question{" +
                "quesID=" + quesID +
                ", quesNo='" + quesNo + '\'' +
                ", quesContent='" + quesContent + '\'' +
                ", week=" + week +
                ", solutions=" + solutions +
                '}';
    }
}