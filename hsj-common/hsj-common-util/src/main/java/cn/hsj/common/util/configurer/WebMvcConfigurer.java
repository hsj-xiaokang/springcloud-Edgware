package cn.hsj.common.util.configurer;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import cn.hsj.common.util.constant.LoggerConstant;

@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
	
	/**
	 * 日志记录
	 */
	private final static Logger logger = LoggerFactory.getLogger(WebMvcConfigurer.class);
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		logger.info(StringUtils.center("CorsMapping Init", LoggerConstant.FILLER_LENGTH_MIDDLE,
				LoggerConstant.FILLER_STRING));
		registry.addMapping("/**").allowedHeaders("*").allowedMethods("*").allowedOrigins("*");
	}
}
