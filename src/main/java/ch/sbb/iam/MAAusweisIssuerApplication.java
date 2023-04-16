package ch.sbb.iam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.filter.ForwardedHeaderFilter;

@SpringBootApplication
@EnableCaching
public class MAAusweisIssuerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MAAusweisIssuerApplication.class, args);
	}

	/**
	 * If the application endpoint is forwarded by ngrok to a domain using https, the redirect uri is still transmitted as http.
	 * This filter bean remediates this behaviour: cf. https://stackoverflow.com/questions/51404552/spring-boot-oauth-always-redirecting-to-http-ibm-cloud-cf-spring-boot-2/51500554#51500554
	 */
	@Bean
	FilterRegistrationBean<ForwardedHeaderFilter> forwardedHeaderFilter() {

		final FilterRegistrationBean<ForwardedHeaderFilter> filterRegistrationBean = new FilterRegistrationBean<ForwardedHeaderFilter>();

		filterRegistrationBean.setFilter(new ForwardedHeaderFilter());
		filterRegistrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);

		return filterRegistrationBean;
	}
}
