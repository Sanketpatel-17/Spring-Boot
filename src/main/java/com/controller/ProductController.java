package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ProductBean;
import com.dao.ProductDao;

@RestController
public class ProductController {
	
	@Autowired
	ProductDao productDao;
	
	@PostMapping("/product")
	public ProductBean addProduct(ProductBean productBean)
	{
		productDao.addProduct(productBean);
		return productBean;
	}
	
	@GetMapping("/product/{id}")
	public ProductBean returnProduct(@PathVariable("id") int id)
	{
		ProductBean productBean=productDao.getDataByProductId(id);
		return productBean;
	}
	
	@DeleteMapping("/product/{id}")
	public String deleteProduct(@PathVariable("id") int id)
	{
		boolean flag=productDao.deleteProduct(id);
		
		if(flag)
		{
			return "Product Removed Successfully!!!";
		}
		else
		{
			return "Something went wrong";
		}
	}
	
	@GetMapping("/products")
	public List<ProductBean> gettAllProducts()
	{
		List<ProductBean> products=productDao.getAllProducts();
		return products;
		
	}
	
	@PutMapping("/product")
	public ProductBean updateProduct(ProductBean productBean) {
		productDao.updateProduct(productBean);
		return productBean;
	}
}
