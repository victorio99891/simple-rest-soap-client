package pl.wiktor.restsoapclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import pl.wiktor.restsoapclient.soap_client.ProductSoapClient;

@Configuration
public class ProductConfiguration {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("pl.wiktor.product.wsdl");
		return marshaller;
	}

	@Bean
	public ProductSoapClient productClient(Jaxb2Marshaller marshaller) {
		ProductSoapClient client = new ProductSoapClient();
		client.setDefaultUri("http://localhost:8085/product-soap/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}

}
