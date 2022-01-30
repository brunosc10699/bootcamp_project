package com.bruno.bootcamp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_question_options")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Option implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @Column(name = "option_id")
    private String id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Option option = (Option) o;
        return id.equals(option.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
