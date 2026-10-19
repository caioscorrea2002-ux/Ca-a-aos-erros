package com.github.app.model.matricula;

import java.time.LocalDateTime;

import com.github.app.model.aluno.Aluno;
import com.github.app.model.professor.Professor;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "matriculas")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @Enumerated(EnumType.STRING)
    private Turno turno;

    private String semestre;

    private String observacao;

    private LocalDateTime dataMatricula;

    public Matricula(DadosCadastroMatricula dados) {
        this.turno = dados.turno();
        this.semestre = dados.semestre();
        this.observacao = dados.observacao();
        this.dataMatricula = dados.dataMatricula() != null
                ? dados.dataMatricula()
                : LocalDateTime.now();
    }
}