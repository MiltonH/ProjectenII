/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tasks.AddLeerlingTask;
import tasks.GetLeerlingenTask;

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

    public void updateList() {
        GetLeerlingenTask task = new GetLeerlingenTask();
        task.setOnSucceeded(event -> {
            leerlingList.clear();
            leerlingList.addAll(task.getValue());
        });
        task.setOnFailed(event -> {
            System.out.println("Update failed with exception: ");
            task.getException().printStackTrace();
        });
        service.submit(task);
    }
    
    public void addUser(Leerling leerling) {
        AddLeerlingTask task = new AddLeerlingTask(leerling);
        task.setOnSucceeded(event -> {
            leerlingList.add(leerling);
        });
        task.setOnFailed(event -> {
            System.out.println("Creation failed with exception: ");
            task.getException().printStackTrace();
        });
        service.submit(task);
    }

    public void shutdown() {
        service.shutdown();
    }
}
