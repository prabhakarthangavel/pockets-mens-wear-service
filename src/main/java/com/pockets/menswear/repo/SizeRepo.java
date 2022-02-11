package com.pockets.menswear.repo;

import com.pockets.menswear.entity.SizeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepo extends JpaRepository<SizeEntity, Long> {

    @Modifying(clearAutomatically = true)
    @Query(value = "INSERT INTO size (id, small, medium, large, xlarge, xxlarge) VALUES (:id, :small, :medium, :large, :xlarge, :xxlarge)", nativeQuery = true)
    public int createSize(@Param("id") int id, @Param("small") int small, @Param("medium") int medium, @Param("large") int large, @Param("xlarge") int xlarge, @Param("xxlarge") int xxlarge);
}
