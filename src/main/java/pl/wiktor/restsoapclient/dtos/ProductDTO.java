package pl.wiktor.restsoapclient.dtos;

import pl.wiktor.restsoapclient.model.ProductModel;

public class ProductDTO extends ProductModel {

	public ProductDTO() {
		super();
	}

	public ProductDTO(int id, String name, double price) {
		super(id, name, price);
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
