package umc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.repository.QnaImgRepository;
import umc.repository.QnaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QnaService {

    private final QnaImgRepository qnaImgRepository;
    private final QnaRepository qnaRepository;

    @Transactional
    public void deleteQnaByMember(Long memberId) {
        List<Long> qnaIdList = qnaRepository.findAllQnaIdsByMemberId(memberId);

        qnaImgRepository.deleteAllByQnaIds(qnaIdList);
        qnaRepository.deleteAllQnaByQnaIds(qnaIdList);
    }
}
