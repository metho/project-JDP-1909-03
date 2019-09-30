package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.ProductGroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductGroupTest {

    @Autowired
    private ProductGroupRepository productGroupRepository;
    @Autowired
    private ProductRepository productRepository;

    private static final String GROUP_NAME = "ProductGroup";
    private static final String PRODUCT_NAME = "Product";
    private static final String DESCRIPTION = "Description";
    private static final BigDecimal PRICE = BigDecimal.valueOf(100);

    @Test
    public void testSaveProductGroup() {
        //Given
        ProductGroup productGroup = new ProductGroup(GROUP_NAME);

        //When
        productGroupRepository.save(productGroup);

        //Then
        try {
            Optional<ProductGroup> readProductGroup = productGroupRepository.findById(productGroup.getId());
            assertThat(readProductGroup).isPresent();
        } finally {
            //CleanUp
            productGroupRepository.deleteById(productGroup.getId());
        }
    }

    @Test
    @Transactional
    public void testAddProduct() {
        //Given
        ProductGroup productGroup = new ProductGroup(GROUP_NAME);
        Product product = new Product(1L, PRODUCT_NAME, DESCRIPTION, PRICE, true);
        product.setProductGroup(productGroup);
        productGroup.addProduct(product);

        //When
        productGroupRepository.save(productGroup);
        productRepository.save(product);

        //Then
        try {
            List<Product> retrievedProducts = productGroupRepository.getOne(productGroup.getId()).getProducts();
            assertThat(productRepository.getOne(product.getId()).getProductGroup()).isEqualTo(productGroup);
            assertThat(retrievedProducts.get(0)).isEqualTo(product);
        } finally {
            //CleanUp
            productRepository.deleteById(product.getId());
            productGroupRepository.deleteById(productGroup.getId());
        }
    }
}
