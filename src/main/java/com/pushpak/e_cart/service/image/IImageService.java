package com.pushpak.e_cart.service.image;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.pushpak.e_cart.dto.ImageDto;
import com.pushpak.e_cart.model.Image;

public interface IImageService {

    Image getImageById(Long id);

    void deleteImageById(Long id);

    List<ImageDto> saveImages(List<MultipartFile> file, Long productId);

    void updateImage(MultipartFile file, Long imageId);
}
