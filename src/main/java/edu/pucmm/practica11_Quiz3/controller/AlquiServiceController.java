/**
 * Created by Djidjelly Siclait on 10/12/2016.
 */
package edu.pucmm.practica11_Quiz3.controller;


import edu.pucmm.practica11_Quiz3.modelo.Equipment;
import edu.pucmm.practica11_Quiz3.modelo.Family;
import edu.pucmm.practica11_Quiz3.modelo.Rent;
import edu.pucmm.practica11_Quiz3.modelo.SubFamily;
import edu.pucmm.practica11_Quiz3.service.AlquiService;
import edu.pucmm.practica11_Quiz3.service.ClientService;
import edu.pucmm.practica11_Quiz3.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AlquiServiceController {

    @Autowired
    private AlquiService alquiService;
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private ClientService clientService;

    @RequestMapping("/AlquiService")
    public ModelAndView register(Model model){

        java.util.Date utilDate = new java.util.Date();
        model.addAttribute("today", new Date(utilDate.getTime()));

        model.addAttribute("equipments", inventoryService.findAllEquipments());
        model.addAttribute("totalE", inventoryService.findAllEquipments().size());

        model.addAttribute("clients", clientService.findAllClients());
        model.addAttribute("totalC", clientService.findAllClients().size());

        model.addAttribute("rents", alquiService.findAllActiveRents());
        model.addAttribute("totalR", alquiService.findAllActiveRents().size());

        return new ModelAndView("AlquiService");
    }

    @RequestMapping("/Rents")
    public ModelAndView getRents(Model model){

        java.util.Date utilDate = new java.util.Date();
        model.addAttribute("today", new Date(utilDate.getTime()));

        model.addAttribute("actives", alquiService.findAllActiveRents());
        model.addAttribute("totalA", alquiService.findAllActiveRents().size());
        model.addAttribute("inactives", alquiService.findAllCompletedRent());
        model.addAttribute("totalI", alquiService.findAllCompletedRent().size());

        return new ModelAndView("rents");
    }

    @RequestMapping("/Statistics")
    public ModelAndView getStatistics(Model model){

        model.addAttribute("clients", clientService.findAllClients().size());

        List<String> most = findMostPopular();
        model.addAttribute("popularE", most.get(0));
        model.addAttribute("popularF", most.get(1));
        model.addAttribute("popularSF", most.get(2));

        model.addAttribute("rents", alquiService.findAllRents());
        model.addAttribute("totalR", alquiService.findAllRents().size());
        model.addAttribute("receipts", alquiService.findAllReceipts());
        model.addAttribute("totalT", alquiService.findAllReceipts().size());

        model.addAttribute("fAve", findFamilyDayAverage());
        model.addAttribute("sAve", findSubFamilyDayAverage());

        return new ModelAndView("statistics");
    }

    // Posts
    @PostMapping("/lend")
    public String registerNewLend(@RequestParam("equipment") String equipmentName, @RequestParam("return") String promisedDate, @RequestParam("rate") float priceRate, @RequestParam("client") String clientId){

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date date = new java.util.Date();
        try {
           date = sdf1.parse(promisedDate);
        } catch (Exception exp){

        }
        Date sqlDate = new Date(date.getTime());
        alquiService.lendRegisteredEquipment(inventoryService.findEquipmentByName(equipmentName).getEquipmentId(), sqlDate, priceRate, clientId);

        return "redirect:/AlquiService";
    }

    @PostMapping("/return")
    public String returnBorrowedEquipment(@RequestParam("equipment") String equipmentName, @RequestParam("id") String rentId){

        alquiService.returnRegisteredEquipment(inventoryService.findEquipmentByName(equipmentName).getEquipmentId(), rentId);

        return "redirect:/AlquiService";
    }

    // Auxiliary Functions
    private List<String> findMostPopular(){
        List<String> stats = new ArrayList<>();

        stats.add("Equipment");
        stats.add("Family");
        stats.add("SubFamily");

        int max = 0;

        for (Equipment e:
             inventoryService.findAllEquipments()) {
            int count = 0;

            for (Rent r:
                 alquiService.findAllRents()) {
                if (r.getEquipment().getEquipmentId().equals(e.getEquipmentId()))
                    count++;
            }

            if (count > max){
                max = count;
                stats.remove(0);
                stats.add(0, e.getEquipmentName());
            }
        }

        max = 0;
        for (Family f:
                inventoryService.findAllFamilies()) {
            int count = 0;

            for (Rent r:
                    alquiService.findAllRents()) {
                if (r.getEquipment().getFamily().getFamilyName().equals(f.getFamilyName()))
                    count++;
            }

            if (count > max){
                max = count;
                stats.remove(1);
                stats.add(1, f.getFamilyName());
            }
        }

        max = 0;
        for (SubFamily s:
                inventoryService.findAllSubFamilies()) {
            int count = 0;

            for (Rent r:
                    alquiService.findAllRents()) {
                if (r.getEquipment().getSubFamily().getSubFamilyName().equals(s.getSubFamilyName()))
                    count++;
            }

            if (count > max){
                max = count;
                stats.remove(2);
                stats.add(2, s.getSubFamilyName());
            }
        }
        
        return stats;
    }

    private ArrayList<String> findFamilyDayAverage(){
        ArrayList<String> average = new ArrayList<>();

        for (Family f:
             inventoryService.findAllFamilies()) {
            int count = 0;
            Float sum = 0f;
            for (Rent r:
                 alquiService.findAllRents())
                if (r.getEquipment().getFamily().getFamilyName().equals(f.getFamilyName())){
                    sum += r.getDaysOut();
                    count++;
                }

            if (count > 0)
            average.add("'" + f.getFamilyName() + "', " + Float.toString(sum/count));
        }

        return average;
    }

    private ArrayList<String> findSubFamilyDayAverage(){
        ArrayList<String> average = new ArrayList<>();

        for (SubFamily s:
                inventoryService.findAllSubFamilies()) {
            int count = 0;
            Float sum = 0f;
            for (Rent r:
                    alquiService.findAllRents())
                if (r.getEquipment().getSubFamily().getSubFamilyName().equals(s.getSubFamilyName())){
                    sum += r.getDaysOut();
                    count++;
                }

            if (count > 0)
                average.add("'" + s.getSubFamilyName() + "', " + Float.toString(sum/count));
        }

        return average;
    }
}
