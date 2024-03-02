package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.serviceImpl.CarsServiceImpl;

@Controller
@RequestMapping("/cars")
public class CarsController {
    private final CarsServiceImpl carsService;

    @Autowired
    public CarsController(CarsServiceImpl carsService) {
        this.carsService = carsService;
    }

    @GetMapping("/{id}")
    public String getCarById(@PathVariable("id") int id, Model model) {
        model.addAttribute("car", carsService.getCarById(id));
        return "cars";
    }

    @GetMapping
    public String getByCount(@RequestParam(value = "count", defaultValue = "5", required = false) int count, Model model) {
        model.addAttribute("cars", carsService.getCarsByCount(count));
        return "cars";
    }
}
