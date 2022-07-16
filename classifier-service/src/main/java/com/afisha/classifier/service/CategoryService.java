package com.afisha.classifier.service;

import com.afisha.classifier.dao.api.CategoryClassifierRepository;
import com.afisha.classifier.dao.entity.Category;
import com.afisha.classifier.dto.BaseEssence;
import com.afisha.classifier.service.api.IClassifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class CategoryService implements IClassifierService<Category>{

    @Autowired
    CategoryClassifierRepository repository;

    public Category save(Category classifier) {
        return repository.save(classifier);
    }

    public Category findOne(UUID uuid) {
        Optional<Category> optional = repository.findById(uuid);
        if(optional.isEmpty()) {
            throw new IllegalArgumentException();
        } else return optional.get();
    }

    public Page<Category> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void delete(Category classifier) {
        repository.delete(classifier);
    }

    public Category update(Category classifier, Integer dtUpdate, UUID uuid) {
        Category category = findOne(uuid);
        category.setTitle(classifier.getTitle());
        category.setDtUpdate(BaseEssence.generateTime());
        return null;
    }
}
