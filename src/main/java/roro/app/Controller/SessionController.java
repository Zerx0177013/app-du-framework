package roro.app.Controller;

import roro.annotation.Auth;
import roro.annotation.MonController;
import roro.annotation.UrlMapping;
import roro.util.ModAndView;
import roro.util.MySession;

@MonController
public class SessionController {

    @UrlMapping(value = "/api/session/login-page", method = "GET")
    public ModAndView loginPage() {
        ModAndView mav = new ModAndView();
        mav.setView("login");
        return mav;
    }

    @UrlMapping(value = "/api/session/login", method = "GET")
    public ModAndView login(String username, MySession session) {
        session.setAttribute("user", username);
        ModAndView mav = new ModAndView();
        mav.setView("home");
        return mav;
    }

    @UrlMapping(value = "/api/session/me", method = "GET")
    public String me(MySession session) {
        Object user = session.getAttribute("user");
        return user == null ? "Personne n'est connecté" : "Utilisateur en session : " + user;
    }

    @Auth
    @UrlMapping(value = "/api/session/hello", method = "GET")
    public String hello(MySession session) {
        return "hello " + session.getAttribute("user");
    }


    @UrlMapping(value = "/api/session/logout", method = "GET")
    public String logout(MySession session) {
        session.removeAttribute("user");
        return "Déconnecté";
    }
}
