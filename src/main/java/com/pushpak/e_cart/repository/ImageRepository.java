package com.pushpak.e_cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pushpak.e_cart.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long>{

    List<Image> findByProductId(Long id);

}
