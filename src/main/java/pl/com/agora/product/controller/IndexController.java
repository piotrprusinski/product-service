package pl.com.agora.product.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping("/payfor")
	@ResponseBody
	public String payfor(@RequestParam String id) {
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> vars = Collections.singletonMap("id", id);
		String result = restTemplate.getForObject(
				"http://localhost:8081/payfor?id={id}", String.class, vars);
		return id;
	}

}
