package com.example.Online.Food.Ordering.service.impl;

import com.example.Online.Food.Ordering.model.Category;
import com.example.Online.Food.Ordering.model.Restaurant;
import com.example.Online.Food.Ordering.repository.CategoryRepository;
import com.example.Online.Food.Ordering.service.CategoryService;
import com.example.Online.Food.Ordering.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(String name, Long userId) throws Exception {
        Restaurant restaurantById = restaurantService.getRestaurantByUserId(userId);

        Category category = new Category();

        category.setName(name);
        category.setRestaurant(restaurantById);

        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findCategoryByRestaurantId(Long id) throws Exception {
        Restaurant restaurant = restaurantService.getRestaurantByUserId(id);
        return categoryRepository.findByRestaurantId(restaurant.getId());
    }

    @Override
    public Category findCategoryById(Long id) throws Exception {
        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if(optionalCategory.isEmpty()){
            throw new Exception("Category not found");
        }
        return optionalCategory.get();
    }
}
