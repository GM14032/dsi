package com.restaurante.dsi.service.businesslogic;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.dsi.model.businesslogic.DiningTable;
import com.restaurante.dsi.repository.businesslogic.IDiningTableRepository;
import com.restaurante.dsi.service.businesslogic.IDiningTableService;

import jakarta.transaction.Transactional;

@Service("TablesService")
public class DiningTableServiceImpl implements IDiningTableService {
    @Autowired
  private IDiningTableRepository tableRepository;

  @Override
  public List<DiningTable> findAll() {
    return tableRepository.findAll();
  }

  @Override
  @Transactional
  public DiningTable save(DiningTable table) {
      return tableRepository.save(table);

  }

   @Override
    @Transactional
    public DiningTable update(DiningTable currentTable, DiningTable table) {

            if(table.getCapacity()!=null){
                currentTable.setCapacity(table.getCapacity());
            }
            if(table.getDescription()!=null){
                currentTable.setDescription(table.getDescription());
            }
            return tableRepository.save(currentTable);

    }
  @Override
  public DiningTable findById(Long id) {
    return tableRepository.findById(id).orElse(null)  ;
  }

  @Override
  public void delete(Long id) {
  }

    
}
