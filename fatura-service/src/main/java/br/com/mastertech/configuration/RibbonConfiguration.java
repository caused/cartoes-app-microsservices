package br.com.mastertech.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration
public class RibbonConfiguration {    
	@Bean
	public IRule iRule() {
		return new RoundRobinRule();
	}
}