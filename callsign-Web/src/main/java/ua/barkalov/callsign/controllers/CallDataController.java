package ua.barkalov.callsign.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.barkalov.callsign.callsignServices.CallDataService;
import ua.barkalov.callsign.callsignServices.DTO.FindData;
import ua.barkalov.callsign.callsignServices.KeysService;

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

    @RequestMapping(method=RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody FindData getSearchUserProfiles(@RequestBody FindData findData) {
        return new FindData(
                callDataService.getCallsign(
                        keysService.getCoordinates(
                                keysService.get(
                                        Long.valueOf(findData.getDay())),
                                findData.getData())),
                        null);
    }
}
