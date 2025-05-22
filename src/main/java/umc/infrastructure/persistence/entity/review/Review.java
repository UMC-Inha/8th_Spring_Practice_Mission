package umc.infrastructure.persistence.entity.review;

import jakarta.persistence.*;
import lombok.*;
import umc.infrastructure.persistence.entity.BaseTimeEntity;
import umc.infrastructure.persistence.entity.user.User;
import umc.infrastructure.persistence.entity.store.Store;

import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "review")
public class Review extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Builder.Default
    @Column(name = "score", nullable = false)
    private Integer score = 0;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @Builder.Default
    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ReviewImage> reviewImages = new HashSet<>();

    public void setStore(Store store) {
        this.store = store;
        if(!store.getReviews().contains(this)) {
            store.getReviews().add(this);
        }
    }

    public void setUser(User user) {
        this.user = user;
        if(!user.getReviews().contains(this)) {
            user.getReviews().add(this);
        }
    }
}

