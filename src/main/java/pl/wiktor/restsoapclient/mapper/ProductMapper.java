package pl.wiktor.restsoapclient.mapper;

import pl.wiktor.product.wsdl.ProductSOAP;
import pl.wiktor.restsoapclient.dtos.ProductDTO;
import pl.wiktor.restsoapclient.model.ProductModel;

public class ProductMapper {

	public static ProductModel fromSoapToModel(ProductSOAP soap) {
		ProductModel model = new ProductDTO(soap.getId(), soap.getName(), soap.getPrice());
		return model;
	}

	public static ProductDTO fromModelToDto(ProductModel model) {
		ProductDTO dto = new ProductDTO(model.getId(), model.getName(), model.getPrice());
		return dto;
	}

}
