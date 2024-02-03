package com.example.bookstore.repository;

import com.example.bookstore.domain.BookStore;
import com.example.bookstore.dto.AroundBookStoreDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;


public interface BookStoreRepository extends JpaRepository<BookStore, Long> {

    @Query(value = "SELECT * ," +
            " (6371*acos(cos(radians(:latitude))*cos(radians(b.latitude))*cos(radians(b.longitude) " +
            " - radians(:longitude))+sin(radians(:latitude))*sin(radians(b.latitude)))) " +
            "  AS distance " +
            "  FROM book_store b" +
            "  HAVING distance <= 10" +
            "  ORDER BY distance" +
            "  Limit 3", nativeQuery = true)
    List<BookStore> getAroundBookStore(@Param("latitude") BigDecimal latitude, @Param("longitude") BigDecimal longitude);

    @Query("select b from BookStore b where b.address like %:region%")
    List<BookStore> getRegionBookStore(@Param("region") String region);
}
