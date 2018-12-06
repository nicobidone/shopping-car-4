/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.services.implementations;

import java.util.ArrayList;
import java.util.List;
import main.elements.CartContent;
import main.repository.CartContentRepository;
import main.repository.ProductRepository;
import main.services.CartContentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author nicob
 */
public class CartContentServiceImpl implements CartContentService{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private CartContentRepository cartContentRepository;
    private ProductRepository productRepository;
    
    @Autowired
    public void setProductRepository(   CartContentRepository cartContentRepository,
                                        ProductRepository productRepository) {
        this.cartContentRepository = cartContentRepository;
        this.productRepository = productRepository;
    }
    
    @Override
    public List<CartContent> listAllCartsContent() {
        logger.debug("listAllCartsContent called");
        Iterable<CartContent> findAll = cartContentRepository.findAll();
        List<CartContent> aux = new ArrayList<>();
        for (CartContent product : findAll) {
            aux.add(product);
        }
        return aux;
    }

    @Override
    public List<CartContent> getCartContentsById(Integer id) {
        logger.debug("listAllCartsContent called");
        Iterable<CartContent> findAll = cartContentRepository.findAll();
        List<CartContent> aux = new ArrayList<>();
        for (CartContent product : findAll) {
            if (product.getId().equals(id))
                aux.add(product);
        }
        return aux;
    }

    @Override
    public CartContent saveCartContent(CartContent cartContent) {
        logger.debug("saveCartContent called");
        return cartContentRepository.save(cartContent);
    }

    @Override
    public void deleteCartContent(Integer id) {
        logger.debug("deleteCart called");
        List<CartContent> aux = this.getCartContentsById(id);
        for (CartContent cartContent : aux) {
            new ProductServiceImpl().editProductQuantity(cartContent.getId(),cartContent.getAmount());
            cartContentRepository.deleteById(cartContent.getId());
        }
    }
    
    
    
}
