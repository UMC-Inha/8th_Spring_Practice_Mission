package umc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import umc.domain.common.BaseEntity;
import umc.domain.enums.Gender;
import umc.domain.enums.LoginType;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    private String mail;

    @Enumerated(EnumType.STRING)
    private LoginType loginType;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String birth;

    private String address;

    private String phoneNum;

    private Boolean isPhone;

    @ColumnDefault("0")
    private Integer missionComplete;

    @ColumnDefault("0")
    private Integer point;

    @ColumnDefault("true")
    private Boolean status;

    private LocalDateTime inactiveAt;

    public void updateStatus() {

        this.status = !this.status;
    }
}
