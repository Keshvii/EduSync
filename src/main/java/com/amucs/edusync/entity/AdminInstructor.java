package com.amucs.edusync.entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "admin_instructor")
public class AdminInstructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "instructor")
    private List<LabInstructor> labInstructors;

    // Default constructor
    public AdminInstructor() {
    }

    // Parameterized constructor
    public AdminInstructor(String id, String name, String email, String phone, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<LabInstructor> getLabInstructors() {
        return labInstructors;
    }

    public void setLabInstructors(List<LabInstructor> labInstructors) {
        this.labInstructors = labInstructors;
    }

    @Override
    public String toString() {
        return "AdminInstructor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
