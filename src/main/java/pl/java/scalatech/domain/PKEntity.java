package pl.java.scalatech.domain;

import static javax.persistence.GenerationType.AUTO;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;
@Data
@MappedSuperclass
public abstract class PKEntity<T> implements PKNature<T> {

    private static final long serialVersionUID = 7669211182758111346L;

    @Id
    @GeneratedValue(strategy=AUTO)
    protected T id;

    protected boolean disabled;

    protected LocalDate dateModification;

    protected LocalDate dateAdded;
    @Override
    public T getId() {
        return id;
    }
}