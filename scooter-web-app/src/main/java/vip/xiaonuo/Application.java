
package vip.xiaonuo;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SpringBoot方式启动类
 *
 * @author xuyuxiang
 * @date 2021/12/18 16:57
 */
@Slf4j
@RestController
@SpringBootApplication
public class Application {

    /* 解决druid 日志报错：discard long time none received connection:xxx */
    static {
        System.setProperty("druid.mysql.usePingMethod","false");
    }

    /**
     * 主启动函数
     *
     * @author xuyuxiang
     * @date 2022/7/30 21:42
     */
    @SneakyThrows
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
        Environment env = configurableApplicationContext.getEnvironment();
        log.info("""
                        
                        ----------------------------------------------------------
                        Application is running! Access URLs:
                        Local:    http://localhost:{}
                        Doc:      http://localhost:{}/doc.html
                        ----------------------------------------------------------""",
                env.getProperty("server.port"),
                env.getProperty("server.port"));
    }

    /**
     * 首页
     *
     * @author xuyuxiang
     * @date 2022/7/8 14:22
     **/
    @GetMapping("/")
    public String index() {
        return "WELCOME";
    }
}
