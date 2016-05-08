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
public class EvaluatieFormulier
{

    private Leerling leerling;

    public EvaluatieFormulier(Leerling leerling) {
        this.leerling = leerling;
        this.achteruit = Evaluatie.WIT;
        this.attitude = new ArrayList<>();
        this.autosnelweg = Evaluatie.WIT;
        this.banden = Evaluatie.WIT;;
        this.garageAchterwaarts = Evaluatie.WIT;
        this.garageDrie = Evaluatie.WIT;;
        this.garageEen = Evaluatie.WIT;;
        this.gps = Evaluatie.WIT;;
        this.hellingB = Evaluatie.WIT;
        this.hellingH = Evaluatie.WIT;
        this.hellingV = Evaluatie.WIT;
        this.inhalen = Evaluatie.WIT;
        this.inhalenAndere = new ArrayList<>();
        this.keren = Evaluatie.WIT;
        this.kijkAndere = new ArrayList<>();
        this.kijkDodeHoek = Evaluatie.WIT;
        this.kijkSelecteren = Evaluatie.WIT;
        this.kijkVer = Evaluatie.WIT;
        this.kijkVergewis = Evaluatie.WIT;
        this.kijksSpiegels = Evaluatie.WIT;
        this.koppelingBedieningAndere = new ArrayList<>();
        this.koppelingBocht = Evaluatie.WIT;
        this.koppelingDosering = Evaluatie.WIT;
        this.koppelingGebruikAndere = new ArrayList<>();
        this.koppelingOnnodig = Evaluatie.WIT;
        this.koppelingVoetaf = Evaluatie.WIT;
        this.koppelingVolledig = Evaluatie.WIT;
        this.kruisen = Evaluatie.WIT;
        this.kruisenAndere = new ArrayList<>();
        this.linksaf = Evaluatie.WIT;
        this.linksafAndere = new ArrayList<>();
        this.niveau = 0;
        this.openbareWeg = Evaluatie.WIT;
        this.openbareWegAndere = new ArrayList<>();
        this.opmerkingen = new ArrayList<>();
        this.parkerenAchter = Evaluatie.WIT;
        this.parkerenLinks = Evaluatie.WIT;
        this.parkerenTussen = Evaluatie.WIT;
        this.rijstroken = Evaluatie.WIT;
        this.rechtsaf = Evaluatie.WIT;
        this.rechtsafAndere = new ArrayList<>();
        this.remDosering = Evaluatie.WIT;
        this.remGebruikAndere = new ArrayList<>();
        this.remTeLaat = Evaluatie.WIT;
        this.remVolgorde = Evaluatie.WIT;
        this.richtingAanwijzers = Evaluatie.WIT;
        this.richtingAanwijzersAndere = new ArrayList<>();
        this.rotonde = Evaluatie.WIT;
        this.schakelAangepast = Evaluatie.WIT;
        this.schakelBedieningAndere = new ArrayList<>();
        this.schakelDosering = Evaluatie.WIT;
        this.schakelGebruikAndere = new ArrayList<>();
        this.schakelMotorRem = Evaluatie.WIT;
        this.schakelaars = Evaluatie.WIT;
        this.snelheid = Evaluatie.WIT;
        this.snelheidAndere = new ArrayList<>();
        this.stad = Evaluatie.WIT;
        this.stop = Evaluatie.WIT;
        this.stuurAndere = new ArrayList<>();
        this.stuurDosering = Evaluatie.WIT;
        this.stuurHouding = Evaluatie.WIT;
        this.stuurOefeningen = Evaluatie.WIT;
        this.tanken = Evaluatie.WIT;
        this.verkeerstekens = Evaluatie.WIT;
        this.verkeerstekensAndere = new ArrayList<>();
        this.vloeistoffen = Evaluatie.WIT;
        this.volgafstand = Evaluatie.WIT;
        this.volgafstandAndere = new ArrayList<>();
        this.voorrang = Evaluatie.WIT;
        this.voorrangAndere = new ArrayList<>();
        this.zithoudingAndere = new ArrayList<>();
        this.zithoudingGordel = Evaluatie.WIT;
        this.zithoudingHandrem = Evaluatie.WIT;
        this.zithoudingSpiegels = Evaluatie.WIT;
        this.zithoudingZithouding = Evaluatie.WIT;
        this.koppelingGebruik = Evaluatie.WIT;
        this.koppelingBediening = Evaluatie.WIT;
        this.koppelingRec = Evaluatie.WIT;
        this.remRec = Evaluatie.WIT;
        this.remGebruik = Evaluatie.WIT;
        this.remBediening = Evaluatie.WIT;
        this.kijkRec = Evaluatie.WIT;
        this.stuurRec = Evaluatie.WIT;
        this.schakelBediening = Evaluatie.WIT;
        this.schakelGebruik = Evaluatie.WIT;
        this.schakelRec = Evaluatie.WIT;
        this.zithoudingRec = Evaluatie.WIT;
    }

