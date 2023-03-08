package com.codearti;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.codearti.model.entity.ProductEntity;
import com.codearti.model.entity.ProductStatus;
import com.codearti.repository.ProductRepository;

@DataJpaTest
public class ProductRepositoryTest {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	void whenGetAll_ThenReturnAllProduct() {
		List<ProductEntity> list = productRepository.findAll(ProductStatus.OLD);
		assertEquals(0, list.size());
	}
	
	@Test
	void whenValidSave_ThenReturnProduct() {
		//ProductEntity productEntity = ProductEntity.class.
	
	}
	
	/*
	 * @Test void whenValidGetId_ThenReturnProduct() { Optional<ProductEntity>
	 * productEntity = productRepository.findById(1L);
	 * assertTrue(productEntity.isPresent()); assertEquals("Laptop",
	 * productEntity.orElseThrow().getName()); }
	 * 
	 * @Test void whenInValidGetId_ThenNotFound() { Optional<ProductEntity>
	 * productEntity = productRepository.findById(55L);
	 * assertThrows(NoSuchElementException.class, productEntity::orElseThrow);
	 * assertTrue(!productEntity.isPresent()); }
	 * 
	 * @Test void whenValidSave_ThenReturnProduct() { ProductEntity productEntity =
	 * ProductEntity.builder() .name("Teclado") .stock(Double.valueOf(10))
	 * .price(BigDecimal.valueOf(300))
	 * .category(CategoryEntity.builder().id(1L).build()) .build();
	 * productRepository.save(productEntity);
	 * 
	 * List<ProductEntity> products =
	 * productRepository.findByCategoryAndDeleted(productEntity.getCategory(),
	 * DeletedProduct.CREATED); assertEquals(4, products.size()); }
	 */

}
