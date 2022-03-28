package com.infybuzz.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.infybuzz.Validation.CourseTypeSubset;

import javax.persistence.*;
import java.util.stream.Stream;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    public enum CourseName {
        MATH("Math"), WRITING("Writing");

        String value;

        CourseName(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @JsonCreator
        public static CourseName decode(String inputCourseName) {
            CourseName courseName = Stream.of(CourseName.values()).filter(targetEnum -> targetEnum.value.equals(inputCourseName)).findFirst().orElse(null);
           // if(courseName !=null)
                return courseName;
            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST, null, new Throwable("Invalid Course Name"));
        }
    }

    private CourseName courseName;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public CourseName getCourseName() {
        return courseName;
    }

    public void setCourseName(CourseName courseName) {
        this.courseName = courseName;
    }
}
