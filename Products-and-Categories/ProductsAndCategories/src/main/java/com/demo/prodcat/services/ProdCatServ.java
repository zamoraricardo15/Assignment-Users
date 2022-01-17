package com.demo.prodcat.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.prodcat.models.Category;
import com.demo.prodcat.models.CategoryProduct;
import com.demo.prodcat.models.Product;
import com.demo.prodcat.repositories.CategoryProductRepo;
import com.demo.prodcat.repositories.CategoryRepo;
import com.demo.prodcat.repositories.ProductRepo;

@Service
public class ProdCatServ {
	private final ProductRepo productRepo;
	private final CategoryRepo categoryRepo;
	private final CategoryProductRepo categoryProductRepo;
	
	public ProdCatServ(ProductRepo productRepo, CategoryRepo categoryRepo, CategoryProductRepo categoryProductRepo) {
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
		this.categoryProductRepo = categoryProductRepo;
	}
	
	//Product
	public void addProd(Product product) {
		productRepo.save(product);
	}
	
	public void setCat(Category category) {
		
	}
	
	public void addCatToProduct(CategoryProduct categoryProduct) {
		categoryProductRepo.save(categoryProduct);
	}
	
	public Product singleProd(Long id) {
		Optional<Product> product = productRepo.findById(id);
		if(product.isPresent()) {
			return product.get();
		}
		else {
			return null;
		}
	}
	
	public Iterable<Product> availableProductsForCategory(Category category) {
		return productRepo.findByCategoriesNotContains(category);
	}
	
	//Category
	public void addCat(Category category) {
		categoryRepo.save(category);
	}
	
	public List<Category> getCatAll() {
		return categoryRepo.findAll();
	}
	
    public List<Category> availableCategoriesForProduct(Product product) {
        return categoryRepo.findByProductsNotContains(product);  
    }
    
	public void addProdToCategory(CategoryProduct categoryProduct) {
		categoryProductRepo.save(categoryProduct);
	}
    
	public Category singleCat(Long id) {
		Optional<Category> category = categoryRepo.findById(id);
		if(category.isPresent()) {
			return category.get();
		}
		else {
			return null;
		}
	}
}