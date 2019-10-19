package cn.hsj.web.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cn.hsj.common.util.vo.ResponseVO;
import cn.hsj.web.demo.service.internal.ReturnResultDemoExposeClient;
import cn.hsj.web.demo.util.AccessUtils;


/**
 * 
 * 
 * ①一个demo含有FeignClient(使用Spring Cloud Feign作为HTTP客户端调用远程HTTP服务 )
 * ②一个没有FeignClient
 * 
 * web调用服务层
 * 包含有断路器使用Hystrix
 * 
 * @author hsj
 * @date 2017-06-13
 */
@RestController
@RequestMapping("/returnResultDemoWeb")
public class ReturnResultDemoController {
	
	    /**
	     * 日志记录
	     */
	    private final static Logger logger = LoggerFactory.getLogger(ReturnResultDemoController.class);
	    
	    /**
	     * 已经做了Robin客户端负载均衡
	     */
	    @Autowired
	    RestTemplate restTemplate;
	    
	    /**
	     * FeignClient注入(使用Spring Cloud Feign作为HTTP客户端调用远程HTTP服务)
	     */
	    @Autowired
	    ReturnResultDemoExposeClient returnResultDemoExposeClient;
	    
	    
	    /**①
	     * FeignClient(使用Spring Cloud Feign作为HTTP客户端调用远程HTTP服务)
	     * 一个demo调用服务层，包含有断路器使用Hystrix
	     * @return ResponseVO
	     */
	    @RequestMapping(value = "/returnSuccessWithDataDemoWebFeignClient", method = {RequestMethod.POST,RequestMethod.GET})
	    @HystrixCommand(fallbackMethod = "returnSuccessWithDataDemoWebFallback")
	    public ResponseVO returnSuccessWithDataDemoWebFeignClient() {
//	    	(使用Spring Cloud Feign作为HTTP客户端调用远程HTTP服务 )
	    	ResponseVO rvo =  returnResultDemoExposeClient.returnSuccessWithDataDemoWebFeignClient(); 
	    	return ResponseVO.successWithMessage(
	    			ObjectUtils.isEmpty(rvo.getMsg())?"调用service层成功,没有消息message":rvo.getMsg(),
	    			rvo.getData()
	    			);
	    }
	    
	    
	    /**②
	     * 一个demo调用服务层，包含有断路器使用Hystrix
	     * @return ResponseVO
	     */
	    @RequestMapping(value = "/returnSuccessWithDataDemoWeb", method = {RequestMethod.POST,RequestMethod.GET})
	    @HystrixCommand(fallbackMethod = "returnSuccessWithDataDemoWebFallback")
	    public ResponseVO returnSuccessWithDataDemoWeb() {
	    	ResponseVO rvo = restTemplate.getForObject(String.format("%s/returnResultDemo/returnSuccessWithDataDemo", AccessUtils.ATS_SERVICE_DEMO), ResponseVO.class);
	    	return ResponseVO.successWithMessage(
	    			ObjectUtils.isEmpty(rvo.getMsg())?"调用service层成功,没有消息message":rvo.getMsg(),
	    			rvo.getData()
	    			); 
	    }
	    
	    
	    /**
	     * returnSuccessWithDataDemoWeb 断路时候的方法
	     * @return ResponseVO
	     */
	    public ResponseVO returnSuccessWithDataDemoWebFallback() {
	    	logger.info("service服务已经挂了!");
	        return ResponseVO.errorWithMessage(ResponseVO.ERR_1, "service服务已经挂了！！,"
	        		+ "这句话会被返回看到，不会被@RestControllerAdvice切面处理捕获，"
	        		+ "详见：cn.agrithings.common.util.exception.handler.AtsServiceExposeExceptionHandler,"
	        		+ "断路器作用发生调用service层的服务挂了的情况会立即返回不用等待服务而导致消耗时间！");
	    }

}
