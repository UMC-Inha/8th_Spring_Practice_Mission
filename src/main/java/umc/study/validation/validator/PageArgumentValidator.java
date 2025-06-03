package umc.study.validation.validator;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.PageHandler;
import umc.study.validation.annotation.ValidatedPage;

@Component
public class PageArgumentValidator implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(ValidatedPage.class) &&
                parameter.getParameterType().equals(Integer.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) {

        String pageParam = webRequest.getParameter("page");

        if (pageParam == null) {
            return 0; // 기본값
        }

        try {
            int page = Integer.parseInt(pageParam);
            if (page < 1) {
                throw new PageHandler(ErrorStatus.INVALID_PAGE); // 커스텀 예외
            }

            return page - 1; // 내부 로직은 0-based
        } catch (NumberFormatException e) {
            throw new PageHandler(ErrorStatus.INVALID_PAGE_FORMAT);
        }
    }
}
