package cn.intellif.bucheng.yin.springfeignconsumer.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

public abstract class WebUtils {

    private static ServletRequestAttributes getAttribute(){
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

    public static HttpServletRequest getRequest(){
        return getAttribute().getRequest();
    }

    public static HttpServletResponse getResponse(){
        return getAttribute().getResponse();
    }

    public static String getLogId(){
        String logId = getRequest().getHeader("logId");
        if(logId==null){
            logId = (String) getRequest().getAttribute("logId");
            if(logId==null) {
                logId = UUID.randomUUID().toString();
                getRequest().setAttribute("logId", logId);
            }
        }
        return logId;
    }
}
