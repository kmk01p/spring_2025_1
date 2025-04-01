package com.example.spring20251.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Entity
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;//PK 설정
    Boolean deleted;
    String title;
    String content;
    String author;
    Integer countread;

    @PrePersist
    public void prePersist() {
        this.deleted = false; //deleted는 무조건 false로 시작
        this.countread = 0; //countread는 무조건 0으로 시작
    }
}
