package ua.barkalov.callsign.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.barkalov.callsign.callsignServices.CallDataService;
import ua.barkalov.callsign.callsignServices.DTO.FindData;
import ua.barkalov.callsign.callsignServices.KeysService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/code")
public class CallDataController {

    private final CallDataService callDataService;
    private final KeysService keysService;

    @Autowired
    public CallDataController(CallDataService callDataService, KeysService keysService) {
        this.callDataService = callDataService;
        this.keysService = keysService;
    }

    @RequestMapping(method = RequestMethod.GET,
                    produces = MediaType.TEXT_PLAIN_VALUE,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String get(@RequestParam("data") String data, @RequestParam("day") Long day){
        return callDataService.getCallsign(keysService.getCoordinates(keysService.get(day), data));
    }

    @RequestMapping(method=RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody FindData getSearchUserProfiles(@RequestBody FindData findData) {
        String data = findData.getData();
        Long day = Long.valueOf(findData.getDay());

        System.out.println(findData.toString());
        System.out.println(data);
        System.out.println(findData.getDay());
        System.out.println(day);

        return new FindData(callDataService.getCallsign(keysService.getCoordinates(keysService.get(day), data)), null);
    }

//    @ModelAttribute
//    public void setResponseHeaders(HttpServletResponse response) {
//        response.setHeader("Content-Type", "application/json;charset=UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json;charset=UTF-8");
//    }
}
