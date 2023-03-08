package com.codearti;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;

import com.codearti.model.dto.ProductResponseDto;
import com.codearti.model.entity.CategoryEntity;
import com.codearti.model.entity.DeletedProduct;
import com.codearti.model.entity.ProductEntity;
import com.codearti.model.mapper.ProductMapper;
import com.codearti.repository.ProductRepository;
import com.codearti.service.ProductService;

@SpringBootTest
public class ProductServiceTest {

	@MockBean
	private ServletWebServerApplicationContext webServerApplicationContext;
	
	@MockBean
	private ProductRepository productRepository;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductMapper mapper;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(productRepository);
		productService = new ProductService(productRepository, mapper);
		
		ProductEntity productEntity = ProductEntity.builder()
				.id(1L)
				.name("Teclado2")
				.stock(Double.valueOf(10))
				.price(BigDecimal.valueOf(300))
				.category(CategoryEntity.builder().id(1L).build())
				.deleted(DeletedProduct.CREATED)
				.build();
		
		Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(productEntity));
	}
	
	@Test
	public void whenValidGetId_ThenReturnProduct() {
		ProductResponseDto productResponse = productService.findById(1L, 10);
		assertEquals("Teclado2", productResponse.getName());
	}
}
