package cn.hsj.web.demo.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.hsj.common.entity.TSysDictExtend;
import cn.hsj.common.util.exception.HsjWebException;
import cn.hsj.common.util.vo.ResponseVO;
import cn.hsj.web.demo.service.DemoIdFindExposeService;



/**
 * 测试MySQL mybatis 数据  自己定义实体方式
 * @author hsj
 * @date 2017-06-17
 */
@RestController
@RequestMapping("/DemoIdFindExposeWEB")
public class DemoIdFindController {
	/**
	 * 日志记录
	 */
	private final static Logger logger = LoggerFactory.getLogger(DemoIdFindController.class);
	
	//注入服务
	@Autowired
	private DemoIdFindExposeService demoIdFindExposeService;
	
	/**
	 * 调用一个表里面的数据，从这里web层开始
	 * @param id
	 * @return
	 * @throws AtsServiceException
	 */
	@RequestMapping(path = "/DemoIdFindExposeFindById", method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseVO DemoIdFindExposeFindById(@RequestParam("id") Integer id ) throws HsjWebException{
		logger.trace("DemoIdFindExpose.class method DemoIdFindExposeFindById invoked !");
		        //测试数据post 传递给service层    service层使用@RequestBody接收;
		        //其实这个实体可以从前端ajax传入，这里使用@RequestBody接收,比如见下面第三行注释：
		        //public ResponseVO DemoIdFindExposeFindById(@RequestParam("id") Integer id,@RequestBody TSysDictExtend tsde ) throws AtsServiceException{
				TSysDictExtend tsde = new TSysDictExtend();
				tsde.setCreate_time(new Date());
				tsde.setCreator("00-00-00-00-00");
				tsde.setDict_code("00-00-00-00-00");
				tsde.setDict_item_label("demo");
				tsde.setDict_item_string("aother demo");
				tsde.setUpdate_time(new Date());
				Short status = 1;
				tsde.setStatus(status);
				tsde.setSort(1);
				Short is_delete = 1;
				tsde.setIs_delete(is_delete);
				tsde.setId(100);
				tsde.setDict_name("agin demo");
				
		return ResponseVO.success(demoIdFindExposeService.findById(id,tsde));
	}
}
