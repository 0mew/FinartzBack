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
@Table(name = "Model")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String name;


    @OneToMany(mappedBy = "model")
    private List<EvaluationWeight> evaluationWeights;


    public Model(int id, String s) {
        this.id=id;
        this.name=s;

    }
}