    private int evaluatieId;

    private Evaluatie zithoudingZithouding;
    private Evaluatie zithoudingGordel;
    private Evaluatie zithoudingSpiegels;
    private Evaluatie zithoudingHandrem;
    private Evaluatie zithoudingRec;
    private List<String> zithoudingAndere;

    private Evaluatie koppelingRec;
    private Evaluatie koppelingDosering;
    private Evaluatie koppelingVolledig;
    private Evaluatie koppelingVoetaf;
    private Evaluatie koppelingBediening;
    private List<String> koppelingBedieningAndere;

    private Evaluatie koppelingOnnodig;
    private Evaluatie koppelingBocht;
    private Evaluatie koppelingGebruik;
    private List<String> koppelingGebruikAndere;

    private Evaluatie remRec;
    private Evaluatie remDosering;
    private Evaluatie remVolgorde;

    private Evaluatie remTeLaat;
    private Evaluatie remBediening;
    private Evaluatie remGebruik;
    private List<String> remGebruikAndere;

    private Evaluatie stuurRec;
    private Evaluatie stuurDosering;
    private Evaluatie stuurHouding;
    private List<String> stuurAndere;

    private Evaluatie schakelRec;
    private Evaluatie schakelBediening;
    private Evaluatie schakelDosering;
    private List<String> schakelBedieningAndere;

    private Evaluatie schakelGebruik;
    private Evaluatie schakelAangepast;
    private Evaluatie schakelMotorRem;
    private List<String> schakelGebruikAndere;

    private Evaluatie kijkVergewis;
    private Evaluatie kijksSpiegels;
    private Evaluatie kijkDodeHoek;
    private Evaluatie kijkVer;
    private Evaluatie kijkSelecteren;
    private Evaluatie kijkRec;
    private List<String> kijkAndere;

    private Evaluatie hellingB;
    private Evaluatie hellingH;
    private Evaluatie hellingV;

    private Evaluatie parkerenTussen;
    private Evaluatie parkerenAchter;
    private Evaluatie parkerenLinks;

    private Evaluatie keren;

    private Evaluatie garageEen;
    private Evaluatie garageDrie;
    private Evaluatie garageAchterwaarts;

    private Evaluatie achteruit;

    private Evaluatie stuurOefeningen;

    //verkeerstechniek
    private Evaluatie richtingAanwijzers;
    private Evaluatie openbareWeg;
    private Evaluatie voorrang;
    private Evaluatie verkeerstekens;
    private Evaluatie snelheid;
    private Evaluatie volgafstand;
    private Evaluatie inhalen;
    private Evaluatie kruisen;
    private Evaluatie linksaf;
    private Evaluatie rechtsaf;

    private List<String> richtingAanwijzersAndere;
    private List<String> openbareWegAndere;
    private List<String> voorrangAndere;
    private List<String> verkeerstekensAndere;
    private List<String> snelheidAndere;
    private List<String> volgafstandAndere;
    private List<String> inhalenAndere;
    private List<String> kruisenAndere;
    private List<String> linksafAndere;
    private List<String> rechtsafAndere;
    //hoofdscherm
    private Evaluatie rotonde;
    private Evaluatie rijstroken;
    private Evaluatie stad;
    private Evaluatie autosnelweg;
    private Evaluatie schakelaars;
    private Evaluatie vloeistoffen;
    private Evaluatie banden;
    private Evaluatie tanken;
    private Evaluatie gps;
    private Evaluatie stop;
    //niveau
    private int niveau;

