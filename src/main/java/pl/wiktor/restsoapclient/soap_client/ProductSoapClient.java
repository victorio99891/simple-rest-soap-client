package pl.wiktor.restsoapclient.soap_client;

import org.springframework.ws.client.WebServiceIOException;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.SoapFaultClientException;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import lombok.extern.slf4j.Slf4j;
import pl.wiktor.product.wsdl.GetSingleProductRequest;
import pl.wiktor.product.wsdl.GetSingleProductResponse;
import pl.wiktor.restsoapclient.exception.ServiceConnectionException;

@Slf4j
public class ProductSoapClient extends WebServiceGatewaySupport {

	public GetSingleProductResponse getProduct(int id) {
		GetSingleProductRequest request = new GetSingleProductRequest();
		request.setId(id);

		GetSingleProductResponse response = null;

		try {
			response = (GetSingleProductResponse) getWebServiceTemplate().marshalSendAndReceive(
					"http://localhost:8085/product-soap/ws", request,
					new SoapActionCallback("http://localhost:8085/product-soap/ws/GetSingleProductRequest"));
		} catch (SoapFaultClientException e) {
			log.error(e.toString());
		} catch (WebServiceIOException e) {
			log.error(e.toString());
			throw new ServiceConnectionException();
		}

		return response;
	}

}
