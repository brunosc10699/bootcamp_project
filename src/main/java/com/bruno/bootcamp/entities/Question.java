package com.bruno.bootcamp.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_questions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Question implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @Column(name = "question_id")
    private String id;

    @ManyToMany
    @JoinTable(
            name = "tb_question_exam",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "exam_id")
    )
    private List<Exam> exams;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id.equals(question.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
