package com.amucs.edusync.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "solution")
public class Solution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "solution_id")
    private Long solutionId;

    @Column(name = "file_path", nullable = false)
    private String filePath;

    @ManyToOne
    @JoinColumn(name = "submit_id", referencedColumnName = "submit_id", nullable = false)
    private Submission submission;  // Assuming Submission is another entity with submitID as its primary key

    @ManyToOne
    @JoinColumn(name = "ques_id", referencedColumnName = "ques_id", nullable = false)
    private Question question;  // Assuming Question is another entity with quesID as its primary key

    //constructor
    public Solution() {
    }

    public Solution(Submission submission, Question question, String filePath) {
        this.submission = submission;
        this.question = question;
        this.filePath = filePath;
    }

    // Getters and setters
    public Long getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(Long solutionId) {
        this.solutionId = solutionId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Submission getSubmission() {
        return submission;
    }

    public void setSubmission(Submission submission) {
        this.submission = submission;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    //toString
    @Override
    public String toString() {
        return "Solution{" +
                "solutionId=" + solutionId +
                ", submission=" + submission +
                ", question=" + question +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
