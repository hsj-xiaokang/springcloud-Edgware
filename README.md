# springcloud-Edgware
springcloud-Edgware模块化版本的demo，
<br />目前集成mybatis-plus，
<br />使用了springcloud-config本地配置文件方式，
<br />springcloud-eureka的HA高可用，
<br />springcloud-restTemplate+ribbon服务调用，
<br />springcloud-feignClient服务调用


项目结构<br />
  &nbsp;公共代码<br />
  &nbsp;hsj-common<br />
     &nbsp;&nbsp;&nbsp;&nbsp;hsj-common-config-server<br />
     &nbsp;&nbsp;&nbsp;&nbsp;hsj-common-entity<br />
     &nbsp;&nbsp;&nbsp;&nbsp;hsj-common-entity-generator<br />
     &nbsp;&nbsp;&nbsp;&nbsp;hsj-common-eureka-server<br />
     &nbsp;&nbsp;&nbsp;&nbsp;hsj-common-util<br />
     &nbsp;&nbsp;&nbsp;&nbsp;hsj-common-parent<br />
 
  &nbsp;服务提供者<br />
  &nbsp;hsj-service<br />
     &nbsp;&nbsp;&nbsp;&nbsp;hsj-service-demo<br />
     &nbsp;&nbsp;&nbsp;&nbsp;hsj-service-parent<br />
  &nbsp;服务消费者<br />
  &nbsp;hsj-web<br />
     &nbsp;&nbsp;&nbsp;&nbsp;hsj-web-demo<br />
     &nbsp;&nbsp;&nbsp;&nbsp;hsj-web-parent<br />
