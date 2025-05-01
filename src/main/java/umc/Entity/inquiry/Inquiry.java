package umc.Entity.inquiry;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "inquiry")
public class Inquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "answer_state", nullable = false)
    private Boolean answerState = false;

    @Builder.Default
    @OneToMany(mappedBy = "inquiry", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InquiryAnswer> inquiryAnswers = new ArrayList<>();
}
