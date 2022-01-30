package com.bruno.bootcamp.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_bootcamps")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Bootcamp implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @Column(name = "bootcamp_id")
    private String id;

    @ManyToMany(mappedBy = "bootcamps")
    private Set<User> users;

    @ManyToMany(mappedBy = "bootcamps")
    private Set<Subject> subjects;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bootcamp bootcamp = (Bootcamp) o;
        return id.equals(bootcamp.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
