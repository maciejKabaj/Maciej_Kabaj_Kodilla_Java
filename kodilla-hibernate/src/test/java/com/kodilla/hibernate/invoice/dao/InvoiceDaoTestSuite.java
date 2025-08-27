package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Autowired
    private ProductDao productDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product monitor = new Product("Monitor");
        Product keyboard = new Product("Keyboard");
        productDao.save(monitor);
        productDao.save(keyboard);
        Invoice invoice = new Invoice("FV-001");
        List<Item> items = List.of(
                new Item(monitor, new BigDecimal("1000"), 2, new BigDecimal("2000"), invoice),
                new Item(keyboard, new BigDecimal("200"), 1, new BigDecimal("200"), invoice));
        invoice.setItems(items);
        invoiceDao.save(invoice);
        //When
        int invoiceId = invoice.getId();
        Optional<Invoice> retrievedInvoice = invoiceDao.findById(invoiceId);
        //Then
        assertTrue(retrievedInvoice.isPresent());
        assertEquals("FV-001", retrievedInvoice.get().getNumber());
        assertEquals(2, retrievedInvoice.get().getItems().size());
        //CleanUP
        //invoiceDao.deleteById(invoiceId); //@Transactional makes it redundant
    }
}