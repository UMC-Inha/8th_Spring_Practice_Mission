package umc.study.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI UMCstudyAPI() {
        String jwtSchemeName = "JWT TOKEN"; //문서 내 보안 항목 식별자
        // API 요청헤더에 인증정보 포함
        SecurityRequirement securityRequirement = new SecurityRequirement().addList(jwtSchemeName);
        //모든 API 엔드포인트에서 jwtSchemeName 스키마를 요구하도록 설정
        //이후 Authorize 버튼을 통해 토큰 한 번 입력하면, 이후 모든 API 요청에 Authorization: Bearer <JWT> 헤더 자동 추가
        //Swagger 문서 내에서만 유효함
        //security schemes 등록
        Components components = new Components()
                .addSecuritySchemes(jwtSchemeName, new SecurityScheme()
                        .name(jwtSchemeName)
                        .type(SecurityScheme.Type.HTTP) //HTTP 인증 방식
                        .scheme("bearer") //Bearer 토큰 방식
                        .bearerFormat("JWT")); //토큰 포맷은 JWT
        return new OpenAPI()
                .addServersItem(new Server().url("/"))
                .addSecurityItem(securityRequirement)
                .components(components)
                .info(apiInfo());

    }

    private Info apiInfo() {
        return new Info()
                .title("UMC Server WorkBook API")
                .description("UMC Server WorkBook API 명세서")
                .version("1.0.0");

    }

}
