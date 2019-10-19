package cn.hsj.service.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import cn.hsj.common.util.configurer.DatabaseConfigurer;
import cn.hsj.common.util.configurer.GeneralConfigurer;
import cn.hsj.common.util.exception.handler.HsjServiceControllerExceptionHandler;

@SpringCloudApplication
@EnableFeignClients
@ComponentScan(basePackages="cn.hsj.*")
@Import({ GeneralConfigurer.class, HsjServiceControllerExceptionHandler.class, DatabaseConfigurer.class })
public class DemoApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApplication.class, args);
	}

}
