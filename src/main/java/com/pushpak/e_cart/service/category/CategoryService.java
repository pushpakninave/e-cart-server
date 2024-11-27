package com.pushpak.e_cart.service.category;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pushpak.e_cart.exceptions.AlreadyExistsException;
import com.pushpak.e_cart.exceptions.ResourceNotFoundException;
import com.pushpak.e_cart.model.Category;
import com.pushpak.e_cart.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found!"));
    }

    @Override
    public Category addCategory(Category category) {
        return Optional.of(category).filter(cat -> !categoryRepository.existsByName(cat.getName()))
                .map(categoryRepository::save)
                .orElseThrow(
                        () -> new AlreadyExistsException(category.getName() + "Already Exists"));
    }

    @Override
    public Category updateCategory(Category category, Long id) {
        return Optional.ofNullable(getCategoryById(id))
                .map(
                        existingCategory -> {
                            existingCategory.setName(category.getName());
                            return categoryRepository.save(existingCategory);
                        })
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.findById(id).ifPresentOrElse(categoryRepository::delete, () -> {
            throw new ResourceNotFoundException("Category not found!");
        });
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public List<Category> getAllCategories() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllCategories'");
    }

    @Override
    public void deleteCategoryByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCategoryByName'");
    }

}
