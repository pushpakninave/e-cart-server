package com.pushpak.e_cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pushpak.e_cart.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);

    boolean existsByName(String name);
}