package com.finartz.userregistration.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EvaluationWeight")
public class EvaluationWeight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;


    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    private  int weight;


    public void setModelById(Model model) {
        this.model = model;
    }

    // Position nesnesini id'ye göre ayarlama
    public void setPositionById(Position position) {
        this.position = position;
    }
}
