package ua.barkalov.callsign.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.barkalov.callsign.callsignServices.DTO.KeysDTO;
import ua.barkalov.callsign.callsignServices.KeysService;

//@Controller
//@RequestMapping("/keys")
public class KeysController {

//    private final KeysService keysService;

//    @Autowired
//    public KeysController(KeysService keysService) {
//        this.keysService = keysService;
//    }

//    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody KeysDTO get(@PathVariable("id") Long id){
//        return keysService.get(id);
//    }
}
