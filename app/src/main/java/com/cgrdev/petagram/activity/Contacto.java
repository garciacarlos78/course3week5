package com.cgrdev.petagram.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cgrdev.petagram.R;

public class Contacto extends AppCompatActivity {

    Button btComentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar = findViewById(R.id.contactoActionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btComentario = findViewById(R.id.btComentario);

        btComentario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviaMensaje();
            }
        });
    }

    // TODO Hacer que se envíe el correo
    //  Ya se ha modificado bundle.gradle en función de https://javaee.github.io/javamail/#JavaMail_for_Android
    public void enviaMensaje () {
        Toast.makeText(this, "Estoy enviando un mensaje, sí...", Toast.LENGTH_SHORT).show();

        // new SendMail().execute(null, null, null);

//        String to = "cuenta.chorra@hotmail.com";
//        String from = "cuenta.chorra@hotmail.com";
//        String host = "smtp.office365.com";
//
//        // create some properties and get the default Session
//        Properties props = new Properties();
//        props.put("mail.smtp.host", host);
//
//        Session session = Session.getInstance(props, null);
//
//        try {
//            // create a message
//            MimeMessage msg = new MimeMessage(session);
//            msg.setFrom(new InternetAddress(from));
//            InternetAddress[] address = {new InternetAddress(to)};
//            msg.setRecipients(Message.RecipientType.TO, address);
//            msg.setSubject("JavaMail APIs Test");
//            msg.setSentDate(new Date());
//            // If the desired charset is known, you can use
//            // setText(text, charset)
//            msg.setText("Texto del mensaje");
//
//            Transport.send(msg);
//        } catch (MessagingException mex) {
//            Log.d("Mascotas: ", "--Exception handling in msgsendsample.java");
//
//            mex.printStackTrace();
//            Exception ex = mex;
//            do {
//                if (ex instanceof SendFailedException) {
//                    SendFailedException sfex = (SendFailedException)ex;
//                    Address[] invalid = sfex.getInvalidAddresses();
//                    if (invalid != null) {
//                        Log.d("Mascotas: ", "--Exception handling in msgsendsample.java");
//                        for (int i = 0; i < invalid.length; i++) {
//                            Log.d("Mascotas: ", "--Exception handling in msgsendsample.java");
//                            Log.d("Mascotas: ", "         " + invalid[i]);
//                            }
//                    }
//                    Address[] validUnsent = sfex.getValidUnsentAddresses();
//                    if (validUnsent != null) {
//                        Log.d("Mascotas: ", "    ** ValidUnsent Addresses");
//                        for (int i = 0; i < validUnsent.length; i++)
//                            Log.d("Mascotas: ", "         "+validUnsent[i]);
//                    }
//                    Address[] validSent = sfex.getValidSentAddresses();
//                    if (validSent != null) {
//                        Log.d("Mascotas: ", "    ** ValidSent Addresses");
//                        for (int i = 0; i < validSent.length; i++)
//                            Log.d("Mascotas: ", "         "+validSent[i]);
//                    }
//                }
//                if (ex instanceof MessagingException)
//                    ex = ((MessagingException)ex).getNextException();
//                else
//                    ex = null;
//            } while (ex != null);
//        }

//        Properties props = new Properties();
//        props.put("mail.smtp.host", "smtp.office365.com");
//        Session session = Session.getInstance(props, null);
//
//        try {
//            MimeMessage msg = new MimeMessage(session);
//            msg.setFrom("cuenta.chorra@hotmail.com");
//            msg.setRecipients(Message.RecipientType.TO,
//                    "cuenta.chorra@hotmail.com");
//            msg.setSubject("JavaMail hello world example");
//            msg.setSentDate(new Date());
//            msg.setText("Hello, world!\n");
//            Transport.send(msg, "cuenta.chorra@hotmail.com", "");
//        } catch (MessagingException mex) {
//            System.out.println("send failed, exception: " + mex);
//        }
    }
}