    //attitude
    private List<String> attitude;

    //opmerkingen
    private List<String> opmerkingen;

    public void kopieerFormulier(EvaluatieFormulier formulier) {
        this.achteruit = formulier.getAchteruit();
        this.attitude = formulier.getAttitude();
        this.autosnelweg = formulier.getAutosnelweg();
        this.banden = formulier.getBanden();
        this.garageAchterwaarts = formulier.garageAchterwaarts;
        this.garageDrie = formulier.garageDrie;
        this.garageEen = formulier.garageEen;
        this.gps = formulier.getGps();
        this.hellingB = formulier.getHellingB();
        this.hellingH = formulier.getHellingH();
        this.hellingV = formulier.getHellingV();
        this.inhalen = formulier.getInhalen();
        this.inhalenAndere = formulier.inhalenAndere;
        this.keren = formulier.getKeren();
        this.kijkAndere = formulier.getKijkAndere();
        this.kijkDodeHoek = formulier.getKijkDodeHoek();
        this.kijkSelecteren = formulier.getKijkSelecteren();
        this.kijkVer = formulier.getKijkVer();
        this.kijkVergewis = formulier.getKijkVergewis();
        this.kijksSpiegels = formulier.kijksSpiegels;
        this.koppelingBedieningAndere = formulier.getKoppelingBedieningAndere();
        this.koppelingBocht = formulier.getKoppelingBocht();
        this.koppelingDosering = formulier.koppelingDosering;
        this.koppelingGebruikAndere = formulier.getKoppelingGebruikAndere();
        this.koppelingOnnodig = formulier.getKoppelingOnnodig();
        this.koppelingVoetaf = formulier.getKoppelingVoetaf();
        this.koppelingVolledig = formulier.getKoppelingVolledig();
        this.kruisen = formulier.getKruisen();
        this.kruisenAndere = formulier.getKruisenAndere();
        this.linksaf = formulier.getLinksaf();
        this.linksafAndere = formulier.getLinksafAndere();
        this.niveau = formulier.getNiveau();
        this.openbareWeg = formulier.getOpenbareWeg();
        this.openbareWegAndere = formulier.getOpenbareWegAndere();
        this.opmerkingen = formulier.getOpmerkingen();
        this.parkerenAchter = formulier.getParkerenAchter();
        this.parkerenLinks = formulier.getParkerenLinks();
        this.parkerenTussen = formulier.getParkerenTussen();
        this.rechtsaf = formulier.getRechtsaf();
        this.rechtsafAndere = formulier.getRechtsafAndere();
        this.remDosering = formulier.getRemDosering();
        this.remGebruikAndere = formulier.getRemGebruikAndere();
        this.remTeLaat = formulier.getRemTeLaat();
        this.remVolgorde = formulier.getRemVolgorde();
        this.richtingAanwijzers = formulier.getRichtingAanwijzers();
        this.richtingAanwijzersAndere = formulier.getRichtingAanwijzersAndere();
        this.rotonde = formulier.getRotonde();
        this.schakelAangepast = formulier.getSchakelAangepast();
        this.schakelBedieningAndere = formulier.getSchakelBedieningAndere();
        this.schakelDosering = formulier.getSchakelDosering();
        this.schakelGebruikAndere = formulier.getSchakelGebruikAndere();
        this.schakelMotorRem = formulier.getSchakelMotorRem();
        this.schakelaars = formulier.getSchakelaars();
        this.snelheid = formulier.getSnelheid();
        this.snelheidAndere = formulier.getSnelheidAndere();
        this.stad = formulier.getStad();
        this.stop = formulier.getStop();
        this.stuurAndere = formulier.getStuurAndere();
        this.stuurDosering = formulier.getStuurDosering();
        this.stuurHouding = formulier.getStuurHouding();
        this.stuurOefeningen = formulier.getStuurOefeningen();
        this.tanken = formulier.getTanken();
        this.verkeerstekens = formulier.getVerkeerstekens();
        this.verkeerstekensAndere = formulier.getVerkeerstekensAndere();
        this.vloeistoffen = formulier.getVloeistoffen();
        this.volgafstand = formulier.getVolgafstand();
        this.volgafstandAndere = formulier.getVolgafstandAndere();
        this.voorrang = formulier.getVoorrang();
        this.voorrangAndere = formulier.getVoorrangAndere();
        this.zithoudingAndere = formulier.getZithoudingAndere();
        this.zithoudingGordel = formulier.getZithoudingGordel();
        this.zithoudingHandrem = formulier.getZithoudingHandrem();
        this.zithoudingSpiegels = formulier.getZithoudingSpiegels();
        this.zithoudingZithouding = formulier.getZithoudingZithouding();
        this.koppelingGebruik = formulier.getKoppelingGebruik();
        this.koppelingBediening = formulier.getKoppelingBediening();
        this.koppelingRec = formulier.getKoppelingRec();
        this.remRec = formulier.getRemRec();
        this.remGebruik = formulier.getRemGebruik();
        this.remBediening = formulier.getRemBediening();
        this.kijkRec = formulier.getKijkRec();
        this.stuurRec = formulier.getStuurRec();
        this.schakelBediening = formulier.getSchakelBediening();
        this.schakelGebruik = formulier.getSchakelGebruik();
        this.schakelRec = formulier.getSchakelRec();
        this.zithoudingRec = formulier.getZithoudingRec();
    }

