package cn.hsj.common.entity.generator;

import java.io.File;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class GeneratorApplication {

	
	private static String entityPath = "/cn/hsj/common/entity";
	
	private static String mapperPath = "/cn/hsj/common/mapper";
	
	public static void main(String[] args) {
		AutoGenerator mpg = new AutoGenerator();
		// 获得当前项目实体路径
		String projectPath = System.getProperty("user.dir") + "/src/main/java";
		String pro =projectPath.replace("hsj-common-entity-generator", "hsj-common-entity");
		
		// 获得当前项目XML路径

		// 先删除文件
		delAllFile(pro + entityPath);
		delAllFile(pro + mapperPath);
		System.out.println("-----开始生成实体-----");

		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		gc.setOutputDir(pro);
		gc.setFileOverride(true);
		gc.setActiveRecord(true);
		gc.setEnableCache(false);// XML 二级缓存
		gc.setBaseResultMap(true);// XML ResultMap
		gc.setBaseColumnList(false);// XML columList
		gc.setAuthor("hsj");
        gc.setOpen(false);
		// 自定义文件命名，注意 %s 会自动填充表实体属性！
		mpg.setGlobalConfig(gc);

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setDbType(DbType.MYSQL);
		dsc.setTypeConvert(new MySqlTypeConvert() {
			// 自定义数据库表字段类型转换【可选】
			@Override
			public DbColumnType processTypeConvert(String fieldType) {
				// System.out.println("转换类型：" + fieldType);
				return super.processTypeConvert(fieldType);
			}
		});
		dsc.setDriverName("com.mysql.jdbc.Driver");
		dsc.setUsername("root");
		dsc.setPassword("HSJissmart1");
		dsc.setUrl("jdbc:mysql://127.0.0.1:3307/hsj?useSSL=false&allowMultiQueries=true&useUnicode=true&characterEncoding=utf8");
		mpg.setDataSource(dsc);

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		// 此处可以修改为您的表前缀
		strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略		
		mpg.setStrategy(strategy);

		// 包配置
		PackageConfig pc = new PackageConfig();
		pc.setParent("cn.hsj");
		pc.setModuleName("common");
		pc.setEntity("entity");
		pc.setMapper("mapper");
		pc.setXml("mapper");
        pc.setService("service");
        pc.setServiceImpl("service");
        mpg.setPackageInfo(pc);
		

		// 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/template 下面内容修改，
		// 放置自己项目的 src/main/resources/template 目录下, 默认名称一下可以不配置，也可以自定义模板名称
		TemplateConfig tc = new TemplateConfig();
		// tc.setController("...");
		tc.setController(null);
//		tc.setServiceImpl(null);
//		tc.setService(null);
		// 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
		mpg.setTemplate(tc);

		// 执行生成
		
		mpg.execute();

		System.out.println("-----生成完毕-----");



	}

	public static boolean delAllFile(String path) {
		boolean flag = false;
		File file = new File(path);
		if (!file.exists()) {
			return flag;
		}
		if (!file.isDirectory()) {
			return flag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
				flag = true;
			}
//			if (temp.isDirectory()) {
//				delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
//				delFolder(path + "/" + tempList[i]);// 再删除空文件夹
//				flag = true;
//			}
		}
		return flag;
	}

	// 删除文件夹
	public static void delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			myFilePath.delete(); // 删除空文件夹
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
