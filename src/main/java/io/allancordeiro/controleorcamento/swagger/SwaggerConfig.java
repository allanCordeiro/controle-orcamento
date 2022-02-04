package io.allancordeiro.controleorcamento.swagger;


import com.google.common.base.Predicate;
import io.allancordeiro.controleorcamento.usuarios.entities.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


import java.util.Arrays;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket ControleOrcamentoAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis((Predicate<RequestHandler>) RequestHandlerSelectors.basePackage("io.allancordeiro"))
                .paths((Predicate<String>) PathSelectors.ant("/**"))
                .build()
                .ignoredParameterTypes(Usuario.class)
                .globalOperationParameters(Arrays.asList(
                        new ParameterBuilder()
                                .name("Authorization")
                                .description("token. Type Bearer + token generated on jwt-authentication-filter endpoint")
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .required(false)
                                .build())
                );
    }
}
