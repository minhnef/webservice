package com.example.webservice.nhom10.controller;

import com.example.webservice.nhom10.entity.monan;
import com.example.webservice.nhom10.repository.danhmucmonanrepo;
import com.example.webservice.nhom10.repository.monanrepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller

@RequestMapping("/monan")
public class monanctl {
    @Autowired
    danhmucmonanrepo danhMucRepo;
    @Autowired
    monanrepo monanRepo;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        List<monan> monans = monanRepo.findAll();

        // In ra log để kiểm tra dữ liệu
        // for (monan item : monans) {
        // System.out.println(item);
        // }

        model.addAttribute("monans", monans);
        return "html/monan/monan";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String editPerson(@RequestParam("id") int id, Model model) {
        // tạo optional để luư đối tượng personEdit
        Optional<monan> monans = monanRepo.findById(id);

        monans.ifPresent(monan -> model.addAttribute("monans", monan));
        monans.ifPresent(monan -> System.out.println(monan.getIdmonan()));

        // trả ve form editPerson
        model.addAttribute("listdm", danhMucRepo.findAll());
        return "html/monan/editmonan";
    }

    @RequestMapping(value = "/add")
    public String add(Model model) {
        // Thêm thuộc tính vào đối tượng model với key là "nguyenlieu" và value là new
        // kho()
        model.addAttribute("monan", new monan());
        model.addAttribute("listdm", danhMucRepo.findAll());
        System.out.println(danhMucRepo.findAll().size());
        return "html/monan/addmonan";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute monan request) {

        System.out.println(request.getDanhmuc().getTendanhmuc());
        //
        monanRepo.save(request);

        // Trả về trang chủ
        return "redirect:/monan";
    }

    //
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(
            @RequestParam("id") int id, Model model) {
        // Thực hiện phương thức xóa trong khoRepo
        monanRepo.deleteById(id);
        // Trả về trang chủ khi thực hiện xong
        return "redirect:/monan";
    }

    // Thêm phương thức chỉnh sửa

}
