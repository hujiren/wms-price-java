package com.apl.wms.price;

import com.apl.lib.config.MyBatisPlusConfig;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author hjr start
 * @date 2020/6/20 - 12:12
 */
@SpringBootApplication(scanBasePackages = {"com.apl.lib", "com.apl.wms.price"}, exclude = {DataSourceAutoConfiguration.class, MyBatisPlusConfig.class})
@MapperScan(basePackages = {"com.apl.wms.price.mapper"})
@EnableSwagger2
@EnableDiscoveryClient
public class WmsPriceManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(WmsPriceManageApplication.class, args);
    }

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType("mysql");
        return paginationInterceptor;
    }
}
