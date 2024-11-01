package com.amucs.edusync.entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "faculty_no")
    private String facultyNo;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "enroll_no",nullable = false)
    private String enrollNo;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "course_code", referencedColumnName = "course_code", nullable = false)
    private Lab lab;

    @Column(name = "password",nullable = false)
    private String password;

    //pathname
    @Column(name = "valid_identity",nullable = false)
    private String validIdentity;

    @Column(name = "is_verified")
    private Boolean isVerified = false;

    @OneToMany(mappedBy = "student")
    private List<Submission> submissions;

    //Constructor

    // Getters and Setters

    //toString

}