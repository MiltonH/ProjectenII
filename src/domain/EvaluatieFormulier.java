/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;

/**
 *
 * @author Milton
 */
public class EvaluatieFormulier
{

    private int evaluatieId;

    private Evaluatie zithoudingZithouding;
    private Evaluatie zithoudingGordel;
    private Evaluatie zithoudingSpiegels;
    private Evaluatie zithoudingHandrem;
    private List<String> zithoudingAndere;

    private Evaluatie koppelingDosering;
    private Evaluatie koppelingVolledig;
    private Evaluatie koppelingVoetaf;
    private List<String> koppelingBedieningAndere;

    private Evaluatie koppelingOnnodig;
    private Evaluatie koppelingBocht;
    private List<String> koppelingGebruikAndere;

    private Evaluatie remDosering;
    private Evaluatie remVolgorde;

    private Evaluatie remTeLaat;
    private List<String> remGebruikAndere;

    private Evaluatie stuurDosering;
    private Evaluatie stuurHouding;
    private List<String> stuurAndere;

    private Evaluatie schakelDosering;
    private List<String> schakelBedieningAndere;

    private Evaluatie schakelAangepast;
    private Evaluatie schakelMotorRem;
    private List<String> schakelGebruikAndere;

    private Evaluatie kijkVergewis;
    private Evaluatie kijksSpiegels;
    private Evaluatie kijkDodeHoek;
    private Evaluatie kijkVer;
    private Evaluatie kijkSelecteren;
    private List<String> kijkAndere;

    private char hellingType;
    private Evaluatie helling;

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

    //massief aantal getter en setters
    public Evaluatie getZithoudingZithouding() {
        return zithoudingZithouding;
    }

    public void setZithoudingZithouding(Evaluatie zithoudingZithouding) {
        this.zithoudingZithouding = zithoudingZithouding;
    }

    public Evaluatie getZithoudingGordel() {
        return zithoudingGordel;
    }

    public void setZithoudingGordel(Evaluatie zithoudingGordel) {
        this.zithoudingGordel = zithoudingGordel;
    }

    public Evaluatie getZithoudingSpiegels() {
        return zithoudingSpiegels;
    }

    public void setZithoudingSpiegels(Evaluatie zithoudingSpiegels) {
        this.zithoudingSpiegels = zithoudingSpiegels;
    }

    public Evaluatie getZithoudingHandrem() {
        return zithoudingHandrem;
    }

    public void setZithoudingHandrem(Evaluatie zithoudingHandrem) {
        this.zithoudingHandrem = zithoudingHandrem;
    }

    public List<String> getZithoudingAndere() {
        return zithoudingAndere;
    }

    public void setZithoudingAndere(List<String> zithoudingAndere) {
        this.zithoudingAndere = zithoudingAndere;
    }

    public Evaluatie getKoppelingDosering() {
        return koppelingDosering;
    }

    public void setKoppelingDosering(Evaluatie koppelingDosering) {
        this.koppelingDosering = koppelingDosering;
    }

    public Evaluatie getKoppelingVolledig() {
        return koppelingVolledig;
    }

    public void setKoppelingVolledig(Evaluatie koppelingVolledig) {
        this.koppelingVolledig = koppelingVolledig;
    }

    public Evaluatie getKoppelingVoetaf() {
        return koppelingVoetaf;
    }

    public void setKoppelingVoetaf(Evaluatie koppelingVoetaf) {
        this.koppelingVoetaf = koppelingVoetaf;
    }

    public List<String> getKoppelingBedieningAndere() {
        return koppelingBedieningAndere;
    }

    public void setKoppelingBedieningAndere(List<String> koppelingBedieningAndere) {
        this.koppelingBedieningAndere = koppelingBedieningAndere;
    }

    public Evaluatie getKoppelingOnnodig() {
        return koppelingOnnodig;
    }

    public void setKoppelingOnnodig(Evaluatie koppelingOnnodig) {
        this.koppelingOnnodig = koppelingOnnodig;
    }

    public Evaluatie getKoppelingBocht() {
        return koppelingBocht;
    }

