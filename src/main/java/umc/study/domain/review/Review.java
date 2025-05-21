package umc.study.domain.review;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.BaseTime;
import umc.study.domain.Image;
import umc.study.domain.member.Member;
import umc.study.domain.store.Store;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false)
    private BigDecimal score;
    private List<String> imageList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    public void setStore(Store store) {
        this.store = store;
    }
}
