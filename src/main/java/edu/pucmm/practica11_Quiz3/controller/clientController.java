package edu.pucmm.practica11_Quiz3.controller;

import edu.pucmm.practica11_Quiz3.modelo.Client;
import edu.pucmm.practica11_Quiz3.modelo.Equipment;
import edu.pucmm.practica11_Quiz3.modelo.Rent;
import edu.pucmm.practica11_Quiz3.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class clientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/Clients")
    public ModelAndView index(Model model) {
        model.addAttribute("position", clientService.findAllClients().size() + 1);
        model.addAttribute("clients", clientService.findAllClients());
        return new ModelAndView("registerClientes");
    }

    @GetMapping("/Client")
    public ModelAndView viewClient(Model model, @RequestParam("id") String identificationNumber){

        List<Rent> rents = clientService.findRentHistoryForClient(identificationNumber);

        model.addAttribute("client", clientService.findClient(identificationNumber));
        model.addAttribute("rents", rents);
        model.addAttribute("totalR", rents.size());

        return new ModelAndView("clientview");
    }

    @PostMapping("/addNewClient")
    public String newClientSubmit(@RequestParam("id") String id, @RequestParam("first") String first, @RequestParam("last") String last, @RequestParam("tel") String tel, @RequestParam("add") String add){

        clientService.registerNewClient(id, first, last, tel, add);

        return "redirect:/Clients";
    }

    @PostMapping("/editClient")
    public String addImagetoClient(@RequestParam("idP") String id, @RequestParam("file") MultipartFile file){

        Client client = clientService.findClient(id);

        clientHelp(client,file);

        return "redirect:/Clients";
    }



    //Auxiliary Functions
    private Byte[] procesImageFile(byte[] buffer) {
        Byte[] bytes = new Byte[buffer.length];
        int i = 0;

        for (byte b :
                buffer)
            bytes[i++] = b; // Autoboxing

        return bytes;
    }

    private Boolean clientHelp(Client client, MultipartFile file){

        try {
            client.setPhoto(procesImageFile(file.getBytes()));

            clientService.editClient(client);
        } catch (IOException exp) {
            System.out.println("Error while Uploading image");
            return false;
        } catch (NullPointerException exp) {
            System.out.println("Image data is null");
            return false;
        }

        return true;
    }
}
