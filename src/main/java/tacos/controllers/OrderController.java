package tacos.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tacos.data.Order;

@Controller
@RequestMapping("/orders")
public class OrderController 
{
	private static final Logger log = LoggerFactory.getLogger(OrderController.class);
	
	@GetMapping("/current")
	public String orderForm(Model model) 
	{
		model.addAttribute("order", new Order());
		return "orderForm";
	}
	
	@PostMapping
	public String processOrder (@Valid Order order, Errors errors) {
		if (errors.hasErrors()) {
			log.info("Errors :"+errors.toString());
			return "orderForm";
		}
		log.info("Order submited: "+order);
		return "redirect:/";
	}
}
