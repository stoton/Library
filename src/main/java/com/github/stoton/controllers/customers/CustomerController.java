package com.github.stoton.controllers.customers;


import com.github.stoton.domain.Address;
import com.github.stoton.domain.Customer;
import com.github.stoton.repository.AddressRepository;
import com.github.stoton.repository.BookRepository;
import com.github.stoton.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private CustomerRepository<Customer> customerRepository;


    @RequestMapping("/getAll")
    public String getAllCustomer(Model model) {
        try {
            List<Customer> list = customerRepository.getAll();
            model.addAttribute("customerList", list);
            return "customerAll";

        } catch(Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping("/addCustomer")
    public String displayCustomer(CustomerForm customerForm, Model model) {
        return "addCustomer";
    }

    @PostMapping("/addCustomer")
    public String saveCustomer(CustomerForm customerForm) {
        Customer customer = customerForm.convertToCustomer();
        Address address = customerForm.getAddress();

        try {
            customerRepository.save(customer);
            addressRepository.save(address);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "redirect:/";
    }

}
