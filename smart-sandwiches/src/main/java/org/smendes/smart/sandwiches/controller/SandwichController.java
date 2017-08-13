package org.smendes.smart.sandwiches.controller;

import java.util.List;

import org.smendes.smart.sandwiches.entity.Sandwich;
import org.smendes.smart.sandwiches.service.SandwichService;
import org.smendes.smart.sandwiches.to.SandwichInputTO;
import org.smendes.smart.sandwiches.to.SandwichOutputTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller responsavel por expor as APIs rest.
 * @author mendes
 *
 */
@RestController
public class SandwichController {
 
	@Autowired
	SandwichService sandwichService;
	
    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index.html");
    }
    
    /**
     * Calcular o valor do sanduiche
     * @param Recheios do sandwiche
     * @return {@link ResponseEntity}
     */
    @RequestMapping(value = "/sandwiches/calculate/", method = RequestMethod.POST)
    public ResponseEntity<?> calculate(@RequestBody List<SandwichInputTO> to) {
    	
    	SandwichOutputTO sandwich = sandwichService.calculateValue(to);
    	return new ResponseEntity<>(sandwich, HttpStatus.OK);
    }

    
}
