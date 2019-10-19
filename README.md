# springcloud-Edgware
springcloud-Edgware模块化版本的demo，
<br />目前集成mybatis-plus，
<br />使用了springcloud-config本地配置文件方式，
<br />springcloud-eureka的HA高可用，
<br />springcloud-restTemplate+ribbon服务调用，
<br />springcloud-feignClient服务调用


项目结构<br />
  &nbsp;公共代码<br />
  &nbsp;本地配置文件：hsj-common\hsj-common-config-server\src\main\resources\hsjconfig <br />
  &nbsp;hsj-common<br />
     <br /> &nbsp;&nbsp;&nbsp;&nbsp;hsj-common-config-server&nbsp;&nbsp;&nbsp;&nbsp;----配置中心   
     <br /> &nbsp;&nbsp;&nbsp;&nbsp;hsj-common-entity&nbsp;&nbsp;&nbsp;&nbsp;----mybatis-plus生成需要的实体和mapper和服务         
     <br /> &nbsp;&nbsp;&nbsp;&nbsp;hsj-common-entity-generator&nbsp;&nbsp;&nbsp;&nbsp;----mybatis-plus实体生成器
     <br /> &nbsp;&nbsp;&nbsp;&nbsp;hsj-common-eureka-server&nbsp;&nbsp;&nbsp;&nbsp;----eureka 服务发现，HA配置master
     <br /> &nbsp;&nbsp;&nbsp;&nbsp;hsj-common-eureka-server-slave&nbsp;&nbsp;&nbsp;&nbsp;----eureka 服务发现，HA配置slave
     <br /> &nbsp;&nbsp;&nbsp;&nbsp;hsj-common-util&nbsp;&nbsp;&nbsp;&nbsp;----util工具包
     <br /> &nbsp;&nbsp;&nbsp;&nbsp;hsj-common-parent&nbsp;&nbsp;&nbsp;&nbsp;----聚合父类
 
  &nbsp;服务提供者<br />
  &nbsp;hsj-service<br />
     &nbsp;&nbsp;&nbsp;&nbsp;hsj-service-demo&nbsp;&nbsp;&nbsp;&nbsp;----服务提供者，包含调用mysql数据库操作，内网不暴露<br />
     &nbsp;&nbsp;&nbsp;&nbsp;hsj-service-parent&nbsp;&nbsp;&nbsp;&nbsp;----聚合父类<br />
  &nbsp;服务消费者<br />
  &nbsp;hsj-web<br />
     &nbsp;&nbsp;&nbsp;&nbsp;hsj-web-demo&nbsp;&nbsp;&nbsp;&nbsp;----消费者，不含数据库mysql操作，暴露给外网<br />
     &nbsp;&nbsp;&nbsp;&nbsp;hsj-web-parent&nbsp;&nbsp;&nbsp;&nbsp;----聚合父类<br />
