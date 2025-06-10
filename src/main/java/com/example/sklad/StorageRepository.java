package com.example.sklad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;

/**
 * Репозиторий для поиска товаров
 */
@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {
    /**
     * SQL-запрос для формирования строки по результатам поиска
     * @param keyword - ключевое слово, по которому выполняем поиск
     * @return - возвращаем список товаров
     */
    @Query("SELECT p FROM Storage p WHERE CONCAT(p.id,'',p.title,'',p.type,'', p.driver) LIKE %?1%")
    /**
     * Метод search для формирования списка по результатам запроса
     */
    List<Storage> search(String keyword);
    /**
     * Метод для формирования списка по дате отгрузки
     */
    List<Storage> findByExportdate(LocalDate exportdate);
}
