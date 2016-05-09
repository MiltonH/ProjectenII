/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonString;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import tasks.AddLeerlingTask;
import tasks.GetLeerlingenTask;
import tasks.PutLeerlingTask;
import static java.lang.Math.toIntExact;

/**
 *
 * @author Milton
 */
public class LeerlingRepo
{

    private final ObservableList<Leerling> leerlingList = FXCollections.observableArrayList();

    public ObservableList<Leerling> getLeerlingList() {
        return leerlingList;
    }

    private final ExecutorService service = Executors.newSingleThreadExecutor();

    public void laadLijst() {
        leerlingList.addAll(leesFile("Leerlingen.txt"));
    }

    //download alle lln van de backend
    public void updateLeerlingList(List<Leerling> list) {
        GetLeerlingenTask task = new GetLeerlingenTask();
        task.setOnSucceeded(event -> {
            list.clear();
            list.addAll(task.getValue());
        });
        task.setOnFailed(event -> {
            System.out.println("Update failed with exception: ");
            task.getException().printStackTrace();
        });
        service.submit(task);
    }

    public void addLeerling(Leerling leerling) {
        AddLeerlingTask task = new AddLeerlingTask(leerling);
        task.setOnSucceeded(event -> {
//            leerlingList.add(leerling);
        });
        task.setOnFailed(event -> {
            System.out.println("Creation failed with exception: ");
            task.getException().printStackTrace();
        });
        service.submit(task);
    }

    public void updateLeerling(Leerling leerling) {
        PutLeerlingTask task = new PutLeerlingTask(leerling);
        task.setOnFailed(event -> {
            System.out.println("Update failed with exception: ");
            task.getException().printStackTrace();
        });
        service.submit(task);
    }

    public void synchroniseer() {

    }

    public void schrijfFile(List<Leerling> leerlingen, String fileNaam) {
        JSONObject obj = new JSONObject();
        obj.put("repo", maakJson(leerlingen));
        try (FileWriter file = new FileWriter(fileNaam)) {
            file.write(obj.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
        } catch (IOException ex) {
            Logger.getLogger(LeerlingRepo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<Leerling> leesFile(String fileNaam) {
        List<Leerling> leerlingen = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(
                    fileNaam));

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray arr = (JSONArray) jsonObject.get("repo");
            for (int i = 0; i < arr.size(); i++) {
                JSONObject JsonLeerling = (JSONObject) arr.get(i);
                Leerling leerling = new Leerling();
                leerling.setFamilienaam((String) JsonLeerling.get("familienaam"));
                leerling.setVoornaam((String) JsonLeerling.get("voornaam"));
                leerling.setInschrijvingsNummer((String) JsonLeerling.get("inschrijvingsnummer"));
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                leerling.setLastEdit(df.parse((String) JsonLeerling.get("lastEdit")));

                JSONArray jsonForms = (JSONArray) JsonLeerling.get("evaluatieformulieren");
                for (int j = 0; j < jsonForms.size(); j++) {
                    JSONObject jsonForm = (JSONObject) jsonForms.get(j);
                    EvaluatieFormulier formulier = new EvaluatieFormulier(leerling);

                    //zithouding
                    formulier.setZithoudingZithouding(Evaluatie.values()[toIntExact((long) jsonForm.get("zithoudingZithouding"))]);
                    formulier.setZithoudingGordel(Evaluatie.values()[toIntExact((long) jsonForm.get("zithoudingGordel"))]);
                    formulier.setZithoudingSpiegels(Evaluatie.values()[toIntExact((long) jsonForm.get("zithoudingSpiegels"))]);
                    formulier.setZithoudingHandrem(Evaluatie.values()[toIntExact((long) jsonForm.get("zithoudingHandrem"))]);
                    formulier.setZithoudingRec(Evaluatie.values()[toIntExact((long) jsonForm.get("zithoudingRec"))]);

                    JSONArray jsonzithoudingAnderee = (JSONArray) jsonForm.get("zithoudingAndere");
                    List<String> zithoudingAndere = new ArrayList<>();
                    if (jsonzithoudingAnderee != null) {
                        for (int zha = 0; zha < jsonzithoudingAnderee.size(); zha++) {
                            zithoudingAndere.add((String) jsonzithoudingAnderee.get(zha));
                        }
                    }
                    formulier.setZithoudingAndere(zithoudingAndere);
                    //
                    //koppeling
                    formulier.setKoppelingRec(Evaluatie.values()[toIntExact((long) jsonForm.get("koppelingRec"))]);
                    formulier.setKoppelingDosering(Evaluatie.values()[toIntExact((long) jsonForm.get("koppelingDosering"))]);
                    formulier.setKoppelingVolledig(Evaluatie.values()[toIntExact((long) jsonForm.get("koppelingVolledig"))]);
                    formulier.setKoppelingBediening(Evaluatie.values()[toIntExact((long) jsonForm.get("koppelingBediening"))]);
                    formulier.setKoppelingVoetaf(Evaluatie.values()[toIntExact((long) jsonForm.get("koppelingVoetaf"))]);

                    JSONArray jsonkoppelingBedieningAndere = (JSONArray) jsonForm.get("koppelingBedieningAndere");
                    List<String> koppelingBedieningAndere = new ArrayList<>();
                    if (jsonkoppelingBedieningAndere != null) {
                        for (int kba = 0; kba < jsonkoppelingBedieningAndere.size(); kba++) {
                            koppelingBedieningAndere.add((String) jsonkoppelingBedieningAndere.get(kba));
                        }
                    }
                    formulier.setKoppelingBedieningAndere(koppelingBedieningAndere);

                    formulier.setKoppelingOnnodig(Evaluatie.values()[toIntExact((long) jsonForm.get("koppelingOnnodig"))]);
                    formulier.setKoppelingBocht(Evaluatie.values()[toIntExact((long) jsonForm.get("koppelingBocht"))]);
                    formulier.setKoppelingGebruik(Evaluatie.values()[toIntExact((long) jsonForm.get("koppelingGebruik"))]);

                    JSONArray jsonkoppelingGebruikAndere = (JSONArray) jsonForm.get("koppelingGebruikAndere");
                    List<String> koppelingGebruikAndere = new ArrayList<>();
                    if (jsonkoppelingGebruikAndere != null) {
                        for (int kga = 0; kga < jsonkoppelingGebruikAndere.size(); kga++) {
                            koppelingGebruikAndere.add((String) jsonkoppelingGebruikAndere.get(kga));
                        }
                    }
                    formulier.setKoppelingGebruikAndere(koppelingGebruikAndere);
                    //
                    //rem
                    formulier.setRemDosering(Evaluatie.values()[toIntExact((long) jsonForm.get("remDosering"))]);
                    formulier.setRemVolgorde(Evaluatie.values()[toIntExact((long) jsonForm.get("remVolgorde"))]);
                    formulier.setRemRec(Evaluatie.values()[toIntExact((long) jsonForm.get("remRec"))]);
                    formulier.setRemTeLaat(Evaluatie.values()[toIntExact((long) jsonForm.get("remTeLaat"))]);
                    formulier.setRemBediening(Evaluatie.values()[toIntExact((long) jsonForm.get("remBediening"))]);
                    formulier.setRemGebruik(Evaluatie.values()[toIntExact((long) jsonForm.get("remGebruik"))]);

                    JSONArray jsonremGebruikAndere = (JSONArray) jsonForm.get("remGebruikAndere");
                    List<String> remGebruikAndere = new ArrayList<>();
                    if (jsonremGebruikAndere != null) {
                        for (int rga = 0; rga < jsonremGebruikAndere.size(); rga++) {
                            remGebruikAndere.add((String) jsonremGebruikAndere.get(rga));
                        }
                    }
                    formulier.setRemGebruikAndere(remGebruikAndere);
                    //
                    //stuur
                    formulier.setStuurRec(Evaluatie.values()[toIntExact((long) jsonForm.get("stuurRec"))]);
                    formulier.setStuurDosering(Evaluatie.values()[toIntExact((long) jsonForm.get("stuurDosering"))]);
                    formulier.setStuurHouding(Evaluatie.values()[toIntExact((long) jsonForm.get("stuurHouding"))]);

                    JSONArray jsonstuurAndere = (JSONArray) jsonForm.get("stuurAndere");
                    List<String> stuurAndere = new ArrayList<>();
                    if (jsonstuurAndere != null) {
                        for (int sa = 0; sa < jsonstuurAndere.size(); sa++) {
                            stuurAndere.add((String) jsonstuurAndere.get(sa));
                        }
                    }
                    formulier.setStuurAndere(stuurAndere);
                    //
                    //schakel
                    formulier.setSchakelRec(Evaluatie.values()[toIntExact((long) jsonForm.get("schakelRec"))]);
                    formulier.setSchakelBediening(Evaluatie.values()[toIntExact((long) jsonForm.get("schakelBediening"))]);
                    formulier.setSchakelDosering(Evaluatie.values()[toIntExact((long) jsonForm.get("schakelDosering"))]);

                    JSONArray jsonschakelBedieningAndere = (JSONArray) jsonForm.get("schakelBedieningAndere");
                    List<String> schakelBedieningAndere = new ArrayList<>();
                    if (jsonschakelBedieningAndere != null) {
                        for (int sba = 0; sba < jsonschakelBedieningAndere.size(); sba++) {
                            schakelBedieningAndere.add((String) jsonschakelBedieningAndere.get(sba));
                        }
                    }
                    formulier.setSchakelBedieningAndere(schakelBedieningAndere);

                    formulier.setSchakelGebruik(Evaluatie.values()[toIntExact((long) jsonForm.get("schakelGebruik"))]);
                    formulier.setSchakelAangepast(Evaluatie.values()[toIntExact((long) jsonForm.get("schakelAangepast"))]);
                    formulier.setSchakelMotorRem(Evaluatie.values()[toIntExact((long) jsonForm.get("schakelMotorRem"))]);

                    JSONArray jsonschakelGebruikAndere = (JSONArray) jsonForm.get("schakelGebruikAndere");
                    List<String> schakelGebruikAndere = new ArrayList<>();
                    if (jsonschakelGebruikAndere != null) {
                        for (int sga = 0; sga < jsonschakelGebruikAndere.size(); sga++) {
                            schakelGebruikAndere.add((String) jsonschakelGebruikAndere.get(sga));
                        }
                    }
                    formulier.setSchakelGebruikAndere(schakelGebruikAndere);
                    //
                    //kijk
                    formulier.setKijkVergewis(Evaluatie.values()[toIntExact((long) jsonForm.get("kijkVergewis"))]);
                    formulier.setKijksSpiegels(Evaluatie.values()[toIntExact((long) jsonForm.get("kijkSpiegels"))]);
                    formulier.setKijkDodeHoek(Evaluatie.values()[toIntExact((long) jsonForm.get("kijkDodeHoek"))]);
                    formulier.setKijkVer(Evaluatie.values()[toIntExact((long) jsonForm.get("kijkVer"))]);
                    formulier.setKijkSelecteren(Evaluatie.values()[toIntExact((long) jsonForm.get("kijkSelecteren"))]);
                    formulier.setKijkRec(Evaluatie.values()[toIntExact((long) jsonForm.get("kijkRec"))]);

                    JSONArray jsonkijkAndere = (JSONArray) jsonForm.get("kijkAndere");
                    List<String> kijkAndere = new ArrayList<>();
                    if (jsonkijkAndere != null) {
                        for (int ka = 0; ka < jsonkijkAndere.size(); ka++) {
                            kijkAndere.add((String) jsonkijkAndere.get(ka));
                        }
                    }
                    formulier.setKijkAndere(kijkAndere);
                    //
                    //helling
                    formulier.setHellingB(Evaluatie.values()[toIntExact((long) jsonForm.get("hellingB"))]);
                    formulier.setHellingH(Evaluatie.values()[toIntExact((long) jsonForm.get("hellingH"))]);
                    formulier.setHellingV(Evaluatie.values()[toIntExact((long) jsonForm.get("hellingV"))]);
                    //
                    //parkeren
                    formulier.setParkerenTussen(Evaluatie.values()[toIntExact((long) jsonForm.get("parkerenTussen"))]);
                    formulier.setParkerenAchter(Evaluatie.values()[toIntExact((long) jsonForm.get("parkerenAchter"))]);
                    formulier.setParkerenLinks(Evaluatie.values()[toIntExact((long) jsonForm.get("parkerenLinks"))]);
                    formulier.setKeren(Evaluatie.values()[toIntExact((long) jsonForm.get("keren"))]);
                    //
                    //garage
                    formulier.setGarageEen(Evaluatie.values()[toIntExact((long) jsonForm.get("garageEen"))]);
                    formulier.setGarageDrie(Evaluatie.values()[toIntExact((long) jsonForm.get("garageDrie"))]);
                    formulier.setGarageAchterwaarts(Evaluatie.values()[toIntExact((long) jsonForm.get("garageAchterwaarts"))]);
                    formulier.setAchteruit(Evaluatie.values()[toIntExact((long) jsonForm.get("achteruit"))]);
                    formulier.setStuurOefeningen(Evaluatie.values()[toIntExact((long) jsonForm.get("stuurOefeningen"))]);
                    //
                    //verkeerstechniek
                    formulier.setRichtingAanwijzers(Evaluatie.values()[toIntExact((long) jsonForm.get("richtingAanwijzers"))]);
                    formulier.setOpenbareWeg(Evaluatie.values()[toIntExact((long) jsonForm.get("openbareWeg"))]);
                    formulier.setVoorrang(Evaluatie.values()[toIntExact((long) jsonForm.get("voorrang"))]);
                    formulier.setVerkeerstekens(Evaluatie.values()[toIntExact((long) jsonForm.get("verkeerstekens"))]);
                    formulier.setSnelheid(Evaluatie.values()[toIntExact((long) jsonForm.get("snelheid"))]);
                    formulier.setVolgafstand(Evaluatie.values()[toIntExact((long) jsonForm.get("volgafstand"))]);
                    formulier.setInhalen(Evaluatie.values()[toIntExact((long) jsonForm.get("inhalen"))]);
                    formulier.setKruisen(Evaluatie.values()[toIntExact((long) jsonForm.get("kruisen"))]);
                    formulier.setLinksaf(Evaluatie.values()[toIntExact((long) jsonForm.get("linksaf"))]);
                    formulier.setRechtsaf(Evaluatie.values()[toIntExact((long) jsonForm.get("rechtsaf"))]);

                    JSONArray jsonrichtingAanwijzersAndere = (JSONArray) jsonForm.get("richtingAanwijzersAndere");
                    List<String> richtingAanwijzersAndere = new ArrayList<>();
                    if (jsonkijkAndere != null) {
                        for (int raa = 0; raa < jsonrichtingAanwijzersAndere.size(); raa++) {
                            richtingAanwijzersAndere.add((String) jsonrichtingAanwijzersAndere.get(raa));
                        }
                    }
                    formulier.setRichtingAanwijzersAndere(richtingAanwijzersAndere);

                    JSONArray jsonopenbareWegAndere = (JSONArray) jsonForm.get("openbareWegAndere");
                    List<String> openbareWegAndere = new ArrayList<>();
                    if (jsonopenbareWegAndere != null) {
                        for (int owa = 0; owa < jsonopenbareWegAndere.size(); owa++) {
                            openbareWegAndere.add((String) jsonopenbareWegAndere.get(owa));
                        }
                    }
                    formulier.setOpenbareWegAndere(openbareWegAndere);

                    JSONArray jsonvoorrangAndere = (JSONArray) jsonForm.get("voorrangAndere");
                    List<String> voorrangAndere = new ArrayList<>();
                    if (jsonvoorrangAndere != null) {
                        for (int va = 0; va < jsonvoorrangAndere.size(); va++) {
                            voorrangAndere.add((String) jsonvoorrangAndere.get(va));
                        }
                    }
                    formulier.setVoorrangAndere(voorrangAndere);

                    JSONArray jsonverkeerstekensAndere = (JSONArray) jsonForm.get("verkeerstekensAndere");
                    List<String> verkeerstekensAndere = new ArrayList<>();
                    if (jsonverkeerstekensAndere != null) {
                        for (int vta = 0; vta < jsonverkeerstekensAndere.size(); vta++) {
                            verkeerstekensAndere.add((String) jsonverkeerstekensAndere.get(vta));
                        }
                    }
                    formulier.setVerkeerstekensAndere(verkeerstekensAndere);

                    JSONArray jsonsnelheidAndere = (JSONArray) jsonForm.get("snelheidAndere");
                    List<String> snelheidAndere = new ArrayList<>();
                    if (jsonsnelheidAndere != null) {
                        for (int sna = 0; sna < jsonsnelheidAndere.size(); sna++) {
                            snelheidAndere.add((String) jsonsnelheidAndere.get(sna));
                        }
                    }
                    formulier.setSnelheidAndere(snelheidAndere);

                    JSONArray jsonvolgafstandAndere = (JSONArray) jsonForm.get("volgafstandAndere");
                    List<String> volgafstandAndere = new ArrayList<>();
                    if (jsonvolgafstandAndere != null) {
                        for (int voa = 0; voa < jsonvolgafstandAndere.size(); voa++) {
                            volgafstandAndere.add((String) jsonvolgafstandAndere.get(voa));
                        }
                    }
                    formulier.setVolgafstandAndere(volgafstandAndere);

                    JSONArray jsoninhalenAndere = (JSONArray) jsonForm.get("inhalenAndere");
                    List<String> inhalenAndere = new ArrayList<>();
                    if (jsoninhalenAndere != null) {
                        for (int inha = 0; inha < jsoninhalenAndere.size(); inha++) {
                            inhalenAndere.add((String) jsoninhalenAndere.get(inha));
                        }
                    }
                    formulier.setInhalenAndere(inhalenAndere);

                    JSONArray jsonkruisenAndere = (JSONArray) jsonForm.get("kruisenAndere");
                    List<String> kruisenAndere = new ArrayList<>();
                    if (jsonkruisenAndere != null) {
                        for (int inha = 0; inha < jsonkruisenAndere.size(); inha++) {
                            kruisenAndere.add((String) jsonkruisenAndere.get(inha));
                        }
                    }
                    formulier.setKruisenAndere(kruisenAndere);

                    JSONArray jsonlinksafAndere = (JSONArray) jsonForm.get("linksafAndere");
                    List<String> linksafAndere = new ArrayList<>();
                    if (jsonlinksafAndere != null) {
                        for (int laa = 0; laa < jsonlinksafAndere.size(); laa++) {
                            linksafAndere.add((String) jsonlinksafAndere.get(laa));
                        }
                    }
                    formulier.setLinksafAndere(linksafAndere);

                    JSONArray jsonrechtsafAndere = (JSONArray) jsonForm.get("rechtsafAndere");
                    List<String> rechtsafAndere = new ArrayList<>();
                    if (jsonrechtsafAndere != null) {
                        for (int rafa = 0; rafa < jsonrechtsafAndere.size(); rafa++) {
                            rechtsafAndere.add((String) jsonrechtsafAndere.get(rafa));
                        }
                    }
                    formulier.setRechtsafAndere(rechtsafAndere);
                    //
                    //hoofdscherm
                    formulier.setRotonde(Evaluatie.values()[toIntExact((long) jsonForm.get("rotonde"))]);
                    formulier.setRijstroken(Evaluatie.values()[toIntExact((long) jsonForm.get("rijstroken"))]);
                    formulier.setStad(Evaluatie.values()[toIntExact((long) jsonForm.get("stad"))]);
                    formulier.setAutosnelweg(Evaluatie.values()[toIntExact((long) jsonForm.get("autosnelweg"))]);
                    formulier.setSchakelaars(Evaluatie.values()[toIntExact((long) jsonForm.get("schakelaars"))]);
                    formulier.setVloeistoffen(Evaluatie.values()[toIntExact((long) jsonForm.get("vloeistoffen"))]);
                    formulier.setBanden(Evaluatie.values()[toIntExact((long) jsonForm.get("banden"))]);
                    formulier.setTanken(Evaluatie.values()[toIntExact((long) jsonForm.get("tanken"))]);
                    formulier.setGps(Evaluatie.values()[toIntExact((long) jsonForm.get("gps"))]);
                    formulier.setStop(Evaluatie.values()[toIntExact((long) jsonForm.get("stop"))]);

                    formulier.setNiveau(toIntExact((long) jsonForm.get("niveau")));

                    JSONArray jsonattitude = (JSONArray) jsonForm.get("attitude");
                    List<String> attitude = new ArrayList<>();
                    if (jsonattitude != null) {
                        for (int att = 0; att < jsonattitude.size(); att++) {
                            attitude.add((String) jsonattitude.get(att));
                        }
                    }
                    formulier.setAttitude(attitude);

                    JSONArray jsonopmerkingen = (JSONArray) jsonForm.get("opmerkingen");
                    List<String> opmerkingen = new ArrayList<>();
                    if (jsonopmerkingen != null) {
                        for (int opm = 0; opm < jsonopmerkingen.size(); opm++) {
                            opmerkingen.add((String) jsonopmerkingen.get(opm));
                        }
                    }
                    formulier.setOpmerkingen(opmerkingen);

                    //
                    leerling.getEvaluatieFormulieren().add(formulier);

                }
                leerling.setHuidigEvaluatieFormulierNr();
                leerling.setHuidigEvaluatieFormulier();
                leerlingen.add(leerling);
            }
            return leerlingen;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public JsonArray maakJson(List<Leerling> leerlingen) {
        JsonArrayBuilder jsonLeerlingen = Json.createArrayBuilder();

        for (Leerling l : leerlingen) {
            JsonObjectBuilder JsonLeerling = Json.createObjectBuilder();
            JsonLeerling.add("familienaam", l.getFamilienaam());
            JsonLeerling.add("voornaam", l.getVoornaam());
            JsonLeerling.add("inschrijvingsnr", l.getInschrijvingsNummer());

            DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            JsonLeerling.add("lastEdit", df.format(l.getLastEdit()));

            JsonArrayBuilder jsonEvals = Json.createArrayBuilder();

            for (EvaluatieFormulier EvalForm : l.getEvaluatieFormulieren()) {
                JsonObjectBuilder JsonFormulier = Json.createObjectBuilder();

                //zithouding
                JsonFormulier.add("zithoudingZithouding", EvalForm.getZithoudingZithouding().ordinal());
                JsonFormulier.add("zithoudingGordel", EvalForm.getZithoudingGordel().ordinal());
                JsonFormulier.add("zithoudingSpiegels", EvalForm.getZithoudingSpiegels().ordinal());
                JsonFormulier.add("zithoudingHandrem", EvalForm.getZithoudingHandrem().ordinal());
                JsonFormulier.add("zithoudingRec", EvalForm.getZithoudingRec().ordinal());
                JsonArrayBuilder jsonzithoudingAndere = Json.createArrayBuilder();
                for (String opm : EvalForm.getZithoudingAndere()) {
                    jsonzithoudingAndere.add(opm);
                }
                JsonFormulier.add("zithoudingAndere", jsonzithoudingAndere);
                //
                //koppeling
                JsonFormulier.add("koppelingRec", EvalForm.getKoppelingRec().ordinal());
                JsonFormulier.add("koppelingDosering", EvalForm.getKoppelingDosering().ordinal());
                JsonFormulier.add("koppelingVolledig", EvalForm.getKoppelingVolledig().ordinal());
                JsonFormulier.add("koppelingBediening", EvalForm.getKoppelingBediening().ordinal());
                JsonFormulier.add("koppelingVoetaf", EvalForm.getKoppelingVoetaf().ordinal());
                JsonArrayBuilder jsonkoppelingBedieningAndere = Json.createArrayBuilder();
                for (String opm : EvalForm.getKoppelingBedieningAndere()) {
                    jsonkoppelingBedieningAndere.add(opm);
                }
                JsonFormulier.add("koppelingBedieningAndere", jsonkoppelingBedieningAndere);

                JsonFormulier.add("koppelingOnnodig", EvalForm.getKoppelingVolledig().ordinal());
                JsonFormulier.add("koppelingBocht", EvalForm.getKoppelingBediening().ordinal());
                JsonFormulier.add("koppelingGebruik", EvalForm.getKoppelingVoetaf().ordinal());
                JsonArrayBuilder jsonkoppelingGebruikAndere = Json.createArrayBuilder();
                for (String opm : EvalForm.getKoppelingGebruikAndere()) {
                    jsonkoppelingGebruikAndere.add(opm);
                }
                JsonFormulier.add("koppelingBedieningAndere", jsonkoppelingGebruikAndere);
                //
                //rem
                JsonFormulier.add("remDosering", EvalForm.getRemDosering().ordinal());
                JsonFormulier.add("remVolgorde", EvalForm.getRemVolgorde().ordinal());
                JsonFormulier.add("remRec", EvalForm.getRemRec().ordinal());
                JsonFormulier.add("remTeLaat", EvalForm.getRemTeLaat().ordinal());
                JsonFormulier.add("remBediening", EvalForm.getRemBediening().ordinal());
                JsonFormulier.add("remGebruik", EvalForm.getRemGebruik().ordinal());
                JsonArrayBuilder jsonremGebruikAndere = Json.createArrayBuilder();
                for (String opm : EvalForm.getRemGebruikAndere()) {
                    jsonremGebruikAndere.add(opm);
                }
                JsonFormulier.add("remGebruikAndere", jsonremGebruikAndere);
                //
                //stuur
                JsonFormulier.add("stuurRec", EvalForm.getStuurRec().ordinal());
                JsonFormulier.add("stuurDosering", EvalForm.getStuurDosering().ordinal());
                JsonFormulier.add("stuurHouding", EvalForm.getStuurHouding().ordinal());
                JsonArrayBuilder jsonstuurAndere = Json.createArrayBuilder();
                for (String opm : EvalForm.getStuurAndere()) {
                    jsonstuurAndere.add(opm);
                }
                JsonFormulier.add("stuurAndere", jsonstuurAndere);
                //
                //schakel
                JsonFormulier.add("schakelRec", EvalForm.getSchakelRec().ordinal());
                JsonFormulier.add("schakelBediening", EvalForm.getSchakelBediening().ordinal());
                JsonFormulier.add("schakelDosering", EvalForm.getSchakelDosering().ordinal());
                JsonArrayBuilder jsonschakelBedieningAndere = Json.createArrayBuilder();
                for (String opm : EvalForm.getSchakelBedieningAndere()) {
                    jsonschakelBedieningAndere.add(opm);
                }
                JsonFormulier.add("schakelBedieningAndere", jsonschakelBedieningAndere);

                JsonFormulier.add("schakelGebruik", EvalForm.getSchakelGebruik().ordinal());
                JsonFormulier.add("schakelAangepast", EvalForm.getSchakelAangepast().ordinal());
                JsonFormulier.add("schakelMotorRem", EvalForm.getSchakelMotorRem().ordinal());
                JsonArrayBuilder jsonschakelGebruikAndere = Json.createArrayBuilder();
                for (String opm : EvalForm.getSchakelGebruikAndere()) {
                    jsonschakelGebruikAndere.add(opm);
                }
                JsonFormulier.add("schakelGebruikAndere", jsonschakelGebruikAndere);
                //
                //kijk
                JsonFormulier.add("kijkVergewis", EvalForm.getKijkVergewis().ordinal());
                JsonFormulier.add("kijkSpiegels", EvalForm.getKijksSpiegels().ordinal());
                JsonFormulier.add("kijkDodeHoek", EvalForm.getKijkDodeHoek().ordinal());
                JsonFormulier.add("kijkVer", EvalForm.getKijkVer().ordinal());
                JsonFormulier.add("kijkSelecteren", EvalForm.getKijkSelecteren().ordinal());
                JsonFormulier.add("kijkRec", EvalForm.getKijkRec().ordinal());
                JsonArrayBuilder jsonkijkAndere = Json.createArrayBuilder();
                for (String opm : EvalForm.getKijkAndere()) {
                    jsonkijkAndere.add(opm);
                }
                JsonFormulier.add("kijkAndere", jsonkijkAndere);
                //
                //helling
                JsonFormulier.add("hellingB", EvalForm.getHellingB().ordinal());
                JsonFormulier.add("hellingH", EvalForm.getHellingH().ordinal());
                JsonFormulier.add("hellingV", EvalForm.getHellingV().ordinal());
                //
                //parkeren
                JsonFormulier.add("parkerenTussen", EvalForm.getParkerenTussen().ordinal());
                JsonFormulier.add("parkerenAchter", EvalForm.getParkerenAchter().ordinal());
                JsonFormulier.add("parkerenLinks", EvalForm.getParkerenLinks().ordinal());
                JsonFormulier.add("keren", EvalForm.getKeren().ordinal());
                //
                //garage
                JsonFormulier.add("garageEen", EvalForm.getGarageEen().ordinal());
                JsonFormulier.add("garageDrie", EvalForm.getGarageDrie().ordinal());
                JsonFormulier.add("garageAchterwaarts", EvalForm.getGarageAchterwaarts().ordinal());
                JsonFormulier.add("achteruit", EvalForm.getAchteruit().ordinal());
                JsonFormulier.add("stuurOefeningen", EvalForm.getStuurOefeningen().ordinal());
                //
                //verkeerstechniek
                JsonFormulier.add("richtingAanwijzers", EvalForm.getRichtingAanwijzers().ordinal());
                JsonFormulier.add("openbareWeg", EvalForm.getOpenbareWeg().ordinal());
                JsonFormulier.add("voorrang", EvalForm.getVoorrang().ordinal());
                JsonFormulier.add("verkeerstekens", EvalForm.getVerkeerstekens().ordinal());
                JsonFormulier.add("snelheid", EvalForm.getSnelheid().ordinal());
                JsonFormulier.add("volgafstand", EvalForm.getVolgafstand().ordinal());
                JsonFormulier.add("inhalen", EvalForm.getInhalen().ordinal());
                JsonFormulier.add("kruisen", EvalForm.getKruisen().ordinal());
                JsonFormulier.add("linksaf", EvalForm.getLinksaf().ordinal());
                JsonFormulier.add("rechtsaf", EvalForm.getRechtsaf().ordinal());

                JsonArrayBuilder jsonrichtingAanwijzersAndere = Json.createArrayBuilder();
                for (String opm : EvalForm.getRichtingAanwijzersAndere()) {
                    jsonrichtingAanwijzersAndere.add(opm);
                }
                JsonFormulier.add("richtingAanwijzersAndere", jsonrichtingAanwijzersAndere);

                JsonArrayBuilder jsonopenbareWegAndere = Json.createArrayBuilder();
                for (String opm : EvalForm.getOpenbareWegAndere()) {
                    jsonopenbareWegAndere.add(opm);
                }
                JsonFormulier.add("openbareWegAndere", jsonopenbareWegAndere);

                JsonArrayBuilder jsonvoorrangAndere = Json.createArrayBuilder();
                for (String opm : EvalForm.getVoorrangAndere()) {
                    jsonvoorrangAndere.add(opm);
                }
                JsonFormulier.add("voorrangAndere", jsonvoorrangAndere);

                JsonArrayBuilder jsonverkeerstekensAndere = Json.createArrayBuilder();
                for (String opm : EvalForm.getVerkeerstekensAndere()) {
                    jsonverkeerstekensAndere.add(opm);
                }
                JsonFormulier.add("verkeerstekensAndere", jsonverkeerstekensAndere);

                JsonArrayBuilder jsonsnelheidAndere = Json.createArrayBuilder();
                for (String opm : EvalForm.getSnelheidAndere()) {
                    jsonsnelheidAndere.add(opm);
                }
                JsonFormulier.add("snelheidAndere", jsonsnelheidAndere);

                JsonArrayBuilder jsonvolgafstandAndere = Json.createArrayBuilder();
                for (String opm : EvalForm.getVolgafstandAndere()) {
                    jsonvolgafstandAndere.add(opm);
                }
                JsonFormulier.add("volgafstandAndere", jsonvolgafstandAndere);

                JsonArrayBuilder jsoninhalenAndere = Json.createArrayBuilder();
                for (String opm : EvalForm.getInhalenAndere()) {
                    jsoninhalenAndere.add(opm);
                }
                JsonFormulier.add("inhalenAndere", jsoninhalenAndere);

                JsonArrayBuilder jsonkruisenAndere = Json.createArrayBuilder();
                for (String opm : EvalForm.getKruisenAndere()) {
                    jsonkruisenAndere.add(opm);
                }
                JsonFormulier.add("kruisenAndere", jsonkruisenAndere);

                JsonArrayBuilder jsonlinksafAndere = Json.createArrayBuilder();
                for (String opm : EvalForm.getLinksafAndere()) {
                    jsonlinksafAndere.add(opm);
                }
                JsonFormulier.add("linksafAndere", jsonlinksafAndere);

                JsonArrayBuilder jsonrechtsafAndere = Json.createArrayBuilder();
                for (String opm : EvalForm.getRechtsafAndere()) {
                    jsonrechtsafAndere.add(opm);
                }
                JsonFormulier.add("rechtsafAndere", jsonrechtsafAndere);
                //
                //hoofdscherm
                JsonFormulier.add("rotonde", EvalForm.getRotonde().ordinal());
                JsonFormulier.add("rijstroken", EvalForm.getRijstroken().ordinal());
                JsonFormulier.add("stad", EvalForm.getStad().ordinal());
                JsonFormulier.add("autosnelweg", EvalForm.getAutosnelweg().ordinal());
                JsonFormulier.add("schakelaars", EvalForm.getSchakelaars().ordinal());
                JsonFormulier.add("vloeistoffen", EvalForm.getVloeistoffen().ordinal());
                JsonFormulier.add("banden", EvalForm.getBanden().ordinal());
                JsonFormulier.add("tanken", EvalForm.getTanken().ordinal());
                JsonFormulier.add("gps", EvalForm.getGps().ordinal());
                JsonFormulier.add("stop", EvalForm.getStop().ordinal());
                JsonFormulier.add("niveau", EvalForm.getNiveau());

                JsonArrayBuilder jsonattitude = Json.createArrayBuilder();
                for (String opm : EvalForm.getAttitude()) {
                    jsonattitude.add(opm);
                }
                JsonFormulier.add("attitude", jsonattitude);

                JsonArrayBuilder jsonopmerkingen = Json.createArrayBuilder();
                for (String opm : EvalForm.getOpmerkingen()) {
                    jsonopmerkingen.add(opm);
                }
                JsonFormulier.add("opmerkingen", jsonopmerkingen);
                //

                jsonEvals.add(JsonFormulier);
            }

            JsonLeerling.add("evaluatieformulieren", jsonEvals);

            jsonLeerlingen.add(JsonLeerling);
        }
        return jsonLeerlingen.build();
    }

    public void shutdown() {
        service.shutdown();
//        schrijfFile(leerlingList, "Leerlingen.txt");
    }
}
