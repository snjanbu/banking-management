package in.sanjayanbu.banking.management.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenAPIConfiguration {
	
	@Value("${swagger.server-url}")
    private String serverUrl;

	@Bean
	public OpenAPI defineOpenAPI() {

		Server server = new Server();
		server.setUrl(serverUrl);
		server.setDescription("Banking Management");
		Contact myContact = new Contact();
		myContact.setName("Sanjay Anbu");
		myContact.setEmail("snjanbu@gmail.com");
		myContact.setUrl("https://sanjayanbu.in");

		Info information = new Info()
			.title("Banking Management System API")
			.version("1.0")
			.description("This API exposes endpoints to manage bank.")
			.contact(myContact);
		return new OpenAPI().info(information).servers(List.of(server));
	}
}
