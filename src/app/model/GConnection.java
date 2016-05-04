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

    public GConnection(String userName, String password, String imapAddress) {
        this.userName = userName;
        this.password = password;
        this.imapAddress = imapAddress;
    }

    public boolean connect(){
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        try{
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect(imapAddress, userName, password);
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            Message msg = inbox.getMessage(inbox.getMessageCount());
            Address[] in = msg.getFrom();
            for (Address address : in) {
                System.out.println("FROM:" + address.toString());
            }
            Multipart mp = (Multipart) msg.getContent();
            BodyPart bp = mp.getBodyPart(0);
            System.out.println("SENT DATE:" + msg.getSentDate());
            System.out.println("SUBJECT:" + msg.getSubject());
            System.out.println("CONTENT:" + bp.getContent());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return true;
    }
}
