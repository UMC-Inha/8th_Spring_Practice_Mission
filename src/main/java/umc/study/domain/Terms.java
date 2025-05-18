package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;

import umc.study.domain.mapping.UserAgree;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class Terms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String body;

    @Column(nullable = false)
    private Boolean optional;

    @Builder.Default
    @OneToMany(mappedBy = "terms", cascade = CascadeType.ALL)
    private List<UserAgree> userAgreeList = new ArrayList<>();
}
