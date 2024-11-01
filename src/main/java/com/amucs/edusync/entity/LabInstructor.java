package com.amucs.edusync.entity;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "lab_instructor")
public class LabInstructor {

    @EmbeddedId
    private LabInstructorId id;

    @ManyToOne
    @MapsId("id")  // Maps the "id" field in LabInstructorId
    @JoinColumn(name = "id", referencedColumnName = "id")
    private AdminInstructor instructor;

    @ManyToOne
    @MapsId("courseCode")  // Maps the "courseCode" field in LabInstructorId
    @JoinColumn(name = "course_code", referencedColumnName = "course_code")
    private Lab lab;

    // Default constructor
    public LabInstructor() {
    }

    // Parameterized constructor
    public LabInstructor(LabInstructorId id, AdminInstructor instructor, Lab lab) {
        this.id = id;
        this.instructor = instructor;
        this.lab = lab;
    }

    // Getters and Setters
    public LabInstructorId getId() {
        return id;
    }

    public void setId(LabInstructorId id) {
        this.id = id;
    }

    public AdminInstructor getInstructor() {
        return instructor;
    }

    public void setInstructor(AdminInstructor instructor) {
        this.instructor = instructor;
    }

    public Lab getLab() {
        return lab;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }

    // Embedded composite key class
    @Embeddable
    public static class LabInstructorId implements Serializable {

        @Column(name = "id")
        private String id;  // FK to AdminInstructor

        @Column(name = "course_code")
        private String courseCode;  // FK to Lab

        // Default constructor
        public LabInstructorId() {
        }

        // Parameterized constructor
        public LabInstructorId(String id, String courseCode) {
            this.id = id;
            this.courseCode = courseCode;
        }

        // Getters and Setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCourseCode() {
            return courseCode;
        }

        public void setCourseCode(String courseCode) {
            this.courseCode = courseCode;
        }

        // Override equals and hashCode
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LabInstructorId that = (LabInstructorId) o;
            return Objects.equals(id, that.id) && Objects.equals(courseCode, that.courseCode);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, courseCode);
        }
    }

    @Override
    public String toString() {
        return "LabInstructor{" +
                "id=" + id +
                ", instructor=" + instructor +
                ", lab=" + lab +
                '}';
    }
}
