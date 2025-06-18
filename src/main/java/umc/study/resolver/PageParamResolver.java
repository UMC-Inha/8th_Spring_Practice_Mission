package umc.study.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.PageHandler;

//@Component 컴포넌트로 등록이 안돼서 WebConfig로 등록함
public class PageParamResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(PageParam.class)
                && parameter.getParameterType().equals(Integer.class);
        //타입이 Integer가 아니면 Spring은 다른 Resolver를 찾는다. (따로 유효성 관여 X)
    }

    @Override
    public Object resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory) throws Exception {

        String pageStr = webRequest.getParameter("page");

        if (pageStr == null || pageStr.isBlank()) {
            return 0; //페이징 기본값 0
        }

        try {
            int page = Integer.parseInt(pageStr);
            if (page < 1) {
                throw new PageHandler(ErrorStatus.PAGE_NOT_POSITIVE);
            }
            return page - 1;
        } catch (NumberFormatException e) {
            throw new PageHandler(ErrorStatus.PAGE_INVALID_TYPE);
        }
    }
}
