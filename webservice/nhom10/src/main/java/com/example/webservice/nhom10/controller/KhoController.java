package com.example.webservice.nhom10.controller;

import com.example.webservice.nhom10.entity.kho;
import com.example.webservice.nhom10.repository.KhoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/kho")
public class KhoController {

    @Autowired
    KhoRepo khoRepo;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        List<kho> nguyenlieus = khoRepo.findAll();

        // // In ra log để kiểm tra dữ liệu
        // for (kho item : nguyenlieus) {
        //     System.out.println(item);
        // }

        model.addAttribute("nguyenlieu", nguyenlieus);
        return "html/nguyenlieu/nguyenlieu";
    }
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String editPerson(@RequestParam("id") int id, Model model) {
        //tạo optional để luư đối tượng personEdit
        Optional<kho> nguyenlieu = khoRepo.findById(id);

        //kiếm tra nếu tồn tại thì thực hiện biểu thức lambda xong return về biến person bằng ifPresent của optional
        nguyenlieu.ifPresent(nl ->
                model.addAttribute("nguyenlieu", nl)
        );
        nguyenlieu.ifPresent(nl ->
                System.out.println(nl.getNgaynhap())
        );
        //trả ve form editPerson

        return "html/nguyenlieu/edit";
    }
    @RequestMapping("/search")
    public String search(@RequestParam("value") String value,
                         Model model
    ) {

        //tạo 1 list chứa các đối tượng person bằng thuộc tính getAll() của class crudRepository kế thừa
        List<kho> nguyenlieu=khoRepo.search(value);

        //thêm thuộc tính vào đối tượng model với key là persons và value là persons
        model.addAttribute("nguyenlieu",nguyenlieu);
//trả về index.html
        return "html/nguyenlieu/nguyenlieu";
    }

    @RequestMapping(value = "/add")
    public String add(Model model) {
        // Thêm thuộc tính vào đối tượng model với key là "nguyenlieu" và value là new kho()
        model.addAttribute("nguyenlieu", new kho());
        return "html/nguyenlieu/add";
    }

//    @RequestMapping(value = "/form", method = RequestMethod.GET)
//    public String showForm(Model model) {
//        model.addAttribute("nguyenlieu", new kho());
//        return "form";
//    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute kho request) {
        // Lưu đối tượng kho vào khoRepo


        khoRepo.save(request);

        // Trả về trang chủ
        return "redirect:/kho";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(
            @RequestParam("id") int id, Model model) {
        // Thực hiện phương thức xóa trong khoRepo
        khoRepo.deleteById(id);
        // Trả về trang chủ khi thực hiện xong
        return "redirect:/kho";
    }

    // Thêm phương thức chỉnh sửa

}
