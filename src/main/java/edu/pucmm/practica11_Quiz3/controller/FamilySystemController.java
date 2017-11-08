package edu.pucmm.practica11_Quiz3.controller;


import edu.pucmm.practica11_Quiz3.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FamilySystemController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/families_subfamilies")
    public ModelAndView index(Model model) {
        model.addAttribute("fcount", inventoryService.findAllFamilies().size() + 1);
        model.addAttribute("scount", inventoryService.findAllSubFamilies().size() + 1);
        model.addAttribute("families", inventoryService.findAllFamilies());
        model.addAttribute("subfamilies", inventoryService.findAllSubFamilies());
        return new ModelAndView("familySystem");
    }


    @Secured("ADMIN")
    @PostMapping("/addNewFamily")
    public String newFamily(@RequestParam("name") String name){

        inventoryService.registerNewFamily(name);

        return "redirect:/families_subfamilies";
    }

    @Secured("ADMIN")
    @PostMapping("/addNewSubFamily")
    public String newSubFamily(@RequestParam("name") String name, @RequestParam("family") String familyName){

        inventoryService.registerSubFamily(name, inventoryService.findFamilyByFamilyName(familyName).getFamilyKey());

        return "redirect:/families_subfamilies";
    }
}
