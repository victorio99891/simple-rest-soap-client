package pl.wiktor.restsoapclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pl.wiktor.product.wsdl.GetSingleProductResponse;
import pl.wiktor.restsoapclient.dtos.ProductDTO;
import pl.wiktor.restsoapclient.exception.ProductNotFoundException;
import pl.wiktor.restsoapclient.mapper.ProductMapper;
import pl.wiktor.restsoapclient.soap_client.ProductSoapClient;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

	private ProductSoapClient clientSOAP;

	@Autowired
	public ProductController(ProductSoapClient clientSOAP) {
		this.clientSOAP = clientSOAP;
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<ProductDTO> getProductById(@PathVariable(name = "id") String id) {

		GetSingleProductResponse response;

		response = clientSOAP.getProduct(Integer.valueOf(id));

		if (response == null) {
			throw new ProductNotFoundException();
		}

		log.debug(String.format("Obtained product from database: %s", response.getProduct().toString()));
		return ResponseEntity.ok(ProductMapper.fromModelToDto(ProductMapper.fromSoapToModel(response.getProduct())));
	}

	@GetMapping("/test")
	@ResponseBody
	public ResponseEntity<String> getTestMessage() {
		return ResponseEntity.ok("Test message");
	}

}
