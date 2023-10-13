package com.example.demo2.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RenRui * @version v1.0.0.0
 * Created DateTime 2023/10/13 10:06
 */
//@Configuration
@Component
public class RunConfig implements CommandLineRunner {
    private static final Logger log = LogManager.getLogger(RunConfig.class);

    //@Value("${openProject.isOpen}")
    private boolean isOpen = true;

    //@Value("${openProject.web.openUrl}")
    private List<String> openUrl = new ArrayList<String>() {{
        add("http://localhost:8666/swagger-ui.html");
        add("http://localhost:8666/h2");
    }};


    //@Value("${openProject.cmd}")
    private String cmd = "cmd /c start ";

    @Override
    public void run(String... args){
        if(isOpen){
            for (String openUrl : openUrl) {
                String runCmd = cmd + " " + openUrl ;
                System.out.println("运行的命令: " + runCmd);
                Runtime run = Runtime.getRuntime();
                try {
                    run.exec(runCmd);
                    log.info("启动浏览器打开{}成功",openUrl);
                } catch (Exception e) {
                    log.error("启动浏览器打开{}失败",openUrl,e);
                }
            }
        }
    }
}
