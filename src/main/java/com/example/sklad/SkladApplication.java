package com.example.sklad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Класс отвечающий за запуск веб-приложения
 * @version 1.0.0
 */

@SpringBootApplication
public class SkladApplication extends SpringBootServletInitializer {

	/**
	 * Главный метод запуска класса
	 * @param args аргументы запуска (массив строк)
	 * @since 1.0.0
	 */
	public static void main(String[] args) {
		SpringApplication.run(SkladApplication.class, args);
	}

}
