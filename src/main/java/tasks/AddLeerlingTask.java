/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tasks;

import domain.Leerling;
import javafx.concurrent.Task;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import json.LeerlingWriter;
import tasks.exceptions.BadRequestException;
import tasks.exceptions.ServerException;

/**
 *
 * @author Milton
 */
public class AddLeerlingTask extends Task<Void>
{
    private final WebTarget userListResource;
    private final Leerling leerling;
    
    public AddLeerlingTask(Leerling leerling) {
        this.leerling = leerling;
        userListResource = ClientBuilder.newClient()
                .target("http://localhost:8080/rijschool/api")
                .path("leerlingen")
                .register(LeerlingWriter.class);
    }
    
    @Override
    protected Void call() throws Exception {
        Response response = userListResource.request().post(Entity.entity(leerling, MediaType.APPLICATION_JSON));
        switch (response.getStatus()) {
            case 201:
                return null;
            case 400:
                throw new BadRequestException();
            default:
                throw new ServerException();
        }
    }
}