    public void setKoppelingBocht(Evaluatie koppelingBocht) {
        this.koppelingBocht = koppelingBocht;
    }

    public List<String> getKoppelingGebruikAndere() {
        return koppelingGebruikAndere;
    }

    public void setKoppelingGebruikAndere(List<String> koppelingGebruikAndere) {
        this.koppelingGebruikAndere = koppelingGebruikAndere;
    }

    public Evaluatie getRemDosering() {
        return remDosering;
    }

    public void setRemDosering(Evaluatie remDosering) {
        this.remDosering = remDosering;
    }

    public Evaluatie getRemVolgorde() {
        return remVolgorde;
    }

    public void setRemVolgorde(Evaluatie remVolgorde) {
        this.remVolgorde = remVolgorde;
    }

    public Evaluatie getRemTeLaat() {
        return remTeLaat;
    }

    public void setRemTeLaat(Evaluatie remTeLaat) {
        this.remTeLaat = remTeLaat;
    }

    public List<String> getRemGebruikAndere() {
        return remGebruikAndere;
    }

    public void setRemGebruikAndere(List<String> remGebruikAndere) {
        this.remGebruikAndere = remGebruikAndere;
    }

    public Evaluatie getStuurDosering() {
        return stuurDosering;
    }

    public void setStuurDosering(Evaluatie stuurDosering) {
        this.stuurDosering = stuurDosering;
    }

    public Evaluatie getStuurHouding() {
        return stuurHouding;
    }

    public void setStuurHouding(Evaluatie stuurHouding) {
        this.stuurHouding = stuurHouding;
    }

    public List<String> getStuurAndere() {
        return stuurAndere;
    }

    public void setStuurAndere(List<String> stuurAndere) {
        this.stuurAndere = stuurAndere;
    }

    public Evaluatie getSchakelDosering() {
        return schakelDosering;
    }

    public void setSchakelDosering(Evaluatie schakelDosering) {
        this.schakelDosering = schakelDosering;
    }

    public List<String> getSchakelBedieningAndere() {
        return schakelBedieningAndere;
    }

    public void setSchakelBedieningAndere(List<String> schakelBedieningAndere) {
        this.schakelBedieningAndere = schakelBedieningAndere;
    }

    public Evaluatie getSchakelAangepast() {
        return schakelAangepast;
    }

    public void setSchakelAangepast(Evaluatie schakelAangepast) {
        this.schakelAangepast = schakelAangepast;
    }

    public Evaluatie getSchakelMotorRem() {
        return schakelMotorRem;
    }

    public void setSchakelMotorRem(Evaluatie schakelMotorRem) {
        this.schakelMotorRem = schakelMotorRem;
    }

    public List<String> getSchakelGebruikAndere() {
        return schakelGebruikAndere;
    }

    public void setSchakelGebruikAndere(List<String> schakelGebruikAndere) {
        this.schakelGebruikAndere = schakelGebruikAndere;
    }

    public Evaluatie getKijkVergewis() {
        return kijkVergewis;
    }

    public void setKijkVergewis(Evaluatie kijkVergewis) {
        this.kijkVergewis = kijkVergewis;
    }

    public Evaluatie getKijksSpiegels() {
        return kijksSpiegels;
    }

    public void setKijksSpiegels(Evaluatie kijksSpiegels) {
        this.kijksSpiegels = kijksSpiegels;
    }

    public Evaluatie getKijkDodeHoek() {
        return kijkDodeHoek;
    }

    public void setKijkDodeHoek(Evaluatie kijkDodeHoek) {
        this.kijkDodeHoek = kijkDodeHoek;
    }

    public Evaluatie getKijkVer() {
        return kijkVer;
    }

    public void setKijkVer(Evaluatie kijkVer) {
        this.kijkVer = kijkVer;
    }

    public Evaluatie getKijkSelecteren() {
        return kijkSelecteren;
    }

    public void setKijkSelecteren(Evaluatie kijkSelecteren) {
        this.kijkSelecteren = kijkSelecteren;
    }

    public List<String> getKijkAndere() {
        return kijkAndere;
    }

