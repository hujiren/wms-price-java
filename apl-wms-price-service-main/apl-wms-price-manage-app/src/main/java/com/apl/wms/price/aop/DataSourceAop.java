package com.apl.wms.price.aop;

import com.apl.lib.constants.CommonAplConstants;
import com.apl.lib.datasource.DataSourceContextHolder;
import com.apl.lib.security.SecurityUser;
import com.apl.lib.utils.CommonContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Map;

/**
 * @author hjr start
 * @date 2020/6/21 - 10:33
 */
@Aspect
@Component
public class DataSourceAop {

    @Autowired
    RedisTemplate redisTemplate;

    @Pointcut("execution(public * com.apl.wms.price.controller.*.*(..))")
    public void datasourceAop(){}

    @Around("datasourceAop()")
    public Object doInvoke(ProceedingJoinPoint pjp){
        Object proceed = null;

        try {
            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            String token = servletRequestAttributes.getRequest().getHeader(CommonAplConstants.TOKEN_FLAG);
            if(StringUtils.isEmpty(token)){
                Map<String, String[]> urlParams = servletRequestAttributes.getRequest().getParameterMap();
                String[] arr = urlParams.get("token");
                if(arr.length > 0){
                    token = arr[0];
                }
            }
            SecurityUser securityUser = CommonContextHolder.getSecurityUser(redisTemplate, token);
            CommonContextHolder.securityUserContextHolder.set(securityUser);
            DataSourceContextHolder.set(securityUser.getTenantGroup(), securityUser.getInnerOrgCode(), securityUser.getInnerOrgId());

            Object[] args = pjp.getArgs();
            proceed = pjp.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {
            CommonContextHolder.securityUserContextHolder.remove();
            CommonContextHolder.tokenContextHolder.remove();
            DataSourceContextHolder.clear();
        }

        return proceed;
    }
}