    //massief aantal getter en setters

    public Evaluatie getZithoudingRec() {
        return zithoudingRec;
    }

    public void setZithoudingRec(Evaluatie zithoudingRec) {
        this.zithoudingRec = zithoudingRec;
    }

    
    public Evaluatie getSchakelRec() {
        return schakelRec;
    }

    public void setSchakelRec(Evaluatie schakelRec) {
        this.schakelRec = schakelRec;
    }

    public Evaluatie getSchakelBediening() {
        return schakelBediening;
    }

    public void setSchakelBediening(Evaluatie schakelBediening) {
        this.schakelBediening = schakelBediening;
    }

    public Evaluatie getSchakelGebruik() {
        return schakelGebruik;
    }

    public void setSchakelGebruik(Evaluatie schakelGebruik) {
        this.schakelGebruik = schakelGebruik;
    }
    
    
    public Evaluatie getStuurRec() {
        return stuurRec;
    }

    public void setStuurRec(Evaluatie stuurRec) {
        this.stuurRec = stuurRec;
    }

    public Evaluatie getKijkRec() {
        return kijkRec;
    }

    public void setKijkRec(Evaluatie kijkRec) {
        this.kijkRec = kijkRec;
    }

    public Evaluatie getRemBediening() {
        return remBediening;
    }

    public void setRemBediening(Evaluatie remBediening) {
        this.remBediening = remBediening;
    }

    public Evaluatie getRemGebruik() {
        return remGebruik;
    }

    public void setRemGebruik(Evaluatie remGebruik) {
        this.remGebruik = remGebruik;
    }

    public Evaluatie getRemRec() {
        return remRec;
    }

    public void setRemRec(Evaluatie remRec) {
        this.remRec = remRec;
    }

    public Evaluatie getKoppelingRec() {
        return koppelingRec;
    }

    public void setKoppelingRec(Evaluatie koppelingRec) {
        this.koppelingRec = koppelingRec;
    }

    public Evaluatie getKoppelingBediening() {
        return koppelingBediening;
    }

    public void setKoppelingBediening(Evaluatie koppelingBediening) {
        this.koppelingBediening = koppelingBediening;
    }

    public Evaluatie getKoppelingGebruik() {
        return koppelingGebruik;
    }

    public void setKoppelingGebruik(Evaluatie koppelingGebruik) {
        this.koppelingGebruik = koppelingGebruik;
    }

    public Evaluatie getHellingB() {
        return hellingB;
    }

    public void setHellingB(Evaluatie hellingB) {
        this.hellingB = hellingB;
        leerling.notifyViews();
    }

    public Evaluatie getHellingH() {
        return hellingH;
    }

    public void setHellingH(Evaluatie hellingH) {
        this.hellingH = hellingH;
        leerling.notifyViews();
    }

    public Evaluatie getHellingV() {
        return hellingV;
    }

    public void setHellingV(Evaluatie hellingV) {
        this.hellingV = hellingV;
        leerling.notifyViews();
    }

