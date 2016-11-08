package finalTask;

import java.util.*;
import java.util.function.Consumer;

/**
 * Created by Roman Horilyi on 07.11.2016.
 */
public class MailService<T> implements Consumer<Sendable<T>> {
    private Map<String, List<T>> mailBox;

    public MailService() {
        mailBox = new HashMap<>();
    }

    @Override
    public void accept(Sendable<T> tSendable) {
        String receiver = tSendable.getTo();
        T content = tSendable.getContent();
        Optional<List<T>> listOptional = Optional.ofNullable(mailBox.get(receiver));
        List<T> resultList;

        if (listOptional.isPresent()) {
            resultList = listOptional.get();
            resultList.add(content);
        } else {
            resultList = new ArrayList<>(Arrays.asList(content));
        }

        mailBox.put(receiver, resultList);
    }

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }
}
