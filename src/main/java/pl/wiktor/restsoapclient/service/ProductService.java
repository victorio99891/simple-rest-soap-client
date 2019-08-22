package pl.wiktor.restsoapclient.service;

import org.springframework.stereotype.Service;

import pl.wiktor.restsoapclient.model.ProductModel;

@Service
public class ProductService {

	public ProductModel getProductById(int id) {

		return new ProductModel();

	}

}
