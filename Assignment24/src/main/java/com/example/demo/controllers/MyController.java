package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.data.CustomerData;
import com.example.demo.models.Customer;

@Controller
public class MyController {

    @Autowired
    private CustomerData customerData;

    @RequestMapping("/")
    public String getFirstPage() {
        return "home.html";
    }

    @RequestMapping("/signin")
    public String getLogin() {
        return "login.html";
    }

    @RequestMapping("/signup")
    public String getSignup() {
        return "register.html";
    }
    @PostMapping("/verify")
    public ModelAndView verifyUser(Integer custID, String pwd) {
        System.out.println("-----------------------------------------------------");
        System.out.println("{custID="+custID + " ,password=" + pwd+"}");
        System.out.println("-----------------------------------------------------");
        ModelAndView mv = new ModelAndView();
        Customer customer = customerData.getCustomerByID(custID);
        if (customer != null && customer.getPassword().equals(pwd)) {
            mv.addObject("username", customer.getUserName());
            mv.setViewName("welcome.jsp");
        } 
        else if (customer != null) {
            mv.addObject("message", "Incorrect Password/Customer ID");
            mv.setViewName("failure.jsp");
        } 
        else {
            mv.addObject("message", "Invalid Customer ID/Customer doesn't exist");
            mv.setViewName("failure.jsp");
        }
        System.out.println("-----------------------------------------------------");
        System.out.println(mv);
        System.out.println("-----------------------------------------------------");
        return mv;
    }
    
    @PostMapping("/register")
    public ModelAndView registerUser(Integer custID, String username, String pwd, String confirmpwd) {
        System.out.println("-----------------------------------------------------");
        System.out.println("{custID="+custID + " ,username=" + username + " ,password=" + pwd + " ,confirmPassword=" + confirmpwd+"}");
        System.out.println("-----------------------------------------------------");

        ModelAndView mv = new ModelAndView();
        if (!pwd.equals(confirmpwd)) {
            mv.addObject("message", "Password didn't match");
            mv.setViewName("failureReg.jsp");
        } 
        else if (customerData.findCustomer(custID)) {
            mv.addObject("message", "Customer ID already taken");
            mv.setViewName("failureReg.jsp");
        } 
        else {
            customerData.addCustomer(custID, username, pwd);
            mv.addObject("username", username);
            mv.setViewName("welcome.jsp");
        }
        System.out.println("-----------------------------------------------------");
        System.out.println(mv);
        System.out.println("-----------------------------------------------------");
        return mv;
    }
}