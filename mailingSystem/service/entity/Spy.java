package mailingSystem.service.entity;

import mailingSystem.mail.MailMessage;
import mailingSystem.sendable.Sendable;
import mailingSystem.service.MailService;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Roman Horilyi on 09.10.2016.
 */
public class Spy implements MailService {
    private Logger logger;

    public Spy(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailMessage) {
            MailMessage message = (MailMessage) mail;
            String sender = message.getFrom();
            String recipient = message.getTo();
            if ((sender.equals("Austin Powers")) || (recipient.equals("Austin Powers"))) {
                logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                        new Object[] {sender, recipient, message.getMessage()});
            } else {
                logger.log(Level.INFO, "Usual correspondence: from {0} to {1}", new Object[] {sender, recipient});
            }
        }

        return mail;
    }
}
