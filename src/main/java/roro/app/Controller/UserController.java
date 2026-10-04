package roro.app.Controller;

import org.springframework.context.ApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import roro.annotation.MonController;
import roro.annotation.Rest;
import roro.annotation.UrlMapping;
import roro.app.entity.User;
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

    @Rest
    @UrlMapping(value = "/api/rest/liste", method = "GET")
    public String list(ApplicationContext ctx) {
        String json;
        if (ctx == null) {
            System.err.println("Le moteur Spring n'est pas démarré !");
            return "Erreur : le moteur Spring n'est pas démarré !";
        }
        UserService userService = ctx.getBean(UserService.class);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            json = objectMapper.writeValueAsString(userService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return "Erreur lors de la conversion en JSON";
        }
        return json;
    }

    @Rest
    @UrlMapping(value = "/api/rest/user1", method = "GET")
    public User getUser1(ApplicationContext ctx) {
        if (ctx == null) {
            System.err.println("Le moteur Spring n'est pas démarré !");
            return null;
        }
        UserService userService = ctx.getBean(UserService.class);
        return userService.findById((long) 1);
    }

    @UrlMapping(value = "/api/user/form", method = "GET")
    public ModAndView getForm(ApplicationContext ctx) {
        ModAndView mav = new ModAndView();
        mav.setView("form");
        return mav;
    }

    @UrlMapping(value = "/api/user/save", method = "POST")
    public String saveUser(String username, String mail, ApplicationContext ctx) {
        UserService userService = ctx.getBean(UserService.class);

        User user = new User();
        user.setUsername(username);
        user.setEmail(mail);

        userService.save(user);

        return "message : Utilisateur enregistré";
    }

    @UrlMapping(value = "/api/user/save1", method = "POST")
    public String saveUser1(User user, ApplicationContext ctx) {
        UserService userService = ctx.getBean(UserService.class);

        userService.save(user);

        return "message : Utilisateur enregistré";
    }
}
