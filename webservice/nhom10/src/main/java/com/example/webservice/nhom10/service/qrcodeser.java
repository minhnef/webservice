package com.example.webservice.nhom10.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.webservice.nhom10.entity.chamcong;
import com.example.webservice.nhom10.entity.nhanvien;
import com.example.webservice.nhom10.repository.chamcongrepo;
import com.example.webservice.nhom10.repository.nhanvienrepo;
import com.example.webservice.nhom10.service.impl.iqrcodeser;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;



@Service
public class qrcodeser implements iqrcodeser{
    

    private static final int width = 300;
    private static final int height = 300;

    @Autowired
    nhanvienrepo nhanvienrepo;
    @Autowired
    chamcongrepo chamcongrepo;
    // @Override
    // public void generatedQRCode(int manv) throws WriterException, IOException, ChecksumException, FormatException {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'generatedQRCode'");
    // }
    // @Override
    // public boolean checkQRCodeScanned() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'checkQRCodeScanned'");
    // }

    

    @Override
    public ResponseEntity<byte[]> generatedQRCode(int text) throws WriterException, IOException, ChecksumException, FormatException{
        Optional<nhanvien> optional = nhanvienrepo.findById(text);
        if(optional.isPresent()){
            nhanvien nhanvien1 = optional.get();

            LocalDateTime time = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yy"); 
            String thoigian = time.format(formatter);
            // Tạo một đối tượng BitMatrix để biểu diễn mã QR
            String code ="Nhan vien: "+ text +" diem danh luc "+ thoigian;
            BitMatrix matrix = new MultiFormatWriter().encode(code, BarcodeFormat.QR_CODE, 300, 300);
    
            // Chuyển đổi BitMatrix thành hình ảnh
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(matrix, "PNG", outputStream);
            byte[] imageBytes = outputStream.toByteArray();
    
            // Tạo response trả về hình ảnh
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);
             // Kiểm tra xem mã QR có thể quét được hay không       
            try {
                BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageBytes));
                LuminanceSource source = new BufferedImageLuminanceSource(image);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                Reader reader = new MultiFormatReader();
                Result result = reader.decode(bitmap);
                System.out.println("Decoded text: " + result.getText()); 
                
                
                
            } catch (NotFoundException e) {
                System.out.println("Không thể quét được mã QR.");
            }
            chamcong chamcong = new chamcong();
                
                chamcong.setIdnhanvien(text);
                chamcong.setChamcong(thoigian);
                chamcongrepo.save(chamcong);
                
               
                int ngaycong = optional.get().getNgaycong();
                optional.get().setNgaycong(ngaycong+1);
                // Lưu nhanvien
                nhanvienrepo.save(optional.get());
            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        
        }else{
                return ResponseEntity.notFound().build();
        }   

    }

    @Override
    public boolean checkQRCodeScanned() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkQRCodeScanned'");
    }
    

}
