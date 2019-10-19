package cn.hsj.web.demo.service.internal;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.hsj.common.util.constant.GlobleApplicationConstant;
import cn.hsj.common.util.vo.ResponseVO;


/**
 * 
 * FeignClient(使用Spring Cloud Feign作为HTTP客户端调用远程HTTP服务 )
 * @author hsj
 * @date 2017-06-14
 */
@Component 
@FeignClient(""+GlobleApplicationConstant.HSJ_SERVICE_DEMO)
public interface ReturnResultDemoExposeClient {
           
	     @RequestMapping(value = "/"+GlobleApplicationConstant.GLOBLE_APPLICATION_BASE_PATH__NAME+"/returnResultDemo/returnSuccessWithDataDemo", method = RequestMethod.GET)
	     ResponseVO returnSuccessWithDataDemoWebFeignClient();
}
