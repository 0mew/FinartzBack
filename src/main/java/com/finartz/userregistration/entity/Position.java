package com.finartz.userregistration.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String name;

    // private boolean active;

    @OneToMany(mappedBy = "position")
    private List<EvaluationWeight> evaluationWeights;


    public Position(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
