package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Member;
import umc.study.domain.Review;
import umc.study.domain.enums.Gender;
import umc.study.web.dto.MemberDTO.MemberRequestDTO;
import umc.study.web.dto.MemberDTO.MemberResponseDTO;
import umc.study.web.dto.ReviewDTO.ReviewResponseDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(member.getCreatedAt())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDTO request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>()) // 리스트는 초기화
                .build();
    }

    public static ReviewResponseDTO.ReviewPreViewDTO memberReviewDTO(Review review) {
        return ReviewResponseDTO.ReviewPreViewDTO.builder()
                .reviewId(review.getId())
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreViewListDTO memberReviewListDTO(Page<Review> memberReviewList) {
        List<ReviewResponseDTO.ReviewPreViewDTO> memberReviewDTOList = memberReviewList.stream()
                .map(MemberConverter::memberReviewDTO)
                .collect(Collectors.toList());

        return ReviewResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(memberReviewList.isLast())
                .isFirst(memberReviewList.isFirst())
                .totalPage(memberReviewList.getTotalPages())
                .totalElements(memberReviewList.getTotalElements())
                .listSize(memberReviewDTOList.size())
                .reviewList(memberReviewDTOList)
                .build();
    }
}
