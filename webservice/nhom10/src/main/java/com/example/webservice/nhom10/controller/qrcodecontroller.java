// package com.example.webservice.nhom10.controller;

// import java.io.IOException;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.webservice.nhom10.service.qrcodeser;
// import com.google.zxing.ChecksumException;
// import com.google.zxing.FormatException;
// import com.google.zxing.WriterException;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// @RestController
// public class qrcodecontroller {
//     @Autowired
//     private qrcodeser qrcodeser;

//     @GetMapping("/generateQRCode")
//     public ResponseEntity<byte[]> generateQRCode(@RequestParam("text") int text)
//             throws WriterException, IOException, ChecksumException, FormatException {
//         return qrcodeser.generatedQRCode(text);
//     }

// }
