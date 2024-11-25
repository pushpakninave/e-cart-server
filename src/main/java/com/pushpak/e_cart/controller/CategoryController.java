package com.pushpak.e_cart.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pushpak.e_cart.exceptions.AlreadyExistsException;
import com.pushpak.e_cart.exceptions.ResourceNotFoundException;
import com.pushpak.e_cart.model.Category;
import com.pushpak.e_cart.response.ApiResponse;
import com.pushpak.e_cart.service.category.ICategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/categories")
public class CategoryController {
    private final ICategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllCategories() {
        try {
            List<com.pushpak.e_cart.model.Category> categories = categoryService.getAllCategories();
            if (!categories.isEmpty()) {
                return ResponseEntity.ok(new ApiResponse("Success!", categories));
            }
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ApiResponse("Categories not found", null));
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiResponse("Server Error", HttpStatus.INTERNAL_SERVER_ERROR));
    }

    @PostMapping("/category/add")
    public ResponseEntity<ApiResponse> addCategory(@RequestBody Category name) {
        try {
            Category thisCategory = categoryService.addCategory(name);
            return ResponseEntity.ok(new ApiResponse("Success", thisCategory));
        } catch (AlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/category/{id}/get")
    public ResponseEntity<ApiResponse> getCategoryById(@PathVariable Long id) {
        try {
            Category thisCategory = categoryService.getCategoryById(id);
            return ResponseEntity.ok().body(new ApiResponse("Found", thisCategory));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @GetMapping("/category/{name}/get")
    public ResponseEntity<ApiResponse> getCategoryByName(@RequestParam String name) {
        try {
            Category thisCategory = categoryService.getCategoryByName(name);
            return ResponseEntity.ok().body(new ApiResponse("Found", thisCategory));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/category/{id}/delete")
    public ResponseEntity<ApiResponse> deleteCategoryById(@RequestParam Long id) {
        try {
            categoryService.deleteCategoryById(id);
            ;
            return ResponseEntity.ok().body(new ApiResponse("Found", null));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/category/{name}/delete")
    public ResponseEntity<ApiResponse> deleteCategoryByName(@RequestParam String name) {
        try {
            categoryService.deleteCategoryByName(name);
            return ResponseEntity.ok().body(new ApiResponse("Found", null));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PutMapping("/category/{id}/update")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        try {
            Category thisCategory = categoryService.updateCategory(category, id);
            return ResponseEntity.ok(new ApiResponse("update successfull", thisCategory));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

}
