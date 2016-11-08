package mailingSystem.service.entity;

import mailingSystem.mail.MailPackage;
import mailingSystem.mail.Package;
import mailingSystem.sendable.Sendable;
import mailingSystem.service.MailService;

/**
 * Created by Roman Horilyi on 09.10.2016.
 */
public class Thief implements MailService {
    private int minValueOfPackage;
    private int stolenValue;

    public Thief(int minValueOfPackage) {
        this.minValueOfPackage = minValueOfPackage;
    }

    public int getStolenValue() {
        return stolenValue;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            MailPackage mailPackage = (MailPackage) mail;
            if (mailPackage.getContent().getPrice() >= minValueOfPackage) {
                stolenValue += mailPackage.getContent().getPrice();
                mailPackage = new MailPackage(
                        mailPackage.getFrom(),
                        mailPackage.getTo(),
                        new Package("stones instead of " + mailPackage.getContent().getContent(), 0)
                );
            }

            return mailPackage;
        }

        return mail;
    }
}
