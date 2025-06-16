package umc.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.domain.enums.Gender;
import umc.domain.enums.SocialType;
import umc.domain.enums.UserStatus;
import umc.domain.mapping.PreferredCategory;
import umc.domain.mapping.UserTerm;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "region_id")
	private Region region;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String password;

	@Column(unique = true)
	private String email;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	private LocalDate birth;

	private String addressDetail;

	@Builder.Default
	private Integer point = 0;

	@Enumerated(EnumType.STRING)
	private SocialType socialType;

	@Enumerated(EnumType.STRING)
	@ColumnDefault("'ACTIVE'")
	private UserStatus status;

	private LocalDate inactiveDate;

	private String profileImage;

	private String phoneNumber;

	private Boolean missionAlarmAccepted;
	private Boolean replyAlarmAccepted;
	private Boolean inquiryAlarmAccepted;

	@OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.REMOVE)
	@Builder.Default
	private List<Alarm> alarmList = new ArrayList<>();

	@OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.REMOVE)
	@Builder.Default
	private List<UserTerm> userTermList = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	@Builder.Default
	private List<Review> reviewList = new ArrayList<>();

	@OneToMany(mappedBy = "user")
	@Builder.Default
	private List<PreferredCategory> preferredCategoryList = new ArrayList<>();
}
