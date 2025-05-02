package umc.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.domain.common.BaseEntity;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QnaImg extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qna_img_id")
    private Long id;

    private String imgUrl;

    @ManyToOne
    @JoinColumn(name = "qna_id")
    private Qna qna; // qnaImg -> qna 단방향 연결
}
