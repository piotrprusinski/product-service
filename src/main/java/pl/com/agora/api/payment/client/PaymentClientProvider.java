package pl.com.agora.api.payment.client;

import pl.com.agora.api.client.rest.RestfulClientProxyFactory;
import pl.com.agora.api.client.rest.RestfulClientProxyFactory.ProxyConfiguration;

public class PaymentClientProvider {

	private Integer defaultConnectTimeout;
	private Long defaultRequestTimeout;
	
	public void setDefaultConnectTimeout(Integer defaultConnectTimeout) {
		this.defaultConnectTimeout = defaultConnectTimeout;
	}
	
	public void setDefaultRequestTimeout(Long defaultRequestTimeout) {
		this.defaultRequestTimeout = defaultRequestTimeout;
	}

	public PaymentClient create(String host, int port) throws Exception {
		ProxyConfiguration proxyConfiguration = new ProxyConfiguration();
		RestfulClientProxyFactory proxyFactory = new RestfulClientProxyFactory();
		proxyFactory.setHost(host);
		proxyFactory.setPort(port);
		proxyFactory.setDefaultConnectTimeout(defaultConnectTimeout);
		proxyFactory.setDefaultRequestTimeout(defaultRequestTimeout);
		PaymentClient client = proxyFactory.createProxy(PaymentClient.class, proxyConfiguration);
		return client ;
	}
}
