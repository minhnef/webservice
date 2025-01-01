package com.example.webservice.nhom10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webservice.nhom10.repository.chamcongrepo;
import com.example.webservice.nhom10.repository.nhanvienrepo;
import com.example.webservice.nhom10.service.impl.iqrcodeser;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import java.io.IOException;


@Service
public class qrcodeser implements iqrcodeser{
    

    @Autowired
    nhanvienrepo nhanvienrepo;
    @Autowired
    chamcongrepo chamcongrepo;
    @Override
    public void generatedQRCode(int manv) throws WriterException, IOException, ChecksumException, FormatException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generatedQRCode'");
    }
    @Override
    public boolean checkQRCodeScanned() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkQRCodeScanned'");
    }

    

    // @Override
    // public void generatedQRCode(int text) throws WriterException, IOException, ChecksumException, FormatException{
    //     Optional<nhanvien> optional = nhanvienrepo.findById(text);
    //     if(optional.isPresent()){
    //         nhanvien nhanvien = optional.get();

    //         LocalDateTime time = LocalDateTime.now();
    //         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yy"); 
    //         String thoigian = time.format(formatter);
    //         // Tạo một đối tượng BitMatrix để biểu diễn mã QR
    //         String code ="Nhan vien: "+ text +" diem danh luc "+ thoigian;
    //         // BitMatrix matrix = new MultiFormatWriter().encode(code, BarcodeFormat.QR_CODE, width, height);
    
    //         // // Chuyển đổi BitMatrix thành hình ảnh
    //         // ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    //         // MatrixToImageWriter.writeToStream(matrix, "PNG", outputStream);
    //         // byte[] imageBytes = outputStream.toByteArray();
    
    //         // // Tạo response trả về hình ảnh
    //         // HttpHeaders headers = new HttpHeaders();
    //         // headers.setContentType(MediaType.IMAGE_PNG);
    //         //  // Kiểm tra xem mã QR có thể quét được hay không       
    //         // try {
    //         //     BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageBytes));
    //         //     LuminanceSource source = new BufferedImageLuminanceSource(image);
    //         //     BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
    //         //     Reader reader = new MultiFormatReader();
    //         //     Result result = reader.decode(bitmap);
    //         //     System.out.println("Decoded text: " + result.getText()); 
                
                
                
    //         // } catch (NotFoundException e) {
    //         //     System.out.println("Không thể quét được mã QR.");
    //         // }
    //         chamcong chamcong = new chamcong();
                
    //             if(chamcongrepo.existsById(1)==false){
    //                 chamcong.setId(1);
    //                 chamcong.setNoidung(code);
    //             chamcongrepo.save(chamcong);
    //             }else{
    //                  chamcong.setId(chamcongrepo.getMaxID()+1);
    //                  chamcong.setNoidung(code);
    //             chamcongrepo.save(chamcong);
    //             }
               
                

    //             nhanvien.setNgaycong(nhanvien.getNgaycong()+1);
    //             nhanvienrepo.save(nhanvien);
    //     //     return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    //     // }else{
    //     //         return ResponseEntity.notFound().build();
    //     }   

    // }

    // @Override
    // public boolean checkQRCodeScanned() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'checkQRCodeScanned'");
    // }
    

}
