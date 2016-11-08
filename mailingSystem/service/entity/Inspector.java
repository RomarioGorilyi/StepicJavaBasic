package mailingSystem.service.entity;

import mailingSystem.mail.MailPackage;
import mailingSystem.sendable.Sendable;
import mailingSystem.exception.IllegalPackageException;
import mailingSystem.exception.StolenPackageException;
import mailingSystem.service.MailService;

/**
 * Created by Roman Horilyi on 09.10.2016.
 */
public class Inspector implements MailService {
    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            MailPackage mailPackage = (MailPackage) mail;
            String mailContent = mailPackage.getContent().getContent();
            if ((mailContent.contains("weapons")) || (mailContent.contains("banned substance"))) {
                throw new IllegalPackageException();
            } else if (mailContent.contains("stones")) {
                throw new StolenPackageException();
            }
        }

        return mail;
    }
}
