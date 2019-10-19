package cn.hsj.service.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.hsj.common.util.exception.HsjServiceException;
import cn.hsj.common.util.vo.ResponseVO;

/**
 * 演示控制器,如何返回结果
 * 
 * @author Leesam
 *
 */
@RestController
@RequestMapping("/returnResultDemo")
public class ReturnResultDemoController {// @Expose、@Service、@External注解过的类，不允许派生子类，但是也不允许用final修饰

	/**
	 * 日志记录
	 */
	private final static Logger logger = LoggerFactory.getLogger(ReturnResultDemoController.class);

	/**
	 * 调用成功返回示例，没有数据
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/returnSuccessDemo", method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseVO returnSuccessDemo() throws Exception {
		return ResponseVO.success();
	}

	/**
	 * 调用成功返回示例，有数据
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/returnSuccessWithDataDemo", method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseVO returnSuccessWithDataDemo() throws Exception {
		return ResponseVO.success("这是数据");
	}

	/**
	 * 调用成功返回示例，有提示信息，没有数据
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/successWithMessageDemo", method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseVO successWithMessageDemo() throws Exception {
		return ResponseVO.successWithMessage("这是提示信息");

	}

	/**
	 * 调用成功返回示例，有提示信息，有数据
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/successDemoWithMessageAndData", method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseVO successDemoWithMessageAndData() throws Exception {
		return ResponseVO.successWithMessage("这是提示信息", "这是数据");

	}

	/**
	 * ***注意***严禁在代码中使用，有问题直接抛异常HsjServiceException，参考HsjServiceException
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/returnError", method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseVO returnError() throws Exception {
		return ResponseVO.errorWithMessage(ResponseVO.ERR_1, "这是错误提示消息");
	}

	/**
	 * 系统，框架的异常，不用手动抛出，让系统自动抛出,出现这类异常非特殊情况一般代表程序写得有问题，逻辑不够严谨，没有捕获到相关异常并处理
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/onException", method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseVO onException() throws Exception {
		int foo = 1 / 0;// 制造系统异常
		logger.info(Integer.toString(foo));// 这里永远执行不到
		return ResponseVO.errorWithMessage(ResponseVO.ERR_1, "这是错误提示消息");
	}

	/**
	 * 业务异常，手动抛出，服务层请使用HsjServiceException的静态方法方法进行抛出，详细情况请看ThrowExceptionDemo
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(path = "/onAtsServiceException", method = {RequestMethod.POST,RequestMethod.GET})
	public ResponseVO onAtsServiceException() throws Exception {
		throw new HsjServiceException();
	}

}