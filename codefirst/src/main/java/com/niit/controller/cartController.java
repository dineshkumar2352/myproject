package com.niit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.ProductDao;
import com.niit.model.Product;
import com.niit.model.ShippingAddress;
import com.niit.model.cart;
import com.niit.model.cartProduct;

@Controller
@SessionAttributes({ "userObj", "cartObj" })
public class cartController {
	@Autowired(required=true)
	ProductDao product_Service;

	@Autowired

	HttpSession session;

	@RequestMapping(value = "/addToCart", method = RequestMethod.GET)
	public String addtoCart(@RequestParam("productid") int idParam1, Model model) {
		System.out.println("Reached");
		cart _cart = (cart) session.getAttribute("cartObj");
		if (_cart == null) {
			_cart = new cart();
		}
		int id = Integer.valueOf(idParam1);
		int qty = 1;
		Product p = product_Service.getProduct(id);
		System.out.println(p.getProductName());

		cartProduct item = new cartProduct();
		item.setProduct(p);
		item.setQty(qty);

		System.out.println(p.getPrice());
		long totalPrice = (long) (p.getPrice() * qty);
		item.setTotalCost(totalPrice);

		List<cartProduct> cartList = new ArrayList<cartProduct>();
		if (_cart.getCartProduct() == null) {
			cartList.add(item);
			_cart.setCartProduct(cartList);
		} else {
			cartList = _cart.getCartProduct();
			int flag = 0;

			for (int i = 0; i < cartList.size(); i++) {
				if (cartList.get(i).getProduct().getProductID() == p.getProductID()) {
					cartList.get(i).setQty(cartList.get(i).getQty() + 1);
					cartList.get(i).setTotalCost(cartList.get(i).getTotalCost() + p.getPrice());
					flag = 1;
					break;
				}

			}
			if (flag == 0) {
				cartList.add(item);
				_cart.setCartProduct(cartList);
			}

		}
		_cart.calcGrandTotal();
		_cart.setProCount(_cart.getProCount() + 1);
		model.addAttribute("cartObj", _cart);

		return "redirect:" + "cart?productid=" + idParam1;
	}

	@RequestMapping("/cart")
	public ModelAndView viewCart(Model model) {
		cart _cart = (cart) session.getAttribute("cartObj");

		if (_cart == null || _cart.getProCount() == 0) {
			model.addAttribute("emptycart", "emptycart");
		} else {
			model.addAttribute("emptycart", "notempty");
			model.addAttribute("grandtotal", _cart.getGrandTotal());
			System.out.println(_cart.getGrandTotal());
			List<cartProduct> cartProducts = _cart.getCartProduct();
			System.out.println("Product List");
			model.addAttribute("cartProducts", cartProducts);
		}
		return new ModelAndView("cart");
	}
	
	@RequestMapping("/confirm")
	public String Confirm(ShippingAddress shipAddr){
		product_Service.saveAddr(shipAddr);
		return ("home");
	}
}
