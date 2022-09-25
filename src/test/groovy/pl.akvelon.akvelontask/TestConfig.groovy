package pl.akvelon.akvelontask

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EntityScan
@Configuration
@EnableJpaRepositories
@EnableAutoConfiguration
@ComponentScan(
        basePackages = "pl.akvelon.akvelontask"
)
class TestConfig {
}
