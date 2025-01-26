package it.lbsoftware.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private static final String EVIL_EMAIL_MESSAGE = """
            If you want to win money, click <a href="http://localhost:8080/submit?new-username=EVIL">here</a> now!
            """;
    private final JavaMailSender javaMailSender;

    public DemoApplication(final JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var message = javaMailSender.createMimeMessage();
        var helper = new MimeMessageHelper(message);
        helper.setSubject("Do you want to win money?");
        helper.setTo("you@email.com");
        helper.setFrom("your-evil-friend@email.com");
        helper.setText(EVIL_EMAIL_MESSAGE, true);
        javaMailSender.send(message);
    }
}
