package com.example.webprojectpro.models.dtos;

import com.example.webprojectpro.models.entities.Semester;
import com.example.webprojectpro.models.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LearningGroupDto {

    private long id;

    private String name;

    private boolean enabled;

    private SemesterDto semesterDto;

    private List<UserDto> studentsDto;
}
