package roro.app.Controller;

import org.springframework.context.ApplicationContext;

import roro.annotation.MonController;
import roro.annotation.UrlMapping;
import roro.app.service.UserService;
import roro.util.ModAndView;

@MonController
public class UserController {

    @UrlMapping(value = "/api/liste", method = "GET")
    public ModAndView listerUtilisateurs(ApplicationContext ctx) {
        ModAndView mav = new ModAndView();
        mav.setView("liste");
        if (ctx == null) {
            System.err.println("Le moteur Spring n'est pas démarré !");
            return mav;
        }
        UserService userService = ctx.getBean(UserService.class);
        mav.addValue("utilisateurs", userService.findAll());
        return mav;
    }
}
