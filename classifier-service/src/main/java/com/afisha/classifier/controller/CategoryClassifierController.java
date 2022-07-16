package com.afisha.classifier.controller;

import com.afisha.classifier.config.response.ResponseHandler;
import com.afisha.classifier.dao.entity.Category;
import com.afisha.classifier.dto.BaseEssence;
import com.afisha.classifier.dto.classifiers.CreationCategory;
import com.afisha.classifier.service.CategoryService;
import com.afisha.classifier.service.pagination.ResponsePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/classifier/concert/category")
public class CategoryClassifierController {

    @Autowired
    CategoryService service;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    public Category save(@RequestBody CreationCategory category) {
        try {
            return service.save(new Category(BaseEssence.getInstance(), category.getTitle()));
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    @GetMapping
    public ResponseEntity<Object> findAll(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "20") Integer size) {
        try {
            Page<Category> all = service.findAll(PageRequest.of(page, size));
            ResponsePage responsePage = new ResponsePage(page, size, all.getTotalPages(), (int) all.getTotalElements(), true, all.getNumberOfElements(), true, all.stream().toList());
            return ResponseHandler.generateResponse(responsePage);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
