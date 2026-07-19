package roro.app.Controller;

import roro.annotation.MonController;
import roro.annotation.UrlMapping;

@MonController
public class Test1 {

    @UrlMapping(value = "/andrana", method = "POST")
    public String andrana() {
        return "Test1";
    }

    // @UrlMapping(value = "/api/andrana", method = "GET")
    // public ModAndView andrana2() {
    //     ModAndView mav = new ModAndView();
    //     mav.setView("Test1");
    //     mav.addValue("Nombre 12", 12);
    //     mav.addValue("test", "zavatra hafahafa");
    //     mav.addValue("test1", "idk what to write`");
    //     return mav;
    // }
}
