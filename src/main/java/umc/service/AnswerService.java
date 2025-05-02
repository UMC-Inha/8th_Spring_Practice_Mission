package umc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.repository.AnswerRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    @Transactional
    public void deleteAnswerByReview(List<Long> reviewIds) {

        answerRepository.deleteAllByReviewIds(reviewIds);
    }
}
