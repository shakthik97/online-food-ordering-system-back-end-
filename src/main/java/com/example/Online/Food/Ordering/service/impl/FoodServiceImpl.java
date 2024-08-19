package com.example.Online.Food.Ordering.service.impl;

import com.example.Online.Food.Ordering.model.Category;
import com.example.Online.Food.Ordering.model.Food;
import com.example.Online.Food.Ordering.model.Restaurant;
import com.example.Online.Food.Ordering.repository.FoodRepository;
import com.example.Online.Food.Ordering.request.CreateFoodRequest;
import com.example.Online.Food.Ordering.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant) {

        Food food = new Food();
        food.setFoodCategory(category);
        food.setRestaurant(restaurant);
        food.setDescription(req.getDescription());
        food.setImages(req.getImages());
        food.setName(req.getName());
        food.setPrice(req.getPrice());
        food.setIngredients(req.getIngredients());
        food.setSeasonal(req.isSeasonal());
        food.setVegetarian(req.isVegetarian());

        Food savedFood = foodRepository.save(food);
        restaurant.getFoods().add(savedFood);
        return null;
    }

    @Override
    public void deleteFood(Long foodId) throws Exception {

    }

    @Override
    public List<Food> getRestaurantFood(Long restaurantId, boolean isVegetarian, boolean isNonVeg, boolean isSeasonal, String foodCategory) {
        return null;
    }

    @Override
    public List<Food> searchFood(String keyword) {
        return null;
    }

    @Override
    public Food findFoodById(Long foodId) throws Exception {
        return null;
    }

    @Override
    public Food updateAvailabilityStatus(Long foodId) throws Exception {
        return null;
    }
}
