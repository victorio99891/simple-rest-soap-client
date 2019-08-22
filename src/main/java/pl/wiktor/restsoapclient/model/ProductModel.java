package pl.wiktor.restsoapclient.model;

import pl.wiktor.product.wsdl.ProductSOAP;

public class ProductModel extends ProductSOAP {

	public ProductModel() {
		super();
	}

	public ProductModel(int id, String name, double price) {
		super(id, name, price);
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
