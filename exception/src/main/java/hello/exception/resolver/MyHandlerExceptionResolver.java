package hello.exception.resolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Slf4j
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        try {
            if (ex instanceof IllegalArgumentException) {
                log.info("IllegalArgumentException resolver to 400");
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
                //빈 ModelAndView를 반환하면 view를 렌더링하지 않고 서블릿을 리턴
                //view를 지정하면 view를 렌더링함
                return new ModelAndView();
            }
        } catch (IOException e) {
            log.error("resolver ex", ex);
        }
        //null을 반환하면 다음 ExceptionResolver를 찾고, 더 이상 찾을게 없다면
        //WAS까지 흘러가서 최종적으로 에러 코드를 반환
        return null;
    }
}
