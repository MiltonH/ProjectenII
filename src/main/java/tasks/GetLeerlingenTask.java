/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tasks;

import domain.Leerling;
import java.util.List;
import javafx.concurrent.Task;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import json.LeerlingListReader;
import tasks.exceptions.ServerException;



/**
 *
 * @author Milton
 */
//http://localhost:8080/rijschool/
public class GetLeerlingenTask extends Task<List<Leerling>>
{

    private final WebTarget userListResource;

    public GetLeerlingenTask() {
        userListResource = ClientBuilder.newClient()
                .target("http://localhost:8080/rijschool/api")
                .path("leerlingen")
                .register(LeerlingListReader.class);
    }

    @Override
    protected List<Leerling> call() throws Exception {
        Response response = userListResource.request(MediaType.APPLICATION_JSON).get();
        if (response.getStatus() == 200) {
            List<Leerling> leerlingen = response.readEntity(new GenericType<List<Leerling>>()
            {
            });
            return leerlingen;
        } else {
            throw new ServerException();
        }
    }
}
