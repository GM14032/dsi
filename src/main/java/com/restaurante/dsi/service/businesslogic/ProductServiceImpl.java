package com.restaurante.dsi.service.businesslogic;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.dsi.model.businesslogic.Product;
import com.restaurante.dsi.repository.businesslogic.IProductRepository;

import jakarta.transaction.Transactional;

@Service("ProductService")
public class ProductServiceImpl implements IProductService {
@Autowired
private IProductRepository iProductRepository;

@Override
public List<Product> findAll() {
  return iProductRepository.findAll();
}
 @Override
  @Transactional
  public Product save(Product product) {
      return iProductRepository.save(product);

  }

  @Override
    @Transactional
    public Product update(Product currentProduct, Product product) {

            if(product.getName()!=null){
                currentProduct.setName(product.getName());
            }
            if(product.getPrice()!=null){
                currentProduct.setPrice(product.getPrice());
            }
            return iProductRepository.save(currentProduct);

    }

@Override
public Product findById(Long id) {
   return iProductRepository.findById(id).orElse(null)  ;
}

@Override
public void delete(Long id) {
iProductRepository.deleteById(id);
}

 


 

}
