package dhm.api_web.doc;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gerenciamento de Usuários")
                        .description("Documentação da API para gerenciamento de usuários")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Danilo")
                                .email("danilo@email.com")
                                .url("https://meusite.com"))
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Mais detalhes")
                        .url("https://github.com/seu-repo"));
    }
}
