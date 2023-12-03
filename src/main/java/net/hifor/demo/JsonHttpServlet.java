package net.hifor.demo;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author IKin <br/>
 * @description response返回json格式 <br/>
 * @create 2023/12/3 22:00 <br/>
 */
public class JsonHttpServlet extends HttpServlet {

    protected void sendJsonResponse(HttpServletResponse response, JSONObject jsonObject) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonObject.toJSONString());
    }

    protected void sendErrorMessage(HttpServletResponse response, String errorMessage) throws IOException {
        JSONObject errorJson = new JSONObject();
        errorJson.put("error", errorMessage);
        sendJsonResponse(response, errorJson);
    }
}
