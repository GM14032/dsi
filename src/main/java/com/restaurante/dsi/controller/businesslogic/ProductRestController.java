package com.restaurante.dsi.controller.businesslogic;

import java.util.List;
import java.util.stream.Collectors;

import com.restaurante.dsi.model.businesslogic.IngredientDetail;
import com.restaurante.dsi.service.businesslogic.IIngredientDetailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.restaurante.dsi.model.businesslogic.Product;
import com.restaurante.dsi.service.businesslogic.IProductService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/products")
@Tag(name = "Productos", description = "Endpoints para los productos")
public class ProductRestController {

  @Autowired
  private IProductService productService;

  @Autowired
  private IIngredientDetailService ingredientDetailService;

  @GetMapping({ "/", "" })
 public List<Product> index(){
    return productService.findAll();
 }
  @PostMapping({"/",""})
  public Product create(@RequestBody Product product) {
    Product newProduct = productService.save(product);
     product.getIngredientDetails().forEach(ingredientDetail -> {
          ingredientDetail.setProduct(newProduct);
          ingredientDetailService.save(ingredientDetail);
      });
        newProduct.setIngredientDetails(product.getIngredientDetails());
    return newProduct;
  }

  @PutMapping("/{id}")
  public Product update(@PathVariable Long id, @RequestBody Product product) {
      Product cuProduct=productService.findById(id);
       if (product.getIngredientDetails()!=null){
           product.getIngredientDetails().forEach(ingredientDetail -> {
               ingredientDetail.setProduct(cuProduct);
                if (ingredientDetail.getId()!=null){
                    IngredientDetail updatedIngredient=ingredientDetailService.findById(ingredientDetail.getId());
                    ingredientDetailService.update(updatedIngredient,ingredientDetail);
                }else{
                    ingredientDetailService.save(ingredientDetail);
                }
           });

           List<IngredientDetail> ingredientDetailsToRemove = cuProduct.getIngredientDetails().stream()
                   .filter(ids -> !product.getIngredientDetails().stream()
                           .anyMatch(ids2 -> ids2.getId().equals(ids.getId())))
                   .collect(Collectors.toList());

           cuProduct.getIngredientDetails().removeAll(ingredientDetailsToRemove);
           for (IngredientDetail ingredientDetail : ingredientDetailsToRemove) {
               ingredientDetailService.delete(ingredientDetail.getId());
           }
       }

    return productService.update(cuProduct,product);
  }
  @GetMapping("/{id}")
  public ResponseEntity<Product> getMesaById(@PathVariable Long id) {
        Product cproduct = productService.findById(id);
        if (cproduct != null) {
          return ResponseEntity.ok(cproduct);
        } else {
          return ResponseEntity.notFound().build();
        }
    }

}
