/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.kecebong.penuliswebapp.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import lab.kecebong.penuliswebapp.entity.Penulis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import lab.kecebong.penuliswebapp.repo.PenulisRepo;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author user
 */
@Controller
public class AppController {
    
    @Autowired
    private PenulisRepo pnlsRepo;
    
    @RequestMapping("/home")
    public void index() {}
    
    @RequestMapping("/daftar-penulis")
    public void getDaftarMahasiswa(Model model) {
        model.addAttribute("daftarPenulis",pnlsRepo.findAll());
    }

    @RequestMapping(value = "/tambah-data" , method = RequestMethod.GET)
    public void getFormTambahData(
    	@ModelAttribute("pnls") Penulis pnls, 
    	BindingResult result ) {}

    @RequestMapping(value = "/tambah-data" , method = RequestMethod.POST)
    public String simpanData(
    	@ModelAttribute("pnls") Penulis pnls, BindingResult result) {

    	System.out.println("id : " + pnls.getId());
    	System.out.println("nama : " + pnls.getNama());
    	System.out.println("judul_buku : " + pnls.getJudul_buku());
    	pnlsRepo.save(pnls);
    	return "redirect:daftar-penulis";
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public void getEditData(@RequestParam(name = "id", required =
    false) String id,
        @ModelAttribute("pnls") Penulis penulis, BindingResult
        binding) {
        Penulis pnls = pnlsRepo.findOne(id);
        penulis.setId(pnls.getId());
        penulis.setNama(pnls.getNama());
        penulis.setJudul_buku(pnls.getJudul_buku());
    }
    
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEditData(
        @ModelAttribute("pnls") Penulis pnls,
        BindingResult binding) {
        pnlsRepo.save(pnls);
        return "redirect:/daftar-penulis";
    }
    
    @RequestMapping("/delete")
    public String deleteData(
        @RequestParam(name = "id", required = true) String id) {
        pnlsRepo.delete(id);
        return "redirect:/daftar-penulis";
    }
    
}
