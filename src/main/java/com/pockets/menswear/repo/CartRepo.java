package com.pockets.menswear.repo;

import com.pockets.menswear.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<CartEntity, Long> {
    List<CartEntity> findAllByUsername(String username);

    int deleteByProductid(long productId);
}
