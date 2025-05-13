package umc.study.repository.member.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberMissionIsCompletedResponseDto extends MemberMissionBaseDto {
    private Boolean isCompleted;
}
