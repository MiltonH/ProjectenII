/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tasks;

import domain.Leerling;
import javafx.concurrent.Task;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import tasks.exceptions.AuthException;
import tasks.exceptions.NotFoundException;
import tasks.exceptions.ServerException;

/**
 *
 * @author Milton
 */
public class DeleteLeerlingTask extends Task<Void>
{

    private final WebTarget userResource;

    public DeleteLeerlingTask(Leerling leerling) {
        userResource = ClientBuilder.newClient()
                .target("http://192.168.43.36:8080/rijschool/api/leerlingen")
                .path(leerling.getInschrijvingsNummer());
    }

    @Override
    protected Void call() throws Exception {
        Response response = userResource.request().delete();
        switch (response.getStatus()) {
            case 204:
                return null;
            case 401:
            case 403:
                throw new AuthException();
            case 404:
                throw new NotFoundException();
            default:
                throw new ServerException();
        }
    }
}
