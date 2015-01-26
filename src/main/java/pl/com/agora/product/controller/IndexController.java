package pl.com.agora.product.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import pl.com.agora.api.payment.client.PaymentClient;
import pl.com.agora.api.payment.client.PaymentResult;
import pl.com.agora.product.model.Product;

@RestController
public class IndexController {

	@RequestMapping("/")
	@ResponseBody
	public ModelAndView homePath() {
		List<Product> products = new ArrayList<Product>() {

			private static final long serialVersionUID = 1L;

			{
				add(new Product(1L, "ferrari", "10PLN"));
				add(new Product(2L, "porshe", "15PLN"));
			}
		};
		ModelAndView modelAndView = new ModelAndView("index", "model", products);
		modelAndView.addObject("products", products);
		modelAndView.addObject("payurl", "/payfor");
		return modelAndView;
	}

	@Autowired
	private PaymentClient paymentClient;
	
	@RequestMapping("/payfor")
	@ResponseBody
	public String payfor(@RequestParam String id) throws InterruptedException, ExecutionException {
		Future<PaymentResult> paymentResultFuture = paymentClient.payFor(id);
		final PaymentResult paymentResult = paymentResultFuture.get();
		return id;
	}

}
