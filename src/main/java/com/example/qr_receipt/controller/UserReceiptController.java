package com.example.qr_receipt.controller;

import com.example.qr_receipt.entity.Receipt;
import com.example.qr_receipt.service.ReceiptService;
import com.google.zxing.WriterException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@AllArgsConstructor
@RestController
public class UserReceiptController {

    private ReceiptService receiptService;



    @GetMapping("/receipt/{id}")
    public Receipt fetchReceiptById(@PathVariable("id") Long receiptId){
        return receiptService.fetchReceiptById(receiptId);
    }

    @PostMapping("/receipt/generate")
    public String generateQRCode(@Valid @RequestBody Receipt receipt ) throws IOException, WriterException {
        return receiptService.generateQRCode(receipt);
    }


}
