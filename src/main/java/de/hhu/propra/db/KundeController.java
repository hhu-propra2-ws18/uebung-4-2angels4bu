package de.hhu.propra.db;

import de.hhu.propra.db.data.KundeRepository;
import de.hhu.propra.db.entities.Auto;
import de.hhu.propra.db.entities.Kunde;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class KundeController{
    @Autowired
    KundeRepository kunden;

    @GetMapping(path = "/")
    public String index(Model model) {
        List<Kunde> all = kunden.findAll();
        model.addAttribute("kunden", all);
        return "index";
    }
    @GetMapping(path = "/orders/{id}")
    public String bestellungen(Model model, @PathVariable Long id) {
        Optional<Kunde> kunde = kunden.findById(id);
        model.addAttribute("kunde", kunde);
        model.addAttribute("autos", kunde.get().getAutos());
        return "bestellungen";
    }

}
