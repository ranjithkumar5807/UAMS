package gs;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
//@Configuration
public class GatewayConfig {
 
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("Asset-Registration-Hierarchy-Management", r -> r.path("/api/assets/**")
//                        .uri("http://localhost:8081"))
//                
//                .build();
//    }
}