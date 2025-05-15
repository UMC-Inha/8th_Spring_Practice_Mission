package umc.presentation.dto.temp;

import lombok.Builder;

public class TempResponse {
    @Builder
    public record TempTestDTO( String testString ){}

    @Builder
    public record TempExceptionDTO( Integer flag ){}
}
