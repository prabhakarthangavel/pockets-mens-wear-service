package com.pockets.menswear.repo;

import com.pockets.menswear.entity.ProductInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductInfoRepo extends JpaRepository<ProductInfoEntity, Long> {

    @Modifying(clearAutomatically = true)
    @Query(value = "INSERT INTO product_info (name, category, actual_price, discounted_price, description) VALUES (:name, :category, :actualPrice, :discountedPrice, :description)", nativeQuery = true  )
    int createNewStock(@Param("name") String name, @Param("category") String category, @Param("actualPrice") int actualPrice,
                              @Param("discountedPrice") int discountedPrice, @Param("description") String description);

//    @Query("SELECT PR FROM ProductInfoEntity PR WHERE PR.category=:category")
    List<ProductInfoEntity> findByCategory(String category);

    @Modifying
    @Query("UPDATE ProductInfoEntity PE SET PE.name=:name, PE.category=:category, PE.actualPrice=:actualPrice, PE.discountedPrice=:discountedPrice, PE.description=:description WHERE PE.id=:id")
    void updateStock(@Param("id") long id, @Param("name") String name, @Param("category") String category, @Param("actualPrice") int actualPrice,
                     @Param("discountedPrice") int discountedPrice, @Param("description") String description);

    List<ProductInfoEntity> findByDiscountedPriceGreaterThan(int number);
}
