/**
 *
 *
 * Class RealEstateController which will handle requests for web application.
 * In this class, we create methods that will return our views in response to requests.
 */

package org.realestate.controller;

import org.realestate.model.RealEstate;
import org.realestate.service.RealEstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Spring MVC has a DispatcherServlet. This is the main controller.
 * All incoming requests go through him and he then passes them on to a specific controller.
 * The @Controller annotation tells Spring MVC that a given class is a controller.
 * The dispatcher will check the @RequestMapping annotations to call the appropriate method.
 * The @RequestMapping annotation allows you to set the addresses of the controller methods by which they
 * will be available in the client (browser).
 */
@Controller
public class RealEstateController {

    /**
     * Let's add a service and call its methods.
     */
    private final RealEstateService realEstateService;

    /**
     * It is not recommended to use auto-linking on the field, it is better to use constructor or setter.
     * @param realEstateService is the service class object.
     */
    @Autowired
    public RealEstateController(RealEstateService realEstateService) {
        this.realEstateService = realEstateService;
    }

    /**
     * Here we create main page of our real estate web application.
     * Method for displaying the main page with a list of real estate.
     * We get a list of movies from the service and add it to the model
     * @return ModelAndView object.
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView allRealEstates() {
        List<RealEstate> realEstates = realEstateService.allRealEstates();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("realEstatesList", realEstates);
        return modelAndView;
    }

    /**
     * A method that will return the edit page for a specific real estate object.
     * The @PathVariable annotation indicates that this parameter (int id) is obtained from the address bar.
     * To indicate the location of this parameter in the address bar, use the {id} construction.
     * @param id is the serial number of the real estate object.
     * @return ModelAndView object.
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        RealEstate realEstate = realEstateService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("realEstate", realEstate);
        return modelAndView;
    }

    /**
     * Above was the method for getting the edit page, now you need a method for the edit itself.
     * In the editPage method, we added an attribute to the model. And now with the @ModelAttribute annotation we
     * get this attribute and can change it. POST request method, because this is where we will be passing data.
     * "redirect: /" means that after executing this method we will be redirected to the address "/",
     * ie the allRealEstates method will run and we will return to the main page.
     * @param realEstate is the real estate object.
     * @return ModelAndView object.
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editRealEstate(@ModelAttribute("realEstate") RealEstate realEstate) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        realEstateService.edit(realEstate);
        return modelAndView;
    }

    /**
     * Method for getting the page for adding an object.
     * @return ModelAndView object.
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    /**
     * Method to add object.
     * @param realEstate is real estate objest.
     * @return ModelAndView object.
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addRealEstate(@ModelAttribute("realEstate") RealEstate realEstate) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        realEstateService.add(realEstate);
        return modelAndView;
    }

    /**
     * Method to delete object.
     * @param id is the serial number of the real estate object.
     * @return ModelAndView object.
     */
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteRealEstate(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        RealEstate realEstate = realEstateService.getById(id);
        realEstateService.delete(realEstate);
        return modelAndView;
    }
}