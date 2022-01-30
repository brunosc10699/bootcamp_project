package com.bruno.bootcamp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_answers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Answer implements Serializable {

    public static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private AnswerPK id;

    private Boolean correctAnswer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return id.equals(answer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
