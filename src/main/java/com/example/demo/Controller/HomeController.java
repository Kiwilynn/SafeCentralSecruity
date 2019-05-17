package com.example.demo.Controller;

import com.example.demo.Model.Customer;
import com.example.demo.Model.Login;
import com.example.demo.Model.Employee;
import com.example.demo.Model.NewsFeed;
import com.example.demo.Model.Owner;
import com.example.demo.Model.Schedule;
import com.example.demo.Repository.LoginRepo;
import com.example.demo.Service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {


    @Autowired
    Services services;

    @GetMapping("/")
    public String index() {
        return "/index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<NewsFeed> newsFeedList = services.getAllNewsFeed();
        model.addAttribute("newsfeeds", newsFeedList);
        return "/home";
    }

    @GetMapping("/createNewsfeed")
    public String createNewsFeed(){
        return "/newsfeed/createNewsfeed";
    }

    @PostMapping("/createNewsfeed")
    public String createNewsFeed(@ModelAttribute NewsFeed newsFeed){
        services.createNewsFeed(newsFeed);
        return "redirect:/home";
    }

    @GetMapping("/delete_news/{id}")
    public String deleteNewsFeed(@PathVariable("id")int id, Model model){
        boolean deleted = services.deleteNewsFeed(id);
        if(deleted){
            return "redirect:/home";
        }else{
            return "redirect:/home";
        }
    }

    @GetMapping("/viewCustomer")
    public String viewCustomer() {
        return "/customer/viewCustomer";
    }

    @PostMapping("/customer/viewCustomer")
    public String viewCustomers(Model model) {
        List<Customer> customerList = services.getAll();
        model.addAttribute("customers", customerList);
        return "customer/viewCustomer";
    }

    @GetMapping("/customer/viewCustomer")
    public String viewCustomer(Model model) {
        List<Customer> customerList = services.getAll();
        model.addAttribute("customers", customerList);
        return "customer/viewCustomer";
    }


    @GetMapping("/viewEmployee")
    public String viewEmployee() {
        return "/employee/viewEmployee";
    }

    @PostMapping("/employee/viewEmployee")
    public String viewEmployees(Model model) {
        List<Owner> employeeList = services.getAllEmployees();
        model.addAttribute("employees", employeeList);
        return "employee/viewEmployee";
    }

    @GetMapping("/employee/viewEmployee")
    public String viewEmployee(Model model) {
        List<Owner> employeeList = services.getAllEmployees();
        model.addAttribute("employees", employeeList);
        return "employee/viewEmployee";
    }

    @PostMapping("/createEmployee")
    public String createEmployee(@ModelAttribute Owner owner) {
        services.addEmployee(owner);
        return "redirect:/employee/viewEmployee";
    }


    @PostMapping("/createCustomer")
    public String create(@ModelAttribute Customer customer) {
        services.addCustomer(customer);
        return "redirect:/customer/viewCustomer";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        boolean deleted = services.deleteCustomer(id);
        if (deleted) {
            return "redirect:/customer/viewCustomer";
        } else {
            return "redirect:/customer/viewCustomer";
        }
    }


    @PostMapping("/home")
    public String login(@ModelAttribute Login la, Model model) {
        model.addAttribute("logins", la);
        services.getLogin();
        for (Login login : services.getLogin()) {
           if (login.getUsername().equals(la.getUsername())&& login.getPassword().equals(la.getPassword())){

               return "redirect:/home";
          }

        }

    return "/index";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        boolean deleted = services.deleteEmployee(id);
        if (deleted) {
            return "redirect:/employee/viewEmployee";
        } else {
            return "redirect:/employee/viewEmployee";
        }
    }

    @GetMapping("/viewSchedule")
    public String viewSchedule(Model model){
        List<Schedule> scheduleList = services.getAllSchedules();
        model.addAttribute("schedules", scheduleList);
        return "schedule/viewSchedule";
    }

    @GetMapping("/updateCustomer/{id}")
    public String update(@PathVariable("id") int id, Model model){
        model.addAttribute("customer", services.findCustomerById(id));
        return "customer/updateCustomer";

    }
    @PostMapping("/customer/updateCustomer")
    public String update(@ModelAttribute Customer customer){
        services.updateCustomer(customer.getKunde_id(), customer);

        return "redirect:/customer/viewCustomer";
    }

    @GetMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable("id") int id, Model model){
        model.addAttribute("employee", services.findEmployeeById(id));
        return "employee/updateEmployee";

    }
    @PostMapping("/employee/updateEmployee")
    public String updateEmployee(@ModelAttribute Owner o){
        services.updateEmployee(o.getMedarbejder_id(), o);

        return "redirect:/employee/viewEmployee";
    }


}