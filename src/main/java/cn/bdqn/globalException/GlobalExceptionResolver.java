package cn.bdqn.globalException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理器
 * @ClassName GlobalExceptionResolver
 * @Description TODO(全局异常处理器)
 * @author yw
 * @Date 2018年2月23日 下午6:55:11
 * @version 1.0.0
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        System.err.println("GlobalExceptionResolver==============>>"+ex.getMessage()+ex.getStackTrace());
        ex.printStackTrace();
        return new ModelAndView("redirect:/404.jsp");
    }

}
