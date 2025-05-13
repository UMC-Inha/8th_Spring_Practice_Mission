package umc.study.repository.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberMissionByLocationResponseDto extends MemberMissionBaseDto{
    private String categoryName;
    private LocalDateTime deadline;
}
