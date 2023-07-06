package com.proto.emr.domain.model;

import com.proto.emr.domain.dto.UpdatePatient;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

//entity class. (도메인 클래스 - table 과 매핑)

//@Builder
//@AllArgsConstructor(access = AccessLevel.PRIVATE)

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Patient  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int unsigned")
    private Long id;

    @Column(nullable = false, columnDefinition = "varchar(128)")
    private String name;

    @Column(columnDefinition = "int unsigned")
    private Long age;

    @Column(nullable = false, columnDefinition = "varchar(128)")
    private String sex;

//    @CreatedDate
//    @Column(updatable = false, nullable = false)
    @CreatedDate
    private String createdAt;

    @LastModifiedDate
    private String updatedAt;

    //논리적 삭제
    @Column(nullable = false, columnDefinition = "boolean")
    private Boolean deleted;

//    private DateTime createdDate;
//    private DateTime updatedDate;

    private Patient(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.sex = builder.sex;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
        this.deleted = false;
    }

    public void update(UpdatePatient p) {
        if (p.getName() != null) {
            this.name = p.getName();
        }
        if (p.getAge() != null) {
            this.age = p.getAge();
        }
        if (p.getSex() != null) {
            this.sex = p.getSex();
        }
    }

    public static Builder builder() {
        return new Builder();
    }

//    (1) Patient.Builder builder = Patient.builder();
//    (2) Patient patient = builder.id(1).name("종구").age(30).build();

    public static class Builder {

        private Long id;

        private String name;

        private Long age;

        private String sex;

        private String createdAt;
        private String updatedAt;

        Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder createdAt(String createdAt) {
            this.createdAt = createdAt;
            return this;
        }
        public Builder updatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
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
        public Builder sex(String sex) {
            this.sex = sex;
            return this;
        }


        public Patient build() {
            return new Patient(this);
        }
    }

}
