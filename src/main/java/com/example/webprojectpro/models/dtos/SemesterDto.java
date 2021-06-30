package com.example.webprojectpro.models.dtos;

import com.example.webprojectpro.models.entities.Project;
import com.example.webprojectpro.models.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SemesterDto {

    private Long id;

    private String name;

    private List<User> users;

    private List<Project> projects;
}
