package finalTask;

/**
 * Created by Roman Horilyi on 07.11.2016.
 */
public class MailMessage implements Sendable<String> {
    private String sender;
    private String receiver;
    private String messageText;

    public MailMessage(String sender, String receiver, String messageText) {
        this.sender = sender;
        this.receiver = receiver;
        this.messageText = messageText;
    }

    @Override
    public String getFrom() {
        return sender;
    }

    @Override
    public String getTo() {
        return receiver;
    }

    @Override
    public String getContent() {
        return messageText;
    }
}
