package com.example.sklad;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Класс отвечающий за конфигурационные настройки для веб-приложения (можно регистрировать несколько контроллеров)
 * @version 1.0.0
 */

@Configuration
public class MvcConfig implements WebMvcConfigurer {


    /**
     * Метод реализации метода addViewControllers, за счёт которого можно регистрировать новые контроллеры
     * @param registry - переменная класса ViewControllerRegistry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

    }
}
