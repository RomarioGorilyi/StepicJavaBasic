package mailingSystem.service;

import mailingSystem.sendable.Sendable;

/**
 * Created by Roman Horilyi on 09.10.2016.
 */
public class RealMailService implements MailService {
    @Override
    public Sendable processMail(Sendable mail) {
        // Здесь описан код настоящей системы отправки почты.
        return mail;
    }
}
