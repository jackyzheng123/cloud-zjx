package com.zjx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * windows修改 C:\Windows\System32\drivers\etc\hosts
 * 127.0.0.1 peer1
 * 127.0.0.1 peer2
 * 
 * 打包：mvn install
 * 
 * 启动：
 * 	java -jar cloud-zjx-eureka-cluster-0.0.1-SNAPSHOT.jar - -spring.profiles.active=peer1
 * 	java -jar cloud-zjx-eureka-cluster-0.0.1-SNAPSHOT.jar - -spring.profiles.active=peer2
 * 	java -jar cloud-zjx-provider-hi-0.0.1-SNAPSHOT.jar
 * 
 * @author Think
 * @date 2018年11月17日
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerClusterApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerClusterApplication.class, args);
	}
}
