package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.CartRepository;
import com.kodilla.ecommercee.repository.ProductGroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductGroupRepository productGroupRepository;

    @Test
    public void saveProduct() {
        //Given
        Product product = new Product("shoes", "black and winter", new BigDecimal(100), true);
        //When
        productRepository.save(product);
        //Then
        Long productId = product.getId();
        Optional<Product> saveProduct = productRepository.findById(productId);
        Assert.assertTrue(saveProduct.isPresent());
        //CleanUp
        productRepository.deleteById(productId);
    }

    @Test
    @Transactional
    public void saveProductManyToManyWithCart() {
        //Given
        Product product1 = new Product("shoes", "black and winter", new BigDecimal(100), true);
        Product product2 = new Product("trousers", "jeans", new BigDecimal(80), true);
        Product product3 = new Product("t-shirt", "cotton", new BigDecimal(50), true);

        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        Cart cart3 = new Cart();

        product1.getCarts().add(cart1);
        product1.getCarts().add(cart2);
        product2.getCarts().add(cart3);
        product2.getCarts().add(cart2);
        product3.getCarts().add(cart1);

        cart1.getProducts().add(product1);
        cart1.getProducts().add(product3);
        cart2.getProducts().add(product2);
        cart2.getProducts().add(product1);
        cart3.getProducts().add(product2);
        //When
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        long product1Id = product1.getId();
        long product2Id = product2.getId();
        long product3Id = product3.getId();

        Optional<Product> saveProduct1 = productRepository.findById(product1Id);
        Optional<Product> saveProduct2 = productRepository.findById(product2Id);
        Optional<Product> saveProduct3 = productRepository.findById(product3Id);
        //Then
        Assert.assertNotEquals(0, saveProduct1);
        Assert.assertNotEquals(0, saveProduct2);
        Assert.assertNotEquals(0, saveProduct3);
        //CleanUp
        productRepository.deleteById(product1Id);
        productRepository.deleteById(product2Id);
        productRepository.deleteById(product3Id);
    }

    @Test
    @Transactional
    public void saveProductManyToManyWithUser() {
        //Given
        Product product1 = new Product("shoes", "black and winter", new BigDecimal(100), true);
        Product product2 = new Product("trousers", "jeans", new BigDecimal(80), true);
        Product product3 = new Product("t-shirt", "cotton", new BigDecimal(50), true);

        User johnSmith = new User("John", "Smith");
        User stephaniClarckson = new User("Stephani", "Clarckson");
        User lindaKovalski = new User("Linda", "Kovalski");

        UserOrder userOrder1 = new UserOrder("1", johnSmith);
        UserOrder userOrder2 = new UserOrder("2", stephaniClarckson);
        UserOrder userOrder3 = new UserOrder("3", lindaKovalski);

        product1.getUserOrders().add(userOrder1);
        product1.getUserOrders().add(userOrder2);
        product2.getUserOrders().add(userOrder3);
        product3.getUserOrders().add(userOrder2);

        userOrder1.getProducts().add(product1);
        userOrder2.getProducts().add(product1);
        userOrder2.getProducts().add(product3);
        userOrder3.getProducts().add(product2);
        //When
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        long product1Id = product1.getId();
        long product2Id = product2.getId();
        long product3Id = product3.getId();

        Optional<Product> saveProduct1 = productRepository.findById(product1Id);
        Optional<Product> saveProduct2 = productRepository.findById(product2Id);
        Optional<Product> saveProduct3 = productRepository.findById(product3Id);
        //Then
        Assert.assertNotEquals(0, saveProduct1);
        Assert.assertNotEquals(0, saveProduct2);
        Assert.assertNotEquals(0, saveProduct3);
        //CleanUP
        productRepository.deleteById(product1Id);
        productRepository.deleteById(product2Id);
        productRepository.deleteById(product3Id);
    }

    @Test
    @Transactional
    public void saveProductManyToOneWithProductGrupe() {
        Product product1 = new Product("Jacket", "black and winter", new BigDecimal(100), true);
        Product product2 = new Product("trousers", "jeans", new BigDecimal(80), true);
        Product product3 = new Product("t-shirt", "cotton", new BigDecimal(50), true);
        ProductGroup productGroup = new ProductGroup("Clothes");

        product1.setProductGroup(productGroup);
        product2.setProductGroup(productGroup);
        product3.setProductGroup(productGroup);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);

        long product1Id = product1.getId();
        long product2Id = product2.getId();
        long product3Id = product3.getId();

        Optional<Product> saveProduct1 = productRepository.findById(product1Id);
        Optional<Product> saveProduct2 = productRepository.findById(product2Id);
        Optional<Product> saveProduct3 = productRepository.findById(product3Id);
        //Then
        Assert.assertNotEquals(0, saveProduct1);
        Assert.assertNotEquals(0, saveProduct2);
        Assert.assertNotEquals(0, saveProduct3);
        //CleanUP
        productRepository.deleteById(product1Id);
        productRepository.deleteById(product2Id);
        productRepository.deleteById(product3Id);
    }
}
