//package com.retell.wordladder.prometheus;
//
//import io.prometheus.client.exporter.MetricsServlet;
//import io.prometheus.client.hotspot.DefaultExports;
//import io.prometheus.client.spring.boot.SpringBootMetricsCollector;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//class MonitoringConfig {
//    @Bean
//    SpringBootMetricsCollector springBootMetricsCollector(Collection<PublicMetrics> publicMetrics) {
//
//        SpringBootMetricsCollector springBootMetricsCollector = new SpringBootMetricsCollector(publicMetrics);
//        springBootMetricsCollector.register();
//        return springBootMetricsCollector;
//    }
//
//    @Bean
//    ServletRegistrationBean servletRegistrationBean() {
//        DefaultExports.initialize();
//        return new ServletRegistrationBean(new MetricsServlet(), "/prometheus");
//    }
//}