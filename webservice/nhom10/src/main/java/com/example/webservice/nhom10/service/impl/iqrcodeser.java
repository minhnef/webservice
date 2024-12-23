package com.example.webservice.nhom10.service.impl;

import java.io.IOException;

import org.springframework.http.ResponseEntity;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;

public interface iqrcodeser {
    public ResponseEntity<byte[]> generatedQRCode(int manv) throws WriterException, IOException,  ChecksumException, FormatException;

    public boolean checkQRCodeScanned();
}
