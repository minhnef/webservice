package com.example.webservice.nhom10.controller;

import com.example.webservice.nhom10.entity.kho;
import com.example.webservice.nhom10.repository.KhoRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/kho")
public class KhoController {
    @Autowired
    KhoRepo khoRepo;
    @RequestMapping
    public String index(Model model) {
        model.addAttribute("nguyenlieu",khoRepo.findAll());
        List<kho> nguyenlieus = khoRepo.findAll();

        return "nguyenlieu";
    }
    @RequestMapping(value = "/add")
    public String add(Model model) {
        //thêm thuộc tính vào đối tượng model với key là persons và value là new Person
        model.addAttribute("nguyenlieu", new kho());
        return "add";
    }
    @RequestMapping(value = "/save" ,method = RequestMethod.POST)
    public String add(@RequestParam kho kho) {
        //Lưu person vào personService
        khoRepo.save(kho);
        //trả về trang chủ
        return "nguyenlieu";
    }
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public String save(@ModelAttribute kho kho) {
//        //Lưu person vào personService
//        khoRepo.save(kho);
//        //trả về trang chủ
//        return "redirect:/";
//    }
@RequestMapping(value = "delete", method = RequestMethod.GET)
public String delete(
        //requestparam lấy id bên form index gán vào personId tạo object model để addAttribute
        @RequestParam("id") int id, Model model) {
    //thực hiện phương thức xóa trong personService
    khoRepo.deleteById(id);
    //trả về trang chủ khi thực hiên xong
    return "redirect:/kho";
}
}
