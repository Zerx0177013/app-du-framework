package roro.app.entity;

import roro.annotation.MonController;
import roro.annotation.UrlMapping;

@MonController
public class Test3 {
    
    @UrlMapping("/banana")
    public String ted() {
        return "La banana de Mamamia";
    }
}
