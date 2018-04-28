package ru.isko.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.isko.forms.UserRegistrationForm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * created by Iskander Valiev
 * on 11/25/17
 *
 * @author Iskander Valiev (Kazan Federal University Higher School of Information Technologies and Information Systems)
 * @version 1.0
 */
@Service
public class SmsServiceImpl implements SmsService {

    private ExecutorService executorService = Executors.newCachedThreadPool();

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${sms.aero.user}")
    private String smsAeroLogin;

    @Value("${sms.aero.password}")
    private String smsAeroPassword;

    @Value("${sms.aero.from}")
    private String smsAeroFrom;

    @Value("${sms.aero.type}")
    private String smsAeroType;

    @Value("${sms.aero.url}")
    private String smsAeroUri;

    @Override
    public Future<Boolean> sendMessage(UserRegistrationForm form) {
        return executorService.submit(() -> {
            String request = smsAeroUri + "?user="
                    + smsAeroLogin + "&password="
                    + smsAeroPassword + "&to="
                    + form.getTelephone() +
                    "&text=Ruzal%20pacan"
//                    + "&text=" + "World%20Cup%202018%20Russia.%20We%20are%20glad%20to%20see%20you%20in%20our%20portal.%20Your%20login:%20"
                    + form.getEmail() + "%20Password:%20" + form.getPassword()
                    + "&from="
                    + smsAeroFrom + "&type="
                    + smsAeroType;
            System.out.println("request = " + request);
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(request, String.class);
            System.out.println("response = " + responseEntity.getBody());
            if (responseEntity.getBody().contains("accepted")) {
                return true;
            } else {
                throw new IllegalArgumentException("Проблемы с номером телефона");
            }
        });
    }
}
