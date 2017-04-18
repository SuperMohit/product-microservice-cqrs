package com.sapient.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sapient.product.domain.ProductQueryObject;


@Repository
public interface ProductQueryObjectRepository extends JpaRepository<ProductQueryObject, String> {

}
