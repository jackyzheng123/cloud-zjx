package com.zjx;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableEurekaClient
public class ProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderApplication.class, args);
	}
	
	private static final Logger LOG = LoggerFactory.getLogger(ProviderApplication.class.getName());


	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}

	@RequestMapping("/miya")
	public String home(){
		LOG.info("calling trace cloud-zjx-provider-zipkin");
		return restTemplate.getForObject("http://localhost:8673/info", String.class);
	}
	@RequestMapping("/info")
	public String info(){
		LOG.info("calling trace cloud-zjx-provider-zipkin");
		return "i'm cloud-zjx-provider-zipkin";
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	
}
