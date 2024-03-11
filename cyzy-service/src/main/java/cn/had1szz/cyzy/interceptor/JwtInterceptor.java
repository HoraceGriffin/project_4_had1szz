package cn.had1szz.cyzy.interceptor;


import cn.had1szz.cyzy.util.TokenGenerator;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : Horace Leoi
 * @since : 2024/3/7
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {

    private final TokenGenerator tokenGenerator;
    private final ThreadLocal<Long> threadLocal;

    public JwtInterceptor(TokenGenerator tokenGenerator, ThreadLocal<Long> threadLocal) {
        this.tokenGenerator = tokenGenerator;
        this.threadLocal = threadLocal;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("authorization");

        if (request.getRequestURI().contains(".")) {
            return true;
        }
        if (!StringUtils.hasLength(authorization)) {
            throw new RuntimeException("请携带Token");
        }
        if (!authorization.startsWith("Bearer ")) {
            throw new RuntimeException("Token格式错误");
        }

        Long uid = tokenGenerator.getUid(authorization);
        threadLocal.set(uid);

        return !tokenGenerator.isTokenExpired(authorization);
    }

}
