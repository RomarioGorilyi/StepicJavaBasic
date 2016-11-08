package mailingSystem.service;

import mailingSystem.sendable.Sendable;

/**
 * Created by Roman Horilyi on 09.10.2016.
 */
public interface MailService {
    Sendable processMail(Sendable mail);
}
