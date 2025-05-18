package umc.study.service.RegionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.repository.MissionRepository.MissionRepository;
import umc.study.repository.RegionRepository.RegionRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegionQueryServiceImpl implements RegionQueryService {
    private final RegionRepository regionRepository;
}