    public void setKijkAndere(List<String> kijkAndere) {
        this.kijkAndere = kijkAndere;
    }

    public char getHellingType() {
        return hellingType;
    }

    public void setHellingType(char hellingType) {
        this.hellingType = hellingType;
    }

    public Evaluatie getHelling() {
        return helling;
    }

    public void setHelling(Evaluatie helling) {
        this.helling = helling;
    }

    public Evaluatie getParkerenTussen() {
        return parkerenTussen;
    }

    public void setParkerenTussen(Evaluatie parkerenTussen) {
        this.parkerenTussen = parkerenTussen;
    }

    public Evaluatie getParkerenAchter() {
        return parkerenAchter;
    }

    public void setParkerenAchter(Evaluatie parkerenAchter) {
        this.parkerenAchter = parkerenAchter;
    }

    public Evaluatie getParkerenLinks() {
        return parkerenLinks;
    }

    public void setParkerenLinks(Evaluatie parkerenLinks) {
        this.parkerenLinks = parkerenLinks;
    }

    public Evaluatie getKeren() {
        return keren;
    }

    public void setKeren(Evaluatie keren) {
        this.keren = keren;
    }

    public Evaluatie getGarageEen() {
        return garageEen;
    }

    public void setGarageEen(Evaluatie garageEen) {
        this.garageEen = garageEen;
    }

    public Evaluatie getGarageDrie() {
        return garageDrie;
    }

    public void setGarageDrie(Evaluatie garageDrie) {
        this.garageDrie = garageDrie;
    }

    public Evaluatie getGarageAchterwaarts() {
        return garageAchterwaarts;
    }

    public void setGarageAchterwaarts(Evaluatie garageAchterwaarts) {
        this.garageAchterwaarts = garageAchterwaarts;
    }

    public Evaluatie getAchteruit() {
        return achteruit;
    }

    public void setAchteruit(Evaluatie achteruit) {
        this.achteruit = achteruit;
    }

    public Evaluatie getStuurOefeningen() {
        return stuurOefeningen;
    }

    public void setStuurOefeningen(Evaluatie stuurOefeningen) {
        this.stuurOefeningen = stuurOefeningen;
    }

    public Evaluatie getRichtingAanwijzers() {
        return richtingAanwijzers;
    }

    public void setRichtingAanwijzers(Evaluatie richtingAanwijzers) {
        this.richtingAanwijzers = richtingAanwijzers;
    }

    public Evaluatie getOpenbareWeg() {
        return openbareWeg;
    }

    public void setOpenbareWeg(Evaluatie openbareWeg) {
        this.openbareWeg = openbareWeg;
    }

    public Evaluatie getVoorrang() {
        return voorrang;
    }

    public void setVoorrang(Evaluatie voorrang) {
        this.voorrang = voorrang;
    }

    public Evaluatie getVerkeerstekens() {
        return verkeerstekens;
    }

    public void setVerkeerstekens(Evaluatie verkeerstekens) {
        this.verkeerstekens = verkeerstekens;
    }

    public Evaluatie getSnelheid() {
        return snelheid;
    }

    public void setSnelheid(Evaluatie snelheid) {
        this.snelheid = snelheid;
    }

    public Evaluatie getVolgafstand() {
        return volgafstand;
    }

    public void setVolgafstand(Evaluatie volgafstand) {
        this.volgafstand = volgafstand;
    }

    public Evaluatie getInhalen() {
        return inhalen;
    }

    public void setInhalen(Evaluatie inhalen) {
        this.inhalen = inhalen;
    }

    public Evaluatie getKruisen() {
        return kruisen;
    }

    public void setKruisen(Evaluatie kruisen) {
        this.kruisen = kruisen;
    }

    public Evaluatie getLinksaf() {
        return linksaf;
    }

    public void setLinksaf(Evaluatie linksaf) {
        this.linksaf = linksaf;
    }

    public Evaluatie getRechtsaf() {
        return rechtsaf;
    }

    public void setRechtsaf(Evaluatie rechtsaf) {
        this.rechtsaf = rechtsaf;
    }

    public List<String> getRichtingAanwijzersAndere() {
        return richtingAanwijzersAndere;
    }

