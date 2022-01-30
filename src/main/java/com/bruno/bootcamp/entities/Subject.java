package com.bruno.bootcamp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_subjects")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Subject implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @Column(name = "subject_id")
    private String id;

    @ManyToMany
    @JoinTable(
            name = "tb_subject_bootcamp",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "bootcamp_id")
    )
    private Set<Bootcamp> bootcamps;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User instructor;

    @OneToOne(mappedBy = "subject", cascade = CascadeType.ALL)
    private Exam exam;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return id.equals(subject.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
