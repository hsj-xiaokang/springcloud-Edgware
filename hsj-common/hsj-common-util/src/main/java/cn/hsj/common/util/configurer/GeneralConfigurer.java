package cn.hsj.common.util.configurer;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ TimeZoneConfigurer.class, RestTemplateConfigurer.class, WebMvcConfigurer.class })
public class GeneralConfigurer {

}
