package ru.job4j.accident.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import ru.job4j.accident.model.Accident;
import ru.job4j.accident.repository.AccidentJdbcTemplate;

@Controller
public class AccidentControl {

    private AccidentJdbcTemplate accidents;

    public AccidentControl(AccidentJdbcTemplate accidents) {
        this.accidents = accidents;
    }

    @GetMapping("/create")
    public String create() {
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("accident") Accident accident) {
        accidents.create(accident);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        Accident accident = accidents.findById(id);
        model.addAttribute("accident", accident);
        return "accident/edit";
    }

    @PostMapping("/change")
    public String editAccident(@ModelAttribute("accident") Accident accident) {
        accidents.update(accident);
        return "redirect:/";
    }
}
