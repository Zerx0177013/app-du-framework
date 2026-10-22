package roro.app.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.ApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import roro.annotation.MonController;
import roro.annotation.Rest;
import roro.annotation.UrlMapping;
import roro.app.entity.Profil;
import roro.app.entity.User;
import roro.app.service.UserService;
import roro.util.FileUpload;
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

    @Rest
    @UrlMapping(value = "/api/binder/user", method = "POST")
    public User binderUser(User user) {
        return user;
    }

    @UrlMapping(value = "/api/upload/form", method = "GET")
    public ModAndView getUploadForm() {
        ModAndView mav = new ModAndView();
        mav.setView("upload");
        return mav;
    }

    @Rest
    @UrlMapping(value = "/api/binder/upload", method = "POST")
    public Map<String, Object> binderUpload(Profil profil) throws IOException {
        Map<String, Object> res = new LinkedHashMap<>();
        res.put("titre", profil.getTitre());
        res.put("photo", describe(profil.getPhoto()));

        Path uploadDir = Paths.get(getProperty("upload.properties", "upload.dir"));
        Files.createDirectories(uploadDir);

        if (profil.getPhoto() != null)
            Files.write(uploadDir.resolve(profil.getPhoto().getFileName()), profil.getPhoto().getBytes());

        List<Object> docs = new ArrayList<>();
        if (profil.getDocuments() != null) {
            for (FileUpload f : profil.getDocuments()) {
                Files.write(uploadDir.resolve(f.getFileName()), f.getBytes());
                docs.add(describe(f));
            }
        }
        res.put("documents", docs);
        res.put("aretina", profil.getAretina());
        return res;
    }

    private String getProperty(String file, String key) throws IOException {
        Properties props = new Properties();
        try (InputStream in = getClass().getClassLoader().getResourceAsStream(file)) {
            if (in == null)
                throw new IOException("Fichier introuvable dans le classpath : " + file);
            props.load(in);
        }
        return props.getProperty(key);
    }

    private Map<String, Object> describe(FileUpload f) {
        if (f == null)
            return null;
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("fileName", f.getFileName());
        m.put("name", f.getName());
        m.put("extension", f.getExtension());
        m.put("contentType", f.getContentType());
        m.put("size", f.getBytes().length);
        return m;
    }

    
}
