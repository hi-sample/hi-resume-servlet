package net.hifor.demo;

import java.net.URL;

/**
 * @author IKin <br/>
 * @description resource path 工具类 <br/>
 * @create 2023/12/2 16:18 <br/>
 */
public class ResourcePathUtil {
    /**
     * 获取resources目录下文件的完整路径
     * @param fileName 文件名称
     * @return 完整路径
     */
    public static String getPath(String fileName) {
        // 相对于 resources 目录的文件路径
        ClassLoader classLoader = HiResumeServlet.class.getClassLoader();
        URL resourceURL = classLoader.getResource(fileName);

        if (resourceURL != null) {
            System.out.println("Full path of " + fileName + ": " + resourceURL.getPath());
            return resourceURL.getPath();
        } else {
            throw new RuntimeException("Resource not found: " + fileName);
        }
    }
}
