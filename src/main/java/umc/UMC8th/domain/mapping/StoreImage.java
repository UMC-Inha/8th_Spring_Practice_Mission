package umc.UMC8th.domain.mapping;


import jakarta.persistence.*;
import lombok.*;
import umc.UMC8th.domain.Store;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class StoreImage {
    // 가게 이미지 관련
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String imageUrl; // 가게 이미지 url

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;
}
