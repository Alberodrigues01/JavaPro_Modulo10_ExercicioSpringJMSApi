package br.com.mentorama.SpringJMS_Api.config;

import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;

@Component
public class JmsErrorHandler implements ErrorHandler {
    @Override
    public void handleError(Throwable throwable) {
        System.out.println("Erro ao processar publicação" +
                throwable.getMessage());
    }
}