    public Evaluatie getZithoudingZithouding() {
        return zithoudingZithouding;
    }

    public void setZithoudingZithouding(Evaluatie zithoudingZithouding) {
        this.zithoudingZithouding = zithoudingZithouding;
        leerling.notifyViews();
    }

    public Evaluatie getZithoudingGordel() {
        return zithoudingGordel;
    }

    public void setZithoudingGordel(Evaluatie zithoudingGordel) {
        this.zithoudingGordel = zithoudingGordel;
        leerling.notifyViews();
    }

    public Evaluatie getZithoudingSpiegels() {
        return zithoudingSpiegels;
    }

    public void setZithoudingSpiegels(Evaluatie zithoudingSpiegels) {
        this.zithoudingSpiegels = zithoudingSpiegels;
        leerling.notifyViews();
    }

    public Evaluatie getZithoudingHandrem() {
        return zithoudingHandrem;
    }

    public void setZithoudingHandrem(Evaluatie zithoudingHandrem) {
        this.zithoudingHandrem = zithoudingHandrem;
        leerling.notifyViews();
    }

    public List<String> getZithoudingAndere() {
        return zithoudingAndere;
    }

    public void setZithoudingAndere(List<String> zithoudingAndere) {
        this.zithoudingAndere = zithoudingAndere;
        leerling.notifyViews();
    }

    public Evaluatie getKoppelingDosering() {
        return koppelingDosering;
    }

    public void setKoppelingDosering(Evaluatie koppelingDosering) {
        this.koppelingDosering = koppelingDosering;
        leerling.notifyViews();
    }

    public Evaluatie getKoppelingVolledig() {
        return koppelingVolledig;
    }

    public void setKoppelingVolledig(Evaluatie koppelingVolledig) {
        this.koppelingVolledig = koppelingVolledig;
        leerling.notifyViews();
    }

    public Evaluatie getKoppelingVoetaf() {
        return koppelingVoetaf;
    }

    public void setKoppelingVoetaf(Evaluatie koppelingVoetaf) {
        this.koppelingVoetaf = koppelingVoetaf;
        leerling.notifyViews();
    }

    public List<String> getKoppelingBedieningAndere() {
        return koppelingBedieningAndere;
    }

    public void setKoppelingBedieningAndere(List<String> koppelingBedieningAndere) {
        this.koppelingBedieningAndere = koppelingBedieningAndere;
        leerling.notifyViews();
    }

    public Evaluatie getKoppelingOnnodig() {
        return koppelingOnnodig;
    }

    public void setKoppelingOnnodig(Evaluatie koppelingOnnodig) {
        this.koppelingOnnodig = koppelingOnnodig;
        leerling.notifyViews();
    }

    public Evaluatie getKoppelingBocht() {
        return koppelingBocht;
    }

    public void setKoppelingBocht(Evaluatie koppelingBocht) {
        this.koppelingBocht = koppelingBocht;
        leerling.notifyViews();
    }

    public List<String> getKoppelingGebruikAndere() {
        return koppelingGebruikAndere;
    }

    public void setKoppelingGebruikAndere(List<String> koppelingGebruikAndere) {
        this.koppelingGebruikAndere = koppelingGebruikAndere;
        leerling.notifyViews();
    }

    public Evaluatie getRemDosering() {
        return remDosering;
    }

    public void setRemDosering(Evaluatie remDosering) {
        this.remDosering = remDosering;
        leerling.notifyViews();
    }

    public Evaluatie getRemVolgorde() {
        return remVolgorde;
    }

    public void setRemVolgorde(Evaluatie remVolgorde) {
        this.remVolgorde = remVolgorde;
        leerling.notifyViews();
    }

    public Evaluatie getRemTeLaat() {
        return remTeLaat;
    }

    public void setRemTeLaat(Evaluatie remTeLaat) {
        this.remTeLaat = remTeLaat;
        leerling.notifyViews();
    }

    public List<String> getRemGebruikAndere() {
        return remGebruikAndere;
    }

    public void setRemGebruikAndere(List<String> remGebruikAndere) {
        this.remGebruikAndere = remGebruikAndere;
        leerling.notifyViews();
    }

