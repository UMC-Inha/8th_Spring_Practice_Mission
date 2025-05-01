package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.enums.Gender;
import umc.study.domain.enums.MemberStatus;
import umc.study.domain.enums.SocialType;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String address;

    private String specAddress;

    @Enumerated(EnumType.STRING)
    private MemberStatus status;

    private LocalDateTime inactiveDate;

    private Integer point;

    private String phoneNumber; //unique

    private Boolean isAuth; //기본값 false

    private LocalDateTime authDate;

}