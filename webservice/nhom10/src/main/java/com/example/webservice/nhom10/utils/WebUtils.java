// package com.example.webservice.nhom10.utils;

// import java.io.ByteArrayOutputStream;
// import java.util.Base64;

// import javax.imageio.ImageIO;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.google.zxing.BarcodeFormat;
// import com.google.zxing.client.j2se.MatrixToImageWriter;
// import com.google.zxing.common.BitMatrix;
// import com.google.zxing.qrcode.QRCodeWriter;
// import java.awt.image.BufferedImage;


// public class WebUtils {

    


//     public static String generatedQRcode(String data, int wid, int hei){
//         StringBuilder result = new StringBuilder();

//         if(!data.isEmpty()){
//             ByteArrayOutputStream os = new ByteArrayOutputStream();

//             QRCodeWriter writer = new QRCodeWriter();
//             try {
//                 BitMatrix bitMatrix = writer.encode(data, BarcodeFormat.QR_CODE, wid, hei);
//                 BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
//                 ImageIO.write(bufferedImage, "png", os);

//                 result.append("data:image/png;base64,");
//                 result.append(new String(Base64.getEncoder().encode(os.toByteArray())));


//             } catch (Exception e) {
//                 // TODO Auto-generated catch block
//                 e.printStackTrace();
//                 System.out.println(e.getLocalizedMessage());
//             }
            
//         }
//         return result.toString();
//     }

//     // public static void main(String[] args) {
//     //     userlogindto login = new userlogindto("minhhnim", "123456", "123sda@gmail.com");
//     //     String input = prettyObject(login);
//     //     String qrCode = generatedQRcode(input, 200, 200);

//     //     System.out.println(qrCode);
//     // }
// }


