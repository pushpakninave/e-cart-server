package com.pushpak.e_cart.service.product;

import java.util.List;

import com.pushpak.e_cart.model.Product;
import com.pushpak.e_cart.request.AddProductRequest;
import com.pushpak.e_cart.request.ProductUpdateRequest;

public interface IProductService {
    Product addProduct(AddProductRequest product);

    Product getProductById(Long id);

    void deleteProductById(Long id);

    Product updateProduct(ProductUpdateRequest product, Long productId);

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(String category);

    List<Product> getProductsByBrand(String Brand);

    List<Product> getProductsByCategoryAndBrand(String category, String Brand);

    List<Product> getProductsByName(String name);

    List<Product> getProductsByBrandAndName(String brand, String name);

    Long countProductsByBrandAndName(String brand, String name);
}