    public void setRichtingAanwijzersAndere(List<String> richtingAanwijzersAndere) {
        this.richtingAanwijzersAndere = richtingAanwijzersAndere;
    }

    public List<String> getOpenbareWegAndere() {
        return openbareWegAndere;
    }

    public void setOpenbareWegAndere(List<String> openbareWegAndere) {
        this.openbareWegAndere = openbareWegAndere;
    }

    public List<String> getVoorrangAndere() {
        return voorrangAndere;
    }

    public void setVoorrangAndere(List<String> voorrangAndere) {
        this.voorrangAndere = voorrangAndere;
    }

    public List<String> getVerkeerstekensAndere() {
        return verkeerstekensAndere;
    }

    public void setVerkeerstekensAndere(List<String> verkeerstekensAndere) {
        this.verkeerstekensAndere = verkeerstekensAndere;
    }

    public List<String> getSnelheidAndere() {
        return snelheidAndere;
    }

    public void setSnelheidAndere(List<String> snelheidAndere) {
        this.snelheidAndere = snelheidAndere;
    }

    public List<String> getVolgafstandAndere() {
        return volgafstandAndere;
    }

    public void setVolgafstandAndere(List<String> volgafstandAndere) {
        this.volgafstandAndere = volgafstandAndere;
    }

    public List<String> getInhalenAndere() {
        return inhalenAndere;
    }

    public void setInhalenAndere(List<String> inhalenAndere) {
        this.inhalenAndere = inhalenAndere;
    }

    public List<String> getKruisenAndere() {
        return kruisenAndere;
    }

    public void setKruisenAndere(List<String> kruisenAndere) {
        this.kruisenAndere = kruisenAndere;
    }

    public List<String> getLinksafAndere() {
        return linksafAndere;
    }

    public void setLinksafAndere(List<String> linksafAndere) {
        this.linksafAndere = linksafAndere;
    }

    public List<String> getRechtsafAndere() {
        return rechtsafAndere;
    }

    public void setRechtsafAndere(List<String> rechtsafAndere) {
        this.rechtsafAndere = rechtsafAndere;
    }

    public Evaluatie getRotonde() {
        return rotonde;
    }

    public void setRotonde(Evaluatie rotonde) {
        this.rotonde = rotonde;
    }

    public Evaluatie getRijstroken() {
        return rijstroken;
    }

    public void setRijstroken(Evaluatie rijstroken) {
        this.rijstroken = rijstroken;
    }

    public Evaluatie getStad() {
        return stad;
    }

    public void setStad(Evaluatie stad) {
        this.stad = stad;
    }

    public Evaluatie getAutosnelweg() {
        return autosnelweg;
    }

    public void setAutosnelweg(Evaluatie autosnelweg) {
        this.autosnelweg = autosnelweg;
    }

    public Evaluatie getSchakelaars() {
        return schakelaars;
    }

    public void setSchakelaars(Evaluatie schakelaars) {
        this.schakelaars = schakelaars;
    }

    public Evaluatie getVloeistoffen() {
        return vloeistoffen;
    }

    public void setVloeistoffen(Evaluatie vloeistoffen) {
        this.vloeistoffen = vloeistoffen;
    }

    public Evaluatie getBanden() {
        return banden;
    }

    public void setBanden(Evaluatie banden) {
        this.banden = banden;
    }

    public Evaluatie getTanken() {
        return tanken;
    }

    public void setTanken(Evaluatie tanken) {
        this.tanken = tanken;
    }

    public Evaluatie getGps() {
        return gps;
    }

    public void setGps(Evaluatie gps) {
        this.gps = gps;
    }

    public Evaluatie getStop() {
        return stop;
    }

    public void setStop(Evaluatie stop) {
        this.stop = stop;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public List<String> getAttitude() {
        return attitude;
    }

    public void setAttitude(List<String> attitude) {
        this.attitude = attitude;
    }

    public List<String> getOpmerkingen() {
        return opmerkingen;
    }

    public void setOpmerkingen(List<String> opmerkingen) {
        this.opmerkingen = opmerkingen;
    }

}
