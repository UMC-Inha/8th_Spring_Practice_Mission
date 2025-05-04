package umc.Entity.mission;

import jakarta.persistence.*;
import lombok.*;
import umc.Entity.BaseTimeEntity;
import umc.Entity.store.Store;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@Table(name = "mission")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Mission extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "point", nullable = false)
    private Integer point;

    @Column(name = "due_date", nullable = false)
    private LocalDateTime dueDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;
}
