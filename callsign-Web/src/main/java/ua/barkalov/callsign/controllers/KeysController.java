package ua.barkalov.callsign.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.barkalov.callsign.callsignServices.DTO.Coordinates;
import ua.barkalov.callsign.callsignServices.DTO.KeysDTO;
import ua.barkalov.callsign.callsignServices.KeysService;

@Controller
@RequestMapping("/keys")
public class KeysController {

    private final KeysService keysService;

    @Autowired
    public KeysController(KeysService keysService) {
        this.keysService = keysService;
    }

//    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody KeysDTO get(@PathVariable("id") Long id){
//        return keysService.get(id);
//    }

    @RequestMapping(value = "{data}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Coordinates get(@PathVariable("data") String data) {
        return keysService.getCoordinates(keysService.get(1L), data);
    }
}

//    KeysDTO get(Long id);
//    Coordinates getCoordinates(KeysDTO keysDTO, String data);

//@Controller
//@RequestMapping("/users")
//public class UserController {
//
//    private final UserServices userService;
//
//    private final static Logger log = LoggerFactory.getLogger(UserController.class);
//
//    @Autowired
//    public UserController(UserServices userService){
//        this.userService = userService;
//    }
//
//    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody List<UserDTO> findAll(){
//        log.info("List All Users");
//        return userService.findAll();
//    }
//

//    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody UserDTO get(@PathVariable("id") Long id) {
//        log.info("Find user by id: {}", id);
//        return userService.get(id);
//    }

//
//    @RequestMapping(value = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public void update(@PathVariable("id") Long id, @RequestBody UserDTO userDTO) {
//        log.info("Update user: {} with id: {}", userDTO, id);
//        userService.update(id, userDTO);
//    }
//
//    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.CREATED)
//    public void create(@RequestBody UserDTO user){
//        log.info("Create user: {}", user);
//        userService.create(user);
//    }
//
//    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable("id") Long id) {
//        log.info("Delete user with id: {}", id);
//        userService.delete(id);
//    }
//}
