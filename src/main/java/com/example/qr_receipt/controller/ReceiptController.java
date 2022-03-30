package com.example.qr_receipt.controller;

import com.example.qr_receipt.entity.Receipt;
import com.example.qr_receipt.service.ReceiptService;
import com.google.zxing.WriterException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;

@AllArgsConstructor
@RestController
public class ReceiptController {

    private ReceiptService receiptService;

    @PostMapping("/receipt")
    public Receipt saveReceipt(@Valid Receipt receipt) throws Exception {
        return receiptService.saveReceipt(receipt);
    }


    @GetMapping("/receipt/{id}")
    public Receipt fetchReceiptById(@PathVariable("id") Long receiptId){
        return receiptService.fetchReceiptById(receiptId);
    }

    @GetMapping("/receipt/{id}/generate")
    public String generateQRCode(@PathVariable ("id") Long receiptId) throws IOException, WriterException {
        return receiptService.generateQRCode(receiptId);
    }


}
