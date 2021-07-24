package com.web.blog.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // db에 넘버링 전략을 따라간다.
    private Long id;

    @Column(nullable = false, length = 30)
    private String username;
    @Column(nullable = false, length = 100) // 해시 비밀번호 암호화
    private String password;
    @Column(nullable = false, length = 50)
    private String email;

    @CreationTimestamp // 시간을 자동 입력
    private LocalDateTime createDate;

    @Enumerated(EnumType.STRING)
    private RoleType role; // Enum 을 쓰는게 좋다. // admin, user, manager

}
