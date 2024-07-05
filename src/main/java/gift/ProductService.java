package gift;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product findById(Long id){
        return productRepository.findById(id);
    }
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public void create(ProductDto productDto) throws NameException{
        Product product = new Product(null, productDto.getName(), productDto.getPrice(), productDto.getImageUrl());
        product.validate();
        productRepository.save(product);
    }

    public void update(Long id, ProductDto productDto) throws NameException {
        Product product = productRepository.findById(id);
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());
        product.validate();
        productRepository.update(id, product);
    }
    public void delete(Long id){
        productRepository.delete(id);
    }

}
