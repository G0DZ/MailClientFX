package app.model;

import javax.mail.*;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by G0DZ on 05.05.2016.
 */
public class GConnection {
    private String userName;
    private String password;
    private String imapAddress;
    private Store store;

    public GConnection(String userName, String password, String imapAddress) {
        this.userName = userName;
        this.password = password;
        this.imapAddress = imapAddress;
    }

    public boolean connect(){
        if(!initialize())
            return false;
        try {
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            Message msg = inbox.getMessage(inbox.getMessageCount()-1);
            Address[] in = msg.getFrom();
            for (Address address : in) {
                System.out.println("FROM:" + address.toString());
            }
            //Multipart mp = (Multipart) msg.getContent();
            //BodyPart bp = mp.getBodyPart(0);
            System.out.println("SENT DATE:" + msg.getSentDate());
            System.out.println("SUBJECT:" + msg.getSubject());
            System.out.println("CONTENT:" +  msg.getContentType());
            return true;
        } //catch (IOException e1) {
            //e1.printStackTrace();
        //}
         catch (MessagingException e1) {
            //e1.printStackTrace();
        }
        return false;
    }

    private boolean initialize(){
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        Session session = Session.getInstance(props, null);
        try {
            store = session.getStore();
            store.connect(imapAddress, userName, password);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
