package com.example.webservice.nhom10.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webservice.nhom10.dto.response;
import com.example.webservice.nhom10.entity.ban;
import com.example.webservice.nhom10.entity.chitietdonhang;
import com.example.webservice.nhom10.entity.dondathang;
import com.example.webservice.nhom10.entity.khachhang;
import com.example.webservice.nhom10.entity.khuyenmai;
import com.example.webservice.nhom10.repository.banrepo;
import com.example.webservice.nhom10.repository.chitietdonhangrepo;
import com.example.webservice.nhom10.repository.chitietkhuyenmairepo;
import com.example.webservice.nhom10.repository.dondathangrepo;
import com.example.webservice.nhom10.repository.khuyenmairepo;
import com.example.webservice.nhom10.service.impl.idonhangser;

@Service
public class donhangser implements idonhangser {
    @Autowired
    dondathangrepo dondathangrepo;
    @Autowired
    chitietkhuyenmairepo chitietkhuyenmairepo;
    @Autowired
    khuyenmairepo khuyenmairepo;
    @Autowired
    chitietdonhangrepo chitietdonhangrepo;
    @Autowired
    banrepo banrepo;

    public dondathang hienthi(int id) {
        return dondathangrepo.findById(id).get();
    }

    @Override
    public String thanhtoan(int iddh, int tientra) {
        Optional<dondathang> opdonhang = dondathangrepo.findById(iddh);
        if (opdonhang.isPresent()) {
            dondathang dondathang = opdonhang.get();
            List<chitietdonhang> listchitiet = dondathang.getChitietdonhangs();

            Optional<chitietdonhang> chitietDauTien = listchitiet.stream().findFirst();

            if (chitietDauTien.isPresent()) {
                if (chitietDauTien.get().getTrangthai().equals("Đã thanh toán")
                        || chitietDauTien.get().getTrangthai() == null) {
                    return "Đơn này đã được thanh toán.";
                }
                int tienthua = tientra - dondathang.getTonggia();

                for (chitietdonhang chitietdonhang2 : listchitiet) {
                    chitietdonhang2.setTrangthai("Đã thanh toán");
                    chitietdonhangrepo.save(chitietdonhang2);

                    if (chitietdonhang2.getBans().isEmpty()) {
                        continue;
                    } else {
                        for (ban ban : chitietdonhang2.getBans()) {
                            ban.setTrangthai("trống");
                            banrepo.save(ban);
                        }
                    }

                }

                dondathangrepo.save(dondathang);

                if (tienthua == 0) {
                    return "Cảm ơn quý khách đã thanh toán!";
                } else if (tienthua < 0) {
                    return "Số tiền chưa đủ để thanh toán đơn đặt hàng";
                } else {
                    return "Cảm ơn quý khách đã thanh toán! Vui lòng nhận lại: " + tienthua + "VND tại quầy";
                }
            }

        }
        return "Vui lòng kiểm tra lại ID đơn hàng";
    }

    @Override
    public String khuyenmai(int iddh, String khuyenmai) {
        Optional<dondathang> opdonhang = dondathangrepo.findById(iddh);
        if (opdonhang.isPresent()) {
            dondathang dondathang = opdonhang.get();
            khachhang khachhang = dondathang.getKhachhang();
            Optional<khuyenmai> opkm = khuyenmairepo.findByKhuyenMai(khuyenmai);
            if (opkm.isPresent()) {
                int tonggia = dondathang.getTonggia();
                int[] dieuKienVoucher = chitietkhuyenmairepo.getDieuKienByTenKM(opkm.get().getIdkm());
                for (int i = dieuKienVoucher.length - 1; i >= 0; i--) {
                    if (khachhang.getDiemtichluy() >= dieuKienVoucher[i]) {
                        int giamgia = Integer.parseInt(chitietkhuyenmairepo
                                .getGiamgia(opkm.get().getIdkm(), khachhang.getDiemtichluy()).substring(0, 2));
                        int giaSauVoucher = tonggia - tonggia * giamgia / 100;
                        dondathang.setTonggia(giaSauVoucher);
                        return "Chúc mùng quý khách áp dụng thành công voucher: " + khuyenmai
                                + "\nĐơn hàng của quý khách còn lại: " + giaSauVoucher + "VND";
                    }
                }

                return "Điểm tích luỹ cả quý khách không đủ để sử dụng voucher.";
            }
            return "Vui lòng kiểm tra lại mã Voucher khuyến mãi";

        }
        return "Vui lòng kiểm tra lại ID đơn hàng";
    }

}
