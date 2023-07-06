package com.proto.emr.domain.dto;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePatient {
    @Nullable
    private String name;

    // Long: 레퍼 객체, long:원시 타입
    @Nullable
    private Long age;

    @Nullable
    private String sex;
    private boolean delete;

    @Nullable
    private Long updateAt;

    public boolean isEmpty() {
        return this.name == null && this.age == null && this.sex == null;
    }
}
