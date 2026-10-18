package roro.app.entity;

import roro.util.FileUpload;

public class Profil {
    private String titre;
    private FileUpload photo;
    private FileUpload[] documents;
    private Aretina aretina;

    public Profil() {
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public FileUpload getPhoto() {
        return photo;
    }

    public void setPhoto(FileUpload photo) {
        this.photo = photo;
    }

    public FileUpload[] getDocuments() {
        return documents;
    }

    public void setDocuments(FileUpload[] documents) {
        this.documents = documents;
    }

    public Aretina getAretina() {
        return aretina;
    }

    public void setAretina(Aretina aretina) {
        this.aretina = aretina;
    }
}
