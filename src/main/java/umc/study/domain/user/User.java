package umc.study.domain.user;


import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.inquiry.Inquiry;
import umc.study.domain.review.Review;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.UserStatus;
import umc.study.domain.mapping.UserMission;
import umc.study.domain.mapping.UserNotification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate birth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String address;
    private String email;
    private Integer point;

    @Column(name = "mission_completed")
    private Integer missionCompleted;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserMission> userMissions = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inquiry> inquiries = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserNotification> userNotifications = new ArrayList<>();

}