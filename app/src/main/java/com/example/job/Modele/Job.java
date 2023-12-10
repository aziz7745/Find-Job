package com.example.job.Modele;


public class Job {

    private String titre;
    private String desc;
    private String ville;
    private String domain;
    private String mail;
    private String budget;
    private  String userId;

    public Job(String desc, String domain, String mail, String titre, String ville, String userId)
    {
        this.desc = desc;
        this.domain = domain;
        this.mail=mail;
        this.titre = titre;
        this.ville = ville;
        this.userId = userId;

    }
    public Job()
    {

    }
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public String toString() {
        return  titre ;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
