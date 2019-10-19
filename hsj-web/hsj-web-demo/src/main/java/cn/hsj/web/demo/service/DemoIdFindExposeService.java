package cn.hsj.web.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import cn.hsj.common.entity.TSysDictExtend;
import cn.hsj.common.util.exception.HsjWebException;
import cn.hsj.common.util.vo.ResponseVO;
import cn.hsj.web.demo.service.internal.DemoIdFindExposeInternal;

/**
 * 测试MySQL mybatis 数据  自己定义实体方式
 * @author hsj
 * @date 2017-06-17
 */
@Service
public class DemoIdFindExposeService {
	/**
	 * 日志记录
	 */
	private final static Logger logger = LoggerFactory.getLogger(DemoIdFindExposeService.class);
	
	//注入FeignClient
	@Autowired
	private DemoIdFindExposeInternal demoIdFindExposeInternal;
	
	/**
	 * FeignClient调用sevice层服务
	 * 查询一个表里面的数据字段
	 * @param id
	 * @return
	 * @throws AtsServiceException
	 */
	public Object findById(Integer id,TSysDictExtend tsde) throws HsjWebException{
		if(ObjectUtils.isEmpty(id) || id.intValue() < 0){
			logger.error("DemoIdFindExposeService.class method findById params err!");
			throw new HsjWebException("DemoIdFindExposeService.class method findById params err!");
		}
		ResponseVO rvo = demoIdFindExposeInternal.DemoIdFindExposeInternalFeignClient(id,tsde);
		return rvo.getData();
		 
	}
}
