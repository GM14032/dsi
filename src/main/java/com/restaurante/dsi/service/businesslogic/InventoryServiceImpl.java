package com.restaurante.dsi.service.businesslogic;

import com.restaurante.dsi.model.auth.User;
import com.restaurante.dsi.model.businesslogic.Inventory;
import com.restaurante.dsi.model.businesslogic.InventoryDto;
import com.restaurante.dsi.repository.businesslogic.IInventoryRepository;
import com.restaurante.dsi.service.auth.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;


@Service
public class InventoryServiceImpl implements IInventoryService {
    @Autowired
    private IInventoryRepository inventoryRepository;
    @Autowired
    private EmailService emailService;

    @Override
    public List<Inventory> findAll( Boolean active) {
        if (active != null && active) {
            return inventoryRepository.findByIsActiveTrue();
        }
        return inventoryRepository.findAllByOrderByIdDesc();
    }

    @Override
    public Inventory save(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory update(Inventory currentInventory, Inventory inventory) {
      return inventoryRepository.save(currentInventory);
    }

    @Override
    public Inventory findById(Long id) {
        return inventoryRepository.findById(id).orElse(null);
    }

    @Override
    public void sendInventoryReport(byte[] pdfBytes,List<User> users) throws MessagingException {
        String name = "Restaurante DSI";
        String subject = "Reporte de inventario";
        String body = "Haga clic en el archivo para descargar tu reporte semanal del inventario";
        String pdfName = (LocalDate.now()) + "-inventario.pdf";
        String[] cc = new String[users.size() - 1];
        String email = users.get(0).getEmail();
        if (users.size() > 1) {
            for (int i = 1; i < users.size(); i++) {
                cc[i - 1] = users.get(i).getEmail();
            }
        }

        emailService.sendEmail(email, subject, body, name, pdfBytes,pdfName,cc);
    }

    @Override
    public List<InventoryDto> getInventoryReport() {
        return inventoryRepository.getInventoryReport();
    }
}
