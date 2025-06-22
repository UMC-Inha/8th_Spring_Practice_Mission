package umc.study.config.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.GeneralException;
import umc.study.validation.annotation.PageableParam;

@Component
public class PageableParamArgumentResolver extends PageableHandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(Pageable.class) && 
               parameter.hasParameterAnnotation(PageableParam.class);
    }

    @Override
    public Pageable resolveArgument(MethodParameter methodParameter, ModelAndViewContainer mavContainer,
                                   NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        
        Pageable pageable = super.resolveArgument(methodParameter, mavContainer, webRequest, binderFactory);

        String pageParam = webRequest.getParameter("page");

        if (pageParam != null) {
            try {
                int page = Integer.parseInt(pageParam);
                if (page <= 0) {
                    throw new GeneralException(ErrorStatus.PAGE_NUMBER_TOO_SMALL);
                }

                return PageRequest.of(page - 1, pageable.getPageSize(), pageable.getSort());
            } catch (NumberFormatException e) {
                throw new GeneralException(ErrorStatus.INVALID_PAGE_NUMBER);
            }
        }
        
        return pageable;
    }
}

// return PageRequest.of(page - 1, pageable.getPageSize(), pageable.getSort());에서 page -1은
// **사용자 기준(1-based)**을 **Spring 기준(0-based)**으로 맞춰주는 보정 작업