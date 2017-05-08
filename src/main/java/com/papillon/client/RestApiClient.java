package com.papillon.client;

import com.papillon.datatypes.Message;
import sun.net.www.MessageHeader;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by papillon on 5/8/2017.
 */
public class RestApiClient {

    public static void main(String[] args){
        Client cli = ClientBuilder.newClient();
        WebTarget baseTarget = cli.target("http://localhost:8080/restapp/webapi");
        WebTarget messagesTarget = baseTarget.path("messages");
        WebTarget singleMessage = messagesTarget.path("{messageId}");

        Message msg = singleMessage
                .resolveTemplate("messageId","1")
                .request(MediaType.APPLICATION_JSON)
                .get(Message.class);
        //Message msg = resp.readEntity(Message.class);

        List<Message> msg2 = messagesTarget
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Message>>(){});

        System.out.println(msg2);
    }
}
