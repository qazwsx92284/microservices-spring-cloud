package com.infybuzz.Validation;

import com.infybuzz.entity.Course;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

@Component
public class CourseTypeSubsetValidator implements ConstraintValidator<CourseTypeSubset, Course.CourseName> {
    private Course.CourseName[] subset;

    @Override
    public void initialize(CourseTypeSubset constraint) {
        this.subset = constraint.anyOf();
    }

    @Override
    public boolean isValid(Course.CourseName value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(subset).contains(value);
    }
}
