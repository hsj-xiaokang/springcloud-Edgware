package cn.hsj.service.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.hsj.common.entity.TSysDictExtend;
import cn.hsj.common.service.IAtsTestService;
import cn.hsj.common.util.exception.HsjServiceException;
import cn.hsj.common.util.vo.ResponseVO;


/**
 * 查询表里面的记录
 * @author hsj
 * @date 2017-06-15
 */
@RestController
@RequestMapping("/DemoIdFindExpose")
public class DemoIdFindController {
	/**
	 * 日志记录
	 */
	private final static Logger logger = LoggerFactory.getLogger(DemoIdFindController.class);
	
	@Autowired
	private IAtsTestService difs;
	
	/**
	 * 查询包里面的记录
	 * @param id
	 * @return
	 * @throws AtsServiceException 
	 */
	@RequestMapping(path = "/DemoIdFindExposeMethod", method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseVO DemoIdFindExposeMethod(@RequestParam("id") Integer id ,@RequestBody TSysDictExtend tsde) throws HsjServiceException {
		logger.info(">>>>>>>@RequestBody TSysDictExtend tsde>>>>>>"+JSON.toJSONString(tsde));//测试数据打印
		logger.trace("DemoIdFindService.class method findById invoked !");
		return ResponseVO.success(difs.selectById(id));
	}
	
	/**
	 * 查询包里面的记录
	 * @param id
	 * @return
	 * @throws AtsServiceException 
	 */
	@RequestMapping(path = "/DemoIdFindExposeMethodV2", method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseVO DemoIdFindExposeMethod(@RequestParam("id") Integer id) throws HsjServiceException {
		logger.trace("DemoIdFindService.class method findById invoked !");
		return ResponseVO.success(difs.selectById(id));
	}
}
