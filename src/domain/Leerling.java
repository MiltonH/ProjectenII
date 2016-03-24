/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Milton
 */
public class Leerling
{

    private String familienaam;

    private String voornaam;

    private List<EvaluatieFormulier> evaluatieFormulieren;

    private String inschrijvingsNummer;

    private int huidigEvaluatieFormulierNr;

    private EvaluatieFormulier huidigEvaluatieFormulier;

    private List<View> views;

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
    }

    public String getInschrijvingsNummer() {
        return inschrijvingsNummer;
    }

    public void setInschrijvingsNummer(String inschrijvingsNummer) {
        this.inschrijvingsNummer = inschrijvingsNummer;
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

    public void notifyViews() {
        for (View v : views) {
            v.update();
        }
    }
}
