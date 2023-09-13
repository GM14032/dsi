package com.restaurante.dsi.service.businesslogic;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.dsi.model.businesslogic.DiningTable;
import com.restaurante.dsi.model.businesslogic.Product;
import com.restaurante.dsi.repository.businesslogic.IDiningTableRepository;
import com.restaurante.dsi.repository.businesslogic.IProductRepository;
import com.restaurante.dsi.service.businesslogic.IDiningTableService;

import jakarta.transaction.Transactional;

@Service("ProductService")
public class ProductServiceImpl implements IProductService {

private IProductRepository iProductRepository;

@Override
public List<Product> findAll() {
  return iProductRepository.findAll();
}

@Override
public Product save(Product product) {
  // TODO Auto-generated method stub
  throw new UnsupportedOperationException("Unimplemented method 'save'");
}

@Override
public Product update(Product currentProduct, Product product) {
  // TODO Auto-generated method stub
  throw new UnsupportedOperationException("Unimplemented method 'update'");
}

@Override
public Product findById(Long id) {
  // TODO Auto-generated method stub
  throw new UnsupportedOperationException("Unimplemented method 'findById'");
}

@Override
public void delete(Long id) {
  // TODO Auto-generated method stub
  throw new UnsupportedOperationException("Unimplemented method 'delete'");
}

 


 

}