    public Evaluatie getStuurDosering() {
        return stuurDosering;
    }

    public void setStuurDosering(Evaluatie stuurDosering) {
        this.stuurDosering = stuurDosering;
        leerling.notifyViews();
    }

    public Evaluatie getStuurHouding() {
        return stuurHouding;
    }

    public void setStuurHouding(Evaluatie stuurHouding) {
        this.stuurHouding = stuurHouding;
        leerling.notifyViews();
    }

    public List<String> getStuurAndere() {
        return stuurAndere;
    }

    public void setStuurAndere(List<String> stuurAndere) {
        this.stuurAndere = stuurAndere;
        leerling.notifyViews();
    }

    public Evaluatie getSchakelDosering() {
        return schakelDosering;
    }

    public void setSchakelDosering(Evaluatie schakelDosering) {
        this.schakelDosering = schakelDosering;
        leerling.notifyViews();
    }

    public List<String> getSchakelBedieningAndere() {
        return schakelBedieningAndere;
    }

    public void setSchakelBedieningAndere(List<String> schakelBedieningAndere) {
        this.schakelBedieningAndere = schakelBedieningAndere;
        leerling.notifyViews();
    }

    public Evaluatie getSchakelAangepast() {
        return schakelAangepast;
    }

    public void setSchakelAangepast(Evaluatie schakelAangepast) {
        this.schakelAangepast = schakelAangepast;
        leerling.notifyViews();
    }

    public Evaluatie getSchakelMotorRem() {
        return schakelMotorRem;
    }

    public void setSchakelMotorRem(Evaluatie schakelMotorRem) {
        this.schakelMotorRem = schakelMotorRem;
        leerling.notifyViews();
    }

    public List<String> getSchakelGebruikAndere() {
        return schakelGebruikAndere;
    }

    public void setSchakelGebruikAndere(List<String> schakelGebruikAndere) {
        this.schakelGebruikAndere = schakelGebruikAndere;
        leerling.notifyViews();
    }

    public Evaluatie getKijkVergewis() {
        return kijkVergewis;
    }

    public void setKijkVergewis(Evaluatie kijkVergewis) {
        this.kijkVergewis = kijkVergewis;
        leerling.notifyViews();
    }

    public Evaluatie getKijksSpiegels() {
        return kijksSpiegels;
    }

    public void setKijksSpiegels(Evaluatie kijksSpiegels) {
        this.kijksSpiegels = kijksSpiegels;
        leerling.notifyViews();
    }

    public Evaluatie getKijkDodeHoek() {
        return kijkDodeHoek;
    }

    public void setKijkDodeHoek(Evaluatie kijkDodeHoek) {
        this.kijkDodeHoek = kijkDodeHoek;
        leerling.notifyViews();
    }

    public Evaluatie getKijkVer() {
        return kijkVer;
    }

    public void setKijkVer(Evaluatie kijkVer) {
        this.kijkVer = kijkVer;
        leerling.notifyViews();
    }

    public Evaluatie getKijkSelecteren() {
        return kijkSelecteren;
    }

    public void setKijkSelecteren(Evaluatie kijkSelecteren) {
        this.kijkSelecteren = kijkSelecteren;
        leerling.notifyViews();
    }

    public List<String> getKijkAndere() {
        return kijkAndere;
    }

    public void setKijkAndere(List<String> kijkAndere) {
        this.kijkAndere = kijkAndere;
        leerling.notifyViews();
    }

    public Evaluatie getParkerenTussen() {
        return parkerenTussen;
    }

    public void setParkerenTussen(Evaluatie parkerenTussen) {
        this.parkerenTussen = parkerenTussen;
        leerling.notifyViews();
    }

    public Evaluatie getParkerenAchter() {
        return parkerenAchter;
    }

    public void setParkerenAchter(Evaluatie parkerenAchter) {
        this.parkerenAchter = parkerenAchter;
        leerling.notifyViews();
    }

    public Evaluatie getParkerenLinks() {
        return parkerenLinks;
    }

    public void setParkerenLinks(Evaluatie parkerenLinks) {
        this.parkerenLinks = parkerenLinks;
        leerling.notifyViews();
    }

