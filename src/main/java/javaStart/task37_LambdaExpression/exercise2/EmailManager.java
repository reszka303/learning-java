package javaStart.task37_LambdaExpression.exercise2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class EmailManager {
    public static void main(String[] args) {
        List<Email> emailList = createEmailList();
        printLine(">>>Only sent emails");
        List<Email> sentEmails = filterEmails(emailList, email -> email.isSent());
        consumeList(sentEmails, email -> printLine("" + email));
        printLine("");
        printLine(">>>Sender or recipient having an indicated email address");
        List<Email> senderOrRecipient = filterEmails(emailList,
                email -> email.isSenderOrRecipient("bart@example.com"));
        consumeList(senderOrRecipient, email -> printLine("" + email));
    }

    private static <T> void consumeList(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }

    private static <T> List<T> filterEmails(List<T> list, Predicate<T> predicate) {
        List<T> filteredEmails = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                filteredEmails.add(t);
            }
        }
        return filteredEmails;
    }

    private static List<Email> createEmailList() {
        List<Email> emails = new ArrayList<>();
        emails.add(new Email(
                "joe@example.com",
                "barbara@example.com",
                "Kup bułki",
                "Cześć!, Kup proszę bułki, gdy będziesz wracać z pracy.",
                false)
        );
        emails.add(new Email(
                "carl@example.com",
                "joe@example.com",
                "Nowa inwestycja",
                "Siema! Musimy omówić temat nowej inwestycji, pasuje Ci jutro?",
                true)
        );
        emails.add(new Email(
                "joe@example.com",
                "bart@example.com",
                "Wypad na miasto",
                "Cześć. Idziemy dzisiaj wieczorem z chłopakami na miasto. Dołączasz do nas?",
                true)
        );
        return emails;
    }

    private static void printLine(String text) {
        System.out.println(text);
    }
}
