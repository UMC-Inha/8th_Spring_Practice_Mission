package umc.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Restaurant extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "region_id")
	private Region region;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;

	@Column(nullable = false)
	private String name;

	private Boolean isOpened;

	private Float score;

	@ElementCollection
	@Builder.Default
	private List<String> restaurantImageList = new ArrayList<>();

	@OneToMany(mappedBy = "restaurant")
	@Builder.Default
	private List<Review> reviewList = new ArrayList<>();

	@OneToMany(mappedBy = "restaurant")
	@Builder.Default
	private List<Mission> missionList = new ArrayList<>();

	@OneToMany(mappedBy = "restaurant", orphanRemoval = true, cascade = CascadeType.REMOVE)
	@Builder.Default
	private List<RestaurantTime> restaurantTimeList = new ArrayList<>();

	public void setRegion(Region region) {
		this.region = region;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
