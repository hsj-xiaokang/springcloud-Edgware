package cn.hsj.web.demo.util;

import cn.hsj.common.util.constant.GlobleApplicationConstant;

/**
 * web访问service端的常量
 * @author hsj
 * @date 2017-06-13
 */
public final class AccessUtils {
	/**
	 * 定义访问服务层的字符串常量
	 * 由于配置中心的配置文件application.yml文件的server:
                                               context-path: /${spring.application.name}
                     启用了每个项目的上下文跟目录就是这个项目的name，所以根路径就是每个项目的名字                                        
	 */
   public final static String ATS_SERVICE_DEMO = "http://"+GlobleApplicationConstant.HSJ_SERVICE_DEMO+"/"+GlobleApplicationConstant.GLOBLE_APPLICATION_BASE_PATH__NAME+"/";
}
