package umc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.repository.AlarmRepository;

@Service
@RequiredArgsConstructor
public class AlarmService {

    private final AlarmRepository alarmRepository;

    @Transactional
    public void deleteAlarmByMember(Long memberId) {

        alarmRepository.deleteAllByMemberId(memberId);
    }
}
