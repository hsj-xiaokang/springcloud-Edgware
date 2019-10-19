package cn.hsj.web.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import cn.hsj.common.util.configurer.GeneralConfigurer;
import cn.hsj.common.util.exception.handler.HsjWebControllerExceptionHandler;

@SpringCloudApplication
@EnableFeignClients
//数据库相关的配置不扫描
@ComponentScan(
basePackages="cn.hsj.web.*,"
		+ "cn.hsj.common.entity.*,"
		+ "cn.hsj.common.mapper.*,"
		+ "cn.hsj.common.service.*"
)
@Import({ GeneralConfigurer.class, HsjWebControllerExceptionHandler.class })
public class DemoApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApplication.class, args);
	}

}
