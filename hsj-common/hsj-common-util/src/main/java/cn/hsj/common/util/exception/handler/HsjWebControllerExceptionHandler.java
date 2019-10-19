package cn.hsj.common.util.exception.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cn.hsj.common.util.vo.ResponseVO;


/**
 * HsjWebControllerExpose层全局异常处理
 * 
 * @author hsj
 *
 */
@RestControllerAdvice
public class HsjWebControllerExceptionHandler {
	/**
	 * 日志记录
	 */
	private static final Logger logger = LoggerFactory.getLogger(HsjWebControllerExceptionHandler.class);

	/**
	 * 全局异常处理
	 * @param e
	 * @param resuest
	 * @param response
	 * @return 调用失败通用返回对象
	 */
	@ExceptionHandler(value = { Exception.class })
	public ResponseVO exceptionHandler(Exception e, HttpServletRequest resuest, HttpServletResponse response) {

		// 先记录日志
		logger.error("全局异常捕获", e);

		// 对外返回调用失败
		return ResponseVO.errorWithMessage(ResponseVO.ERR_1, String.format("[应用层][系统异常]，异常信息:%s", e.getMessage()));
	}
	
}
