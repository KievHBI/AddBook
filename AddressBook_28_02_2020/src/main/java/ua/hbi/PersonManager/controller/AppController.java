package ua.hbi.PersonManager.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.hbi.PersonManager.model.Address;
import ua.hbi.PersonManager.model.Contact;
import ua.hbi.PersonManager.model.Person;
import ua.hbi.PersonManager.service.AddressService;
import ua.hbi.PersonManager.service.ContactService;
import ua.hbi.PersonManager.service.PersonService;


import java.util.List;

@Controller
public class AppController {

    @Autowired
    private PersonService service;

    @Autowired
    private AddressService addressService;

    @Autowired
    private ContactService contactService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Person> listPersons = service.listAll();
        model.addAttribute("listPerson", listPersons);
        return "index";
    }
    @RequestMapping("/new")
    public String showNewPersonForm(Model model) {
        Person person = new Person();
        Address address = new Address();
        Contact contact = new Contact();

        model.addAttribute("contact", contact);
        model.addAttribute("address", address);
        model.addAttribute("person", person);

        return "new_person"; // the name of template html file
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savePerson(
            @ModelAttribute("person") Person person,
            @ModelAttribute("address") Address address,
            @ModelAttribute("contact") Contact contact){

        person.setAddress(address);
        person.setContact(contact);

        addressService.saveAddress(address);
        contactService.saveContact(contact);
        service.save(person);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditPerson(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_person"); // the name of template html file
        Person person = service.get(id);

        mav.addObject("person", person);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deletePerson(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
