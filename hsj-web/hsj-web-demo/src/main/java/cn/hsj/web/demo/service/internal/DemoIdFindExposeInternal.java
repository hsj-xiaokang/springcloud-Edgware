package cn.hsj.web.demo.service.internal;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.hsj.common.entity.TSysDictExtend;
import cn.hsj.common.util.constant.GlobleApplicationConstant;
import cn.hsj.common.util.vo.ResponseVO;

/**
 * 测试MySQL mybatis 数据  自己定义实体方式
 * @author hsj
 * @date 2017-06-17
 */
@Component 
@FeignClient(""+GlobleApplicationConstant.HSJ_SERVICE_DEMO)
public interface DemoIdFindExposeInternal {
	//含有参数的FeignClient
	 @RequestMapping(value = "/"+GlobleApplicationConstant.GLOBLE_APPLICATION_BASE_PATH__NAME+"/DemoIdFindExpose/DemoIdFindExposeMethod", method = RequestMethod.POST)
     ResponseVO DemoIdFindExposeInternalFeignClient(@RequestParam("id") Integer id,@RequestBody TSysDictExtend tsde);
}
