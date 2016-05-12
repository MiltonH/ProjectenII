/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Milton
 */
public class Leerling
{

    private String familienaam;

    private String voornaam;

    private Date lastEdit;

    private List<EvaluatieFormulier> evaluatieFormulieren;

    private String inschrijvingsNummer;

    private int huidigEvaluatieFormulierNr;

    private EvaluatieFormulier huidigEvaluatieFormulier;

    private List<View> views;
   
    private boolean localOnly;

    //constructor voor nieuwe leerling
    public Leerling(String familienaam, String voornaam, String inschrijvingsNummer) {
        this.familienaam = familienaam;
        this.voornaam = voornaam;
        this.evaluatieFormulieren = new ArrayList<>();
        evaluatieFormulieren.add(new EvaluatieFormulier(this));
        this.inschrijvingsNummer = inschrijvingsNummer;
        this.huidigEvaluatieFormulierNr = 0;
        this.views = new ArrayList<>();
        this.huidigEvaluatieFormulier = evaluatieFormulieren.get(huidigEvaluatieFormulierNr);
        this.lastEdit = new Date();
        this.localOnly = true;
    }

    public Leerling() {
        this.views = new ArrayList<>();
        this.evaluatieFormulieren = new ArrayList<>();
        this.localOnly = false;
    }

    public void volgendFormulier() {
        if (huidigEvaluatieFormulierNr < 2) {
            EvaluatieFormulier form = new EvaluatieFormulier(this);
            form.kopieerFormulier(huidigEvaluatieFormulier);
            evaluatieFormulieren.add(form);
            huidigEvaluatieFormulierNr++;
            huidigEvaluatieFormulier = evaluatieFormulieren.get(huidigEvaluatieFormulierNr);
        }
    }

    public String getInschrijvingsNummer() {
        return inschrijvingsNummer;
    }

    public void setInschrijvingsNummer(String inschrijvingsNummer) {
        this.inschrijvingsNummer = inschrijvingsNummer;
    }

    public Date getLastEdit() {
        return lastEdit;
    }

    public void setLastEdit(Date lastEdit) {
        this.lastEdit = lastEdit;
    }

    public boolean isLocalOnly() {
        return localOnly;
    }

    public void setLocalOnly(boolean localOnly) {
        this.localOnly = localOnly;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public void setFamilienaam(String familienaam) {
        this.familienaam = familienaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public List<EvaluatieFormulier> getEvaluatieFormulieren() {
        return evaluatieFormulieren;
    }

    public EvaluatieFormulier getHuidigEvaluatieFormulier() {
        return huidigEvaluatieFormulier;
    }

    public void setHuidigEvaluatieFormulierNr() {
        this.huidigEvaluatieFormulierNr = evaluatieFormulieren.size() - 1;
    }

    public void setHuidigEvaluatieFormulier() {
        this.huidigEvaluatieFormulier = evaluatieFormulieren.get(huidigEvaluatieFormulierNr);
    }

    public int getHuidigEvaluatieFormulierNr() {
        return huidigEvaluatieFormulierNr;
    }

    public List<View> getViews() {
        return views;
    }

    public void addView(View view) {
        views.add(view);
    }

    public void removeView(View view) {
        views.remove(view);
    }

    public void updateLastEdit(){
        lastEdit = new Date();
    }
    public void notifyViews() {
        for (View v : views) {
            v.update();
        }       
    }
}
