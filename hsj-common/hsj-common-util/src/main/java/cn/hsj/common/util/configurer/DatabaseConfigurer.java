package cn.hsj.common.util.configurer;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ DruidWebStatFilterConfigurer.class, TransactionConfigurer.class, MybatisPlusConfigurer.class })
public class DatabaseConfigurer {

}
