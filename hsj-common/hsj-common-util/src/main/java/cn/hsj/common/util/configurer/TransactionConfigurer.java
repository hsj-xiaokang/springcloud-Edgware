package cn.hsj.common.util.configurer;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import cn.hsj.common.util.constant.LoggerConstant;

@Configuration
@EnableTransactionManagement
public class TransactionConfigurer implements TransactionManagementConfigurer {

	/**
	 * 日志记录
	 */
	private final static Logger logger = LoggerFactory.getLogger(TransactionConfigurer.class);

	@Autowired
	private DataSource dataSource;

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		logger.info(StringUtils.center("Override AnnotationDrivenTransactionManager", LoggerConstant.FILLER_LENGTH_MIDDLE, LoggerConstant.FILLER_STRING));
		return txManager();
	}

	@Bean
	public PlatformTransactionManager txManager() {
		logger.info(StringUtils.center("Creating Bean txManager", LoggerConstant.FILLER_LENGTH_MIDDLE, LoggerConstant.FILLER_STRING));
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	public TransactionInterceptor transactionInterceptor(PlatformTransactionManager platformTransactionManager) {
		logger.info(StringUtils.center("Creating Bean TransactionInterceptor", LoggerConstant.FILLER_LENGTH_MIDDLE, LoggerConstant.FILLER_STRING));

		TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
		// 事物管理器
		transactionInterceptor.setTransactionManager(annotationDrivenTransactionManager());
		Properties transactionAttributes = new Properties();

		// 查询
		transactionAttributes.setProperty("select*", "PROPAGATION_REQUIRED,-Throwable,readOnly");
		transactionAttributes.setProperty("get*", "PROPAGATION_REQUIRED,-Throwable,readOnly");
		transactionAttributes.setProperty("query*", "PROPAGATION_REQUIRED,-Throwable,readOnly");
		transactionAttributes.setProperty("fetch*", "PROPAGATION_REQUIRED,-Throwable,readOnly");
		transactionAttributes.setProperty("search*", "PROPAGATION_REQUIRED,-Throwable,readOnly");
		transactionAttributes.setProperty("find*", "PROPAGATION_REQUIRED,-Throwable,readOnly");
		transactionAttributes.setProperty("list*", "PROPAGATION_REQUIRED,-Throwable,readOnly");

		transactionAttributes.setProperty("insert*", "PROPAGATION_REQUIRED,-Throwable");//插入
		transactionAttributes.setProperty("add*", "PROPAGATION_REQUIRED,-Throwable");//增加
		transactionAttributes.setProperty("create*", "PROPAGATION_REQUIRED,-Throwable");//创建
		transactionAttributes.setProperty("append*", "PROPAGATION_REQUIRED,-Throwable");//追加
		transactionAttributes.setProperty("assign*", "PROPAGATION_REQUIRED,-Throwable");//赋予
		transactionAttributes.setProperty("designate*", "PROPAGATION_REQUIRED,-Throwable");//指派
		transactionAttributes.setProperty("impower*", "PROPAGATION_REQUIRED,-Throwable");//授权
		transactionAttributes.setProperty("empower*", "PROPAGATION_REQUIRED,-Throwable");//授权
		transactionAttributes.setProperty("update*", "PROPAGATION_REQUIRED,-Throwable");//更新
		transactionAttributes.setProperty("set*", "PROPAGATION_REQUIRED,-Throwable");//设置
		transactionAttributes.setProperty("save*", "PROPAGATION_REQUIRED,-Throwable");//保存
		transactionAttributes.setProperty("edit*", "PROPAGATION_REQUIRED,-Throwable");//编辑
		transactionAttributes.setProperty("reset*", "PROPAGATION_REQUIRED,-Throwable");//重置
		transactionAttributes.setProperty("enable*", "PROPAGATION_REQUIRED,-Throwable");//启用
		transactionAttributes.setProperty("disable*", "PROPAGATION_REQUIRED,-Throwable");//禁用
		transactionAttributes.setProperty("allow*", "PROPAGATION_REQUIRED,-Throwable");//允许
		transactionAttributes.setProperty("disallow*", "PROPAGATION_REQUIRED,-Throwable");//拒绝
		transactionAttributes.setProperty("upgrade*", "PROPAGATION_REQUIRED,-Throwable");//升级
		transactionAttributes.setProperty("degrade*", "PROPAGATION_REQUIRED,-Throwable");//降级
		transactionAttributes.setProperty("increase*", "PROPAGATION_REQUIRED,-Throwable");//增加
		transactionAttributes.setProperty("decrease*", "PROPAGATION_REQUIRED,-Throwable");//减少
		transactionAttributes.setProperty("permit*", "PROPAGATION_REQUIRED,-Throwable");//允许
		transactionAttributes.setProperty("refuse*", "PROPAGATION_REQUIRED,-Throwable");//拒绝
		transactionAttributes.setProperty("accept*", "PROPAGATION_REQUIRED,-Throwable");//拒绝
		transactionAttributes.setProperty("receive*", "PROPAGATION_REQUIRED,-Throwable");//接收
		transactionAttributes.setProperty("reject*", "PROPAGATION_REQUIRED,-Throwable");//拒绝
		transactionAttributes.setProperty("deny*", "PROPAGATION_REQUIRED,-Throwable");//拒绝
		transactionAttributes.setProperty("reduce*", "PROPAGATION_REQUIRED,-Throwable");//削减
		transactionAttributes.setProperty("mark*", "PROPAGATION_REQUIRED,-Throwable");//标记
		transactionAttributes.setProperty("sign*", "PROPAGATION_REQUIRED,-Throwable");//标记
		transactionAttributes.setProperty("clean*", "PROPAGATION_REQUIRED,-Throwable");//清理
		transactionAttributes.setProperty("clear*", "PROPAGATION_REQUIRED,-Throwable");//清理
		transactionAttributes.setProperty("empty*", "PROPAGATION_REQUIRED,-Throwable");//清空
		transactionAttributes.setProperty("del*", "PROPAGATION_REQUIRED,-Throwable");//删除
		transactionAttributes.setProperty("flush*", "PROPAGATION_REQUIRED,-Throwable");//刷新
		transactionAttributes.setProperty("remove*", "PROPAGATION_REQUIRED,-Throwable");//移除
		transactionAttributes.setProperty("register*", "PROPAGATION_REQUIRED,-Throwable");
		transactionAttributes.setProperty("unregister*", "PROPAGATION_REQUIRED,-Throwable");
		transactionAttributes.setProperty("cancel*", "PROPAGATION_REQUIRED,-Throwable");
		transactionAttributes.setProperty("abolish*", "PROPAGATION_REQUIRED,-Throwable");
		transactionAttributes.setProperty("login*", "PROPAGATION_REQUIRED,-Throwable");
		transactionAttributes.setProperty("logout*", "PROPAGATION_REQUIRED,-Throwable");
		
		
		//为防止意外，所有方法都拦截一把
		transactionAttributes.setProperty("*", "PROPAGATION_REQUIRED,-Throwable");
		
		transactionInterceptor.setTransactionAttributes(transactionAttributes);
		return transactionInterceptor;
	}

	// 代理到ServiceImpl的Bean
	@Bean
	public BeanNameAutoProxyCreator transactionAutoProxy() {
		logger.info(StringUtils.center("Creating Bean BeanNameAutoProxyCreator", LoggerConstant.FILLER_LENGTH_MIDDLE, LoggerConstant.FILLER_STRING));

		BeanNameAutoProxyCreator transactionAutoProxy = new BeanNameAutoProxyCreator();
		transactionAutoProxy.setProxyTargetClass(true);
		transactionAutoProxy.setBeanNames(new String[] { "*Service", "*ServiceImpl" });
		transactionAutoProxy.setInterceptorNames(new String[] { "transactionInterceptor" });
		return transactionAutoProxy;
	}

}
