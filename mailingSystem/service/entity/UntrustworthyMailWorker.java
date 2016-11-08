package mailingSystem.service.entity;

import mailingSystem.sendable.Sendable;
import mailingSystem.service.MailService;
import mailingSystem.service.RealMailService;

/**
 * Created by Roman Horilyi on 09.10.2016.
 */
public class UntrustworthyMailWorker implements MailService {
    private MailService[] mailServices;
    private RealMailService realMailService = new RealMailService();

    public UntrustworthyMailWorker(MailService[] mailServices) {
        this.mailServices = mailServices;
    }

    public RealMailService getRealMailService() {
        return realMailService;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        for (MailService mailService : mailServices) {
            mail = mailService.processMail(mail);
        }

        return getRealMailService().processMail(mail);
    }
}
