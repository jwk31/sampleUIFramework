package com.obtaincare.UI.mailosaur;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.SearchCriteria;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class EmailTest {

    public String apiKey = "PSkj5zNMOMRkMsvp";
    public String serverId = "sv5g8zu3";
    public String domain = "sv5g8zu3.mailosaur.net";

    @Test
    public void testEmail() throws MailosaurException, IOException {
        MailosaurClient mailosaurClient = new MailosaurClient(apiKey);

        SearchCriteria searchCriteria = new SearchCriteria();

        searchCriteria.withSentFrom("jwk103110@gmail.com");
        searchCriteria.withSubject("Test3");

        Message message = mailosaurClient.messages().get(serverId, searchCriteria);

        System.out.println("The subject is: " + message.subject());
        System.out.println("The content is:" + message.text().body());
        System.out.println(message.html().links().get(1));
    }
}
