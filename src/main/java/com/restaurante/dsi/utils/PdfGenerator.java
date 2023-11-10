package com.restaurante.dsi.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import com.restaurante.dsi.model.businesslogic.InventoryDetailDto;
import com.restaurante.dsi.model.businesslogic.InventoryDto;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

public class PdfGenerator extends Document {

    public PdfGenerator() {
        super();
        setPageSize(PageSize.A4);
    }
    public byte[] generatePdf(List<InventoryDto> lowStockItems, List<InventoryDetailDto> weeklyInventory) throws IOException, DocumentException {
        ByteArrayOutputStream pdfByte = new ByteArrayOutputStream();

        PdfWriter writer = PdfWriter.getInstance(this, pdfByte);
        open();


        Paragraph title = new Paragraph("Reporte Semanal de Inventarios del Restaurante DSI", new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD));
        title.setAlignment(Element.ALIGN_CENTER);
        add(title);
        Paragraph emptyLine = new Paragraph(" ");
        add(emptyLine);
        if(lowStockItems.isEmpty()){
            Paragraph noLowStock = new Paragraph("No hay ingredientes con stock bajo", new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD));
            noLowStock.setAlignment(Element.ALIGN_CENTER);
            add(noLowStock);
            add(emptyLine);
        }
        else {
            Paragraph lowStockSubtitle = new Paragraph("Lista de Ingredientes que deben ser comprados", new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD));
            lowStockSubtitle.setAlignment(Element.ALIGN_CENTER);
            add(lowStockSubtitle);
            add(emptyLine);
            PdfPTable lowStockTable = new PdfPTable(3);
            lowStockTable.addCell(createHeaderCell("Nombre"));
            lowStockTable.addCell(createHeaderCell("Min Stock"));
            lowStockTable.addCell(createHeaderCell("Existencias"));
            int i = 0;
            for (InventoryDto item : lowStockItems) {

                lowStockTable.addCell(createDetailCell(item.getName(),i,Element.ALIGN_LEFT));
                lowStockTable.addCell(createDetailCell(String.valueOf(item.getMinStock()),i,Element.ALIGN_CENTER));
                lowStockTable.addCell(createDetailCell(convertDoubleToString(item.getAvailableQuantity()),i,Element.ALIGN_CENTER));
                i++;
            }

            add(lowStockTable);

        }
        Paragraph weeklyInventorySubtitle = new Paragraph("Inventario de la Semana", new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD));
        weeklyInventorySubtitle.setAlignment(Element.ALIGN_CENTER);
        add(weeklyInventorySubtitle);
        add(emptyLine);

        PdfPTable weeklyInventoryTable = getPdfPTable(weeklyInventory);

        add(weeklyInventoryTable);

        close();
        return pdfByte.toByteArray();
    }

    @NotNull
    private static PdfPTable getPdfPTable(List<InventoryDetailDto> weeklyInventory) {
        DecimalFormat df = new DecimalFormat("#.##");
        PdfPTable weeklyInventoryTable = new PdfPTable(4);

        weeklyInventoryTable.addCell(createHeaderCell("Nombre"));
        weeklyInventoryTable.addCell(createHeaderCell("Min Stock"));
        weeklyInventoryTable.addCell(createHeaderCell("Existencias"));
        weeklyInventoryTable.addCell(createHeaderCell("Precio"));

        weeklyInventoryTable.setHeaderRows(1);
        int i = 0;
        for (InventoryDetailDto item : weeklyInventory) {
            Double precio = item.getPrice() ;
            weeklyInventoryTable.addCell(createDetailCell(item.getIngredientName(),i,Element.ALIGN_LEFT));
            weeklyInventoryTable.addCell(createDetailCell(String.valueOf(item.getMinStock()),i,Element.ALIGN_CENTER));
            weeklyInventoryTable.addCell(createDetailCell(convertDoubleToString(item.getQuantity()),i,Element.ALIGN_CENTER));
            weeklyInventoryTable.addCell(createDetailCell(df.format(precio),i,Element.ALIGN_CENTER));
            i++;
        }
        return weeklyInventoryTable;
    }

    public static String convertDoubleToString(double value){
        int intValue = (int) value;
        return String.valueOf(intValue);
    }
    private static PdfPCell createHeaderCell(String text) {
        PdfPCell headerCell = new PdfPCell();
        headerCell.setBackgroundColor(new BaseColor(37, 36, 64));
        headerCell.setFixedHeight(34f);
        headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
        headerCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        headerCell.setBorder(0);
        Font font = new Font(Font.getFamily("Verdana"), 14, Font.NORMAL, BaseColor.WHITE);
        Phrase phrase = new Phrase(text, font);
        headerCell.setPhrase(phrase);

        return headerCell;
    }
    private static PdfPCell createDetailCell(String text, Integer i,int element) {
        BaseColor color;
        if (i % 2 == 0) {
            color = new BaseColor(255, 255, 255);
        } else {
            color = new BaseColor(191, 191, 191);
        }

        PdfPCell detailCell = new PdfPCell(new Paragraph(text));
        detailCell.setBackgroundColor(color);
        detailCell.setFixedHeight(20f);
        detailCell.setHorizontalAlignment(element);
        detailCell.setBorder(Rectangle.NO_BORDER);

        Font font = new Font(Font.getFamily("Verdana"), 12, Font.NORMAL, BaseColor.BLACK);
        detailCell.setPhrase(new Phrase(text, font));

        return detailCell;
    }
}
