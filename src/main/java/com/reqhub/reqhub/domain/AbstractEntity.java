package com.reqhub.reqhub.domain;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.*;

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class AbstractEntity<ID extends Serializable> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;

    public ID getId() { return id; }
    public void setId(ID id) { this.id = id; }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AbstractEntity<?> other = (AbstractEntity<?>) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() { return "id=" + id; }
}