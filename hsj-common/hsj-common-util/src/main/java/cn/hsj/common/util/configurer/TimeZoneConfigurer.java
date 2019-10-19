package cn.hsj.common.util.configurer;

import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import cn.hsj.common.util.constant.LoggerConstant;

@Configuration
public class TimeZoneConfigurer {

	/**
	 * 日志记录
	 */
	private final static Logger logger = LoggerFactory.getLogger(TimeZoneConfigurer.class);
	
	@Bean
	@Primary
	public TimeZone timeZone() {
		logger.info(StringUtils.center("TimeZone Init", LoggerConstant.FILLER_LENGTH_MIDDLE,
				LoggerConstant.FILLER_STRING));
		TimeZone timeZone = TimeZone.getTimeZone("Asia/Shanghai");
		TimeZone.setDefault(timeZone);
		return timeZone;
	}

}
