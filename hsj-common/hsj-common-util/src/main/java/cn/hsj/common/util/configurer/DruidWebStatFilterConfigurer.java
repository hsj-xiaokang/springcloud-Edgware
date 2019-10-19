package cn.hsj.common.util.configurer;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

import cn.hsj.common.util.constant.LoggerConstant;

@Configuration
public class DruidWebStatFilterConfigurer extends WebStatFilter {

	/**
	 * 日志记录
	 */
	private final static Logger logger = LoggerFactory.getLogger(DruidWebStatFilterConfigurer.class);

	@Bean
	public ServletRegistrationBean druidStatViewServletRegistration() {
		logger.info(StringUtils.center("DruidStatView Init", LoggerConstant.FILLER_LENGTH_MIDDLE,
				LoggerConstant.FILLER_STRING));
		ServletRegistrationBean registration = new ServletRegistrationBean(new StatViewServlet());
		registration.addUrlMappings("/druid/*");
		return registration;
	}

	@Bean
	public FilterRegistrationBean druidWebStatFilterRegistration() {
		logger.info(StringUtils.center("DruidWebStatFilter Init", LoggerConstant.FILLER_LENGTH_MIDDLE,
				LoggerConstant.FILLER_STRING));
		FilterRegistrationBean registration = new FilterRegistrationBean(new WebStatFilter());
		registration.addUrlPatterns("/*");
		registration.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
		return registration;
	}
}
