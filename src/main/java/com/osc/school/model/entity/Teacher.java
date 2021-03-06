package com.osc.school.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.osc.school.validator.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
* Entity of teacher
*
* @author : nam
* @since : 21/7/2020
*/

@Entity(name = "teacher")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Teacher implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String teacherName;

    @NotNull
    @Min(25)
    @Max(55)
    private int teacherAge;

    @Email
    private String email;

    private String address;

    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    private List<Course> courseList;
}