    public Evaluatie getKeren() {
        return keren;
    }

    public void setKeren(Evaluatie keren) {
        this.keren = keren;
        leerling.notifyViews();
    }

    public Evaluatie getGarageEen() {
        return garageEen;
    }

    public void setGarageEen(Evaluatie garageEen) {
        this.garageEen = garageEen;
        leerling.notifyViews();
    }

    public Evaluatie getGarageDrie() {
        return garageDrie;
    }

    public void setGarageDrie(Evaluatie garageDrie) {
        this.garageDrie = garageDrie;
        leerling.notifyViews();
    }

    public Evaluatie getGarageAchterwaarts() {
        return garageAchterwaarts;
    }

    public void setGarageAchterwaarts(Evaluatie garageAchterwaarts) {
        this.garageAchterwaarts = garageAchterwaarts;
        leerling.notifyViews();
    }

    public Evaluatie getAchteruit() {
        return achteruit;
    }

    public void setAchteruit(Evaluatie achteruit) {
        this.achteruit = achteruit;
        leerling.notifyViews();
    }

    public Evaluatie getStuurOefeningen() {
        return stuurOefeningen;
    }

    public void setStuurOefeningen(Evaluatie stuurOefeningen) {
        this.stuurOefeningen = stuurOefeningen;
        leerling.notifyViews();
    }

    public Evaluatie getRichtingAanwijzers() {
        return richtingAanwijzers;
    }

    public void setRichtingAanwijzers(Evaluatie richtingAanwijzers) {
        this.richtingAanwijzers = richtingAanwijzers;
        leerling.notifyViews();
    }

    public Evaluatie getOpenbareWeg() {
        return openbareWeg;
    }

    public void setOpenbareWeg(Evaluatie openbareWeg) {
        this.openbareWeg = openbareWeg;
        leerling.notifyViews();
    }

    public Evaluatie getVoorrang() {
        return voorrang;
    }

    public void setVoorrang(Evaluatie voorrang) {
        this.voorrang = voorrang;
        leerling.notifyViews();
    }

    public Evaluatie getVerkeerstekens() {
        return verkeerstekens;
    }

    public void setVerkeerstekens(Evaluatie verkeerstekens) {
        this.verkeerstekens = verkeerstekens;
        leerling.notifyViews();
    }

    public Evaluatie getSnelheid() {
        return snelheid;
    }

    public void setSnelheid(Evaluatie snelheid) {
        this.snelheid = snelheid;
        leerling.notifyViews();
    }

    public Evaluatie getVolgafstand() {
        return volgafstand;
    }

    public void setVolgafstand(Evaluatie volgafstand) {
        this.volgafstand = volgafstand;
        leerling.notifyViews();
    }

    public Evaluatie getInhalen() {
        return inhalen;
    }

    public void setInhalen(Evaluatie inhalen) {
        this.inhalen = inhalen;
        leerling.notifyViews();
    }

    public Evaluatie getKruisen() {
        return kruisen;
    }

    public void setKruisen(Evaluatie kruisen) {
        this.kruisen = kruisen;
        leerling.notifyViews();
    }

    public Evaluatie getLinksaf() {
        return linksaf;
    }

    public void setLinksaf(Evaluatie linksaf) {
        this.linksaf = linksaf;
        leerling.notifyViews();
    }

    public Evaluatie getRechtsaf() {
        return rechtsaf;
    }

    public void setRechtsaf(Evaluatie rechtsaf) {
        this.rechtsaf = rechtsaf;
        leerling.notifyViews();
    }

    public List<String> getRichtingAanwijzersAndere() {
        return richtingAanwijzersAndere;
    }

    public void setRichtingAanwijzersAndere(List<String> richtingAanwijzersAndere) {
        this.richtingAanwijzersAndere = richtingAanwijzersAndere;
        leerling.notifyViews();
    }

    public List<String> getOpenbareWegAndere() {
        return openbareWegAndere;
    }

    public void setOpenbareWegAndere(List<String> openbareWegAndere) {
        this.openbareWegAndere = openbareWegAndere;
        leerling.notifyViews();
    }

    public List<String> getVoorrangAndere() {
        return voorrangAndere;
    }

