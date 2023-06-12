package com.proto.emr.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.domain.Persistable;

//entity class. (도메인 클래스 - table 과 매핑)

//@Builder
//@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Patient implements Persistable<Long>  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int unsigned")
    private Long id;

    @Column(nullable = false, columnDefinition = "varchar(128)")
    private String name;

    @Column(columnDefinition = "int unsigned")
    private Long age;

    private Patient(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
    }

    public static Builder builder() {
        return new Builder();
    }

//    (1) Patient.Builder builder = Patient.builder();
//    (2) Patient patient = builder.id(1).name("종구").age(30).build();

    @Override
    public Long getId() {
        return null;
    }

    @Override
    public boolean isNew() {
        return false;
    }

    public static class Builder {

        private Long id;

        private String name;

        private Long age;

        Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(Long age) {
            this.age = age;
            return this;
        }

        public Patient build() {
            return new Patient(this);
        }

    }

}
