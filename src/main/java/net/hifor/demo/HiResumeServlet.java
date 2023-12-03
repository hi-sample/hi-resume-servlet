package net.hifor.demo;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 */
@WebServlet(name = "HiResumeServlet", value = {"/api/resume"})
public class HiResumeServlet extends JsonHttpServlet {
    private JSONObject jsonObject;

    /**
     * 初始化
     */
    public void init() {
        String path;
        // 读取 personal.json
        path = ResourcePathUtil.getPath("personal.json");
        jsonObject = JsonFileReader.readJsonObjectFile(path);

        // 读取 education.json
        path = ResourcePathUtil.getPath("education.json");
        jsonObject.put("education", JsonFileReader.readJsonArrayFile(path));

        // 读取 experience.json
        path = ResourcePathUtil.getPath("experience.json");
        jsonObject.put("experience", JsonFileReader.readJsonArrayFile(path));

        // 读取 skills.json
        path = ResourcePathUtil.getPath("skills.json");
        jsonObject.put("skills", JsonFileReader.readJsonArrayFile(path));
    }

    /**
     * 响应get请求
     *
     * @param request  an {@link HttpServletRequest} object that
     *                 contains the request the client has made
     *                 of the servlet
     * @param response an {@link HttpServletResponse} object that
     *                 contains the response the servlet sends
     *                 to the client
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        sendJsonResponse(response,jsonObject);
    }

    public void destroy() {
    }


}