package pl.com.agora.api.payment.client;

import java.util.concurrent.Future;

import pl.com.agora.api.client.rest.bind.annotation.RestRequestMapping;
import pl.com.agora.api.client.rest.bind.annotation.RestRequestParam;

public interface PaymentClient {

	@RestRequestMapping("/payfor")
	public Future<PaymentResult> payFor(@RestRequestParam("id") String id);
}
