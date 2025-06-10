package com.example.sklad;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


/**
 * Класс отвечающий за функциональность (поиск, сохранение, добваление, удаление и получение по ID)
 * @version 1.0.0
 */
@Service
public class StorageService {
    @Autowired
    private StorageRepository repo;

    /**
     * Метод поиска отвечающий за возврат списка товаров по поисковому запросу
     * @param keyword - ключевое слово
     * @param filterDate - дата отгрузки
     * @return - возврат всех товаров, если остутствует ключевое слово
     */
    public List<Storage> listAll (String keyword, LocalDate filterDate){
        if (keyword != null) {
            return repo.search(keyword);
        }
        if (filterDate != null) {
            return repo.findByExportdate(filterDate);
        }
        return repo.findAll();
    }

    /**
     * Сохранение товаров в БД
     * @param storage - сущнность (класс Storage)
     */
    public void save(Storage storage) {
        repo.save(storage);
    }

    /**
     * Получение товаров по ID
     * @param id - ID товара
     * @return - возвращаем товар по ID
     */
    public Storage get(long id){
        return repo.findById(id).get();
    }

    /**
     * Удаление товара
     * @param id - ID товара
     */
    public void delete(long id) {
        repo.deleteById(id);
    }
}
