package cn.hsj.common.util.vo;

/**
 * 接口调用统一返回对象（为防止出错不提供set方法，请通过静态方法error、success、successWithMessage获取对象）
 * 
 * @author hsj
 *
 */
public final class ResponseVO {
	public final static int  ERR_0 = 0;
	public final static int  ERR_1 = 1;
	/**
	 * 错误码（为0时代表无错）
	 * 错误码（为1时代表有错）
	 */
	private Integer err = ERR_0;

	/**
	 * 错误消息
	 */
	private String msg = null;

	/**
	 * 数据对象
	 */
	private Object data = null;

	/**
	 * 构造函数
	 */
	private ResponseVO() {

	}

	/**
	 * 构造函数
	 */
	private ResponseVO(Object data) {
		this.data = data;
	}

	/**
	 * 构造函数
	 */
	private ResponseVO(String msg) {
		this.msg = msg;
	}

	/**
	 * 构造函数
	 */
	private ResponseVO(String msg, Object data) {
		this.msg = msg;
		this.data = data;
	}

	/**
	 * 构造函数
	 */
	private ResponseVO(Integer err, String msg) {
		this.err = err;
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public Integer getErr() {
		return err;
	}

	public String getMsg() {
		return msg;
	}

	/**
	 * 获取接口调用统一返回对象
	 * 
	 * @param err
	 *            错误码（不能为0）
	 * @param msg
	 *            提示消息（必须设置提示消息）
	 * @return 接口调用统一返回对象
	 */
	public static ResponseVO errorWithMessage(int err, String msg) {
		return new ResponseVO(err, msg);
	}

	/**
	 * 获取接口调用统一返回对象
	 * 
	 * @return 接口调用统一返回对象
	 */
	public static ResponseVO success() {
		return new ResponseVO();
	}

	/**
	 * 获取接口调用统一返回对象
	 * 
	 * @param data
	 *            待返回数据
	 * @return 接口调用统一返回对象
	 */
	public static ResponseVO success(Object data) {
		return new ResponseVO(data);
	}

	/**
	 * 获取接口调用统一返回对象
	 * 
	 * @param msg
	 *            提示消息
	 * @return 接口调用统一返回对象
	 */
	public static ResponseVO successWithMessage(String msg) {
		return new ResponseVO(msg);
	}

	/**
	 * 获取接口调用统一返回对象
	 * 
	 * @param msg
	 *            提示消息
	 * @param data
	 *            待返回数据
	 * @return 接口调用统一返回对象
	 */
	public static ResponseVO successWithMessage(String msg, Object data) {
		return new ResponseVO(msg, data);
	}
}
