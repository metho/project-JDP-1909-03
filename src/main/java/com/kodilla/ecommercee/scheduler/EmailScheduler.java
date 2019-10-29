package com.kodilla.ecommercee.scheduler;

import com.kodilla.ecommercee.config.AdminConfig;
import com.kodilla.ecommercee.domain.Mail;
import com.kodilla.ecommercee.domain.UserOrder;
import com.kodilla.ecommercee.repository.UserOrderRepository;
import com.kodilla.ecommercee.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmailScheduler {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserOrderRepository userOrderRepository;

    @Autowired
    private AdminConfig adminConfig;

    private static final String SUBJECT = "Checking for new orders every 30 min";
    private static final String FREQUENCY = "0 */30 * ? * *";

    @Scheduled(cron=FREQUENCY)
    public void sendInformationEmail() {
        List<UserOrder> orderToSend = userOrderRepository.findByMailSentFalse();
        for (UserOrder userOrder : orderToSend) {
            emailService.send(new Mail(
                    adminConfig.getAdminMail(),
                    SUBJECT,
                    "You have received  new order " + userOrder.getNumber()));
            userOrderRepository.setMailSent(userOrder.getId(), true);
        }
    }
}
