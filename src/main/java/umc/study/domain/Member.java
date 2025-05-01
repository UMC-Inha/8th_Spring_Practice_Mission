package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.MemberStatus;
import umc.study.domain.enums.SocialType;
import umc.study.domain.mapping.MemberMission;
import umc.study.domain.mapping.MemberPrefer;
import umc.study.domain.mapping.MemberTerms;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 12)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private SocialType socialType;

    @Column(length = 12)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(length = 6)
    private Gender gender;

    @Column(length = 20)
    private String address;

    @Column(length = 20)
    private String specAddress;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, columnDefinition = "VARCHAR(10) DEFAULT 'ACTIVE'")
    private MemberStatus status;

    private LocalDateTime inactiveDate;

    private Integer point;

    @Column(length = 12, unique = true)
    private String phoneNumber;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Boolean isAuth;

    private LocalDateTime authDate;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberTerms> memberTermsList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

}