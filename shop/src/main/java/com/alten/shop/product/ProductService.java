package com.alten.shop.product;

import com.alten.shop.exceptions.ProduitNonTrouve;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService {
    private final ProductRepo productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepo productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductDto createProduct(ProductDto productDto) {
        ProductEntity product = productMapper.toEntity(productDto);
        ProductEntity savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toDto)
                .toList();
    }

    public ProductDto getProductById(Long id) {
        var product = productRepository.findById(id);
        if (product.isPresent()){
            return productMapper.toDto(product.get());
        } else {
            throw new ProduitNonTrouve("Produit n'est pas trouve");
        }

    }

    public Optional<ProductDto> updateProduct(Long id, ProductDto productDto) {
        var product = productRepository.findById(id);
        if (product.isPresent()){
            return product.map(existingProduct -> {
                if (productDto.getCode() != null) existingProduct.setCode(productDto.getCode());
                if (productDto.getName() != null) existingProduct.setName(productDto.getName());
                if (productDto.getDescription() != null) existingProduct.setDescription(productDto.getDescription());
                if (productDto.getImage() != null) existingProduct.setImage(productDto.getImage());
                if (productDto.getCategory() != null) existingProduct.setCategory(productDto.getCategory());
                if (productDto.getPrice() != null) existingProduct.setPrice(productDto.getPrice());
                if (productDto.getQuantity() != null) existingProduct.setQuantity(productDto.getQuantity());
                if (productDto.getInternalReference() != null) existingProduct.setInternalReference(productDto.getInternalReference());
                if (productDto.getShellId() != null) existingProduct.setShellId(productDto.getShellId());
                if (productDto.getInventoryStatus() != null) existingProduct.setInventoryStatus(InventoryStatus.valueOf(productDto.getInventoryStatus()));
                if (productDto.getRating() != null) existingProduct.setRating(productDto.getRating());
                if (productDto.getCreatedAt() != null) existingProduct.setCreatedAt(productDto.getCreatedAt());
                if (productDto.getUpdatedAt() != null) existingProduct.setUpdatedAt(productDto.getUpdatedAt());

                return productMapper.toDto(productRepository.save(existingProduct));
            });
        } else {
            throw new ProduitNonTrouve("Produit n'est pas trouve");
        }
    }


    public void deleteProduct(Long id) {
        var product = productRepository.findById(id);
        if (product.isPresent()){
            productRepository.deleteById(id);
        } else {
            throw new ProduitNonTrouve("Produit n'est pas trouve");
        }

    }
}
