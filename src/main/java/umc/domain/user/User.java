package umc.domain.user;


import jakarta.persistence.*;
import lombok.*;
import umc.domain.BaseTimeEntity;
import umc.domain.category.UserCategory;
import umc.domain.mission.UserMission;
import umc.domain.review.Review;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "user")
@Builder

public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "pw", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    private UserState state = UserState.ACTIVE;

    @Builder.Default
    @Column(name = "point")
    private Integer point = 0;

    @Builder.Default
    @Column(name = "phone_num")
    private String phoneNum = " ";

    @Builder.Default
    @Column(name = "phone_auth", nullable = false)
    private Boolean phoneAuth = false;

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserCategory> userCategories = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserMission> userMissions = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Review> reviews = new HashSet<>();
}
