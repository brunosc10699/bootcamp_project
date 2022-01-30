package com.bruno.bootcamp.entities;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AnswerPK implements Serializable {

    public static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "option_id")
    private Option option;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerPK answerPK = (AnswerPK) o;
        return question.equals(answerPK.question) && option.equals(answerPK.option);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, option);
    }
}
