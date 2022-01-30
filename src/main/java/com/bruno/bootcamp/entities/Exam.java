package com.bruno.bootcamp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_exams")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Exam implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @Column(name = "exam_id")
    private String id;

    @OneToOne
    @JoinColumn(name = "subject_id")
    @MapsId
    private Subject subject;

    @ManyToMany(mappedBy = "exams", cascade = CascadeType.ALL)
    private Set<Question> questions;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exam exam = (Exam) o;
        return id.equals(exam.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