    public void setVoorrangAndere(List<String> voorrangAndere) {
        this.voorrangAndere = voorrangAndere;
        leerling.notifyViews();
    }

    public List<String> getVerkeerstekensAndere() {
        return verkeerstekensAndere;
    }

    public void setVerkeerstekensAndere(List<String> verkeerstekensAndere) {
        this.verkeerstekensAndere = verkeerstekensAndere;
        leerling.notifyViews();
    }

    public List<String> getSnelheidAndere() {
        return snelheidAndere;
    }

    public void setSnelheidAndere(List<String> snelheidAndere) {
        this.snelheidAndere = snelheidAndere;
        leerling.notifyViews();
    }

    public List<String> getVolgafstandAndere() {
        return volgafstandAndere;
    }

    public void setVolgafstandAndere(List<String> volgafstandAndere) {
        this.volgafstandAndere = volgafstandAndere;
        leerling.notifyViews();
    }

    public List<String> getInhalenAndere() {
        return inhalenAndere;
    }

    public void setInhalenAndere(List<String> inhalenAndere) {
        this.inhalenAndere = inhalenAndere;
        leerling.notifyViews();
    }

    public List<String> getKruisenAndere() {
        return kruisenAndere;
    }

    public void setKruisenAndere(List<String> kruisenAndere) {
        this.kruisenAndere = kruisenAndere;
        leerling.notifyViews();
    }

    public List<String> getLinksafAndere() {
        return linksafAndere;
    }

    public void setLinksafAndere(List<String> linksafAndere) {
        this.linksafAndere = linksafAndere;
        leerling.notifyViews();
    }

    public List<String> getRechtsafAndere() {
        return rechtsafAndere;
    }

    public void setRechtsafAndere(List<String> rechtsafAndere) {
        this.rechtsafAndere = rechtsafAndere;
        leerling.notifyViews();
    }

    public Evaluatie getRotonde() {
        return rotonde;
    }

    public void setRotonde(Evaluatie rotonde) {
        this.rotonde = rotonde;
        leerling.notifyViews();
    }

    public Evaluatie getRijstroken() {
        return rijstroken;
    }

    public void setRijstroken(Evaluatie rijstroken) {
        this.rijstroken = rijstroken;
        leerling.notifyViews();
    }

    public Evaluatie getStad() {
        return stad;

    }

    public void setStad(Evaluatie stad) {
        this.stad = stad;
        leerling.notifyViews();
    }

    public Evaluatie getAutosnelweg() {
        return autosnelweg;
    }

    public void setAutosnelweg(Evaluatie autosnelweg) {
        this.autosnelweg = autosnelweg;
        leerling.notifyViews();
    }

    public Evaluatie getSchakelaars() {
        return schakelaars;
    }

    public void setSchakelaars(Evaluatie schakelaars) {
        this.schakelaars = schakelaars;
        leerling.notifyViews();
    }

    public Evaluatie getVloeistoffen() {
        return vloeistoffen;
    }

    public void setVloeistoffen(Evaluatie vloeistoffen) {
        this.vloeistoffen = vloeistoffen;
        leerling.notifyViews();
    }

    public Evaluatie getBanden() {
        return banden;
    }

    public void setBanden(Evaluatie banden) {
        this.banden = banden;
        leerling.notifyViews();
    }

    public Evaluatie getTanken() {
        return tanken;
    }

    public void setTanken(Evaluatie tanken) {
        this.tanken = tanken;
        leerling.notifyViews();
    }

    public Evaluatie getGps() {
        return gps;
    }

    public void setGps(Evaluatie gps) {
        this.gps = gps;
        leerling.notifyViews();
    }

    public Evaluatie getStop() {
        return stop;
    }

    public void setStop(Evaluatie stop) {
        this.stop = stop;
        leerling.notifyViews();
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
        leerling.notifyViews();
    }

    public List<String> getAttitude() {
        return attitude;
    }

    public void setAttitude(List<String> attitude) {
        this.attitude = attitude;
        leerling.notifyViews();
    }

    public List<String> getOpmerkingen() {
        return opmerkingen;
    }

    public void setOpmerkingen(List<String> opmerkingen) {
        this.opmerkingen = opmerkingen;
        leerling.notifyViews();
    }

}
