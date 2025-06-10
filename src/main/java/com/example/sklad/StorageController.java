package com.example.sklad;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.time.LocalDate;
import java.util.List;

/**
 * Класс-контроллер, отвечающий за соединение логики приложения с шаблонами HTML
 * @version 1.0.0
 */

@Controller
public class StorageController {
    /**
     * Интегрируем класс StorageService для вызова методов сохранения, удаления и т.д
     */
    @Autowired
    private StorageService service;

    /**
     * Метод отвечающий за вывод главной страницы index.html
     * @param model - класс отвечающий за передачу данных из контроллера в представление (шаблоны HTML)
     * @param keyword - ключевое слово для поиска
     * @param filterDate - дата отгрузки для фильтрации
     * @return возвращаем index.html
     * @since 1.0.0
     */
    @GetMapping("/")
    public String index(Model model, @Param("keyword") String keyword,
                        @RequestParam(required = false)LocalDate filterDate) {
        List<Storage> listStorage = service.listAll(keyword, filterDate);
        model.addAttribute("listStorage", listStorage);
        model.addAttribute("keyword", keyword);
        model.addAttribute("filterDate", filterDate);
        return "index";
    }

    /**
     * Метод создания нового товара
     * @param model - класс отвечающий за передачу данных из контроллера в представление (шаблоны HTML)
     * @return - возвращаем new_storage.html
     * @since 1.0.0
     */
    @GetMapping("/new")
    public String newStorage(Model model) {
        Storage storage = new Storage();
        model.addAttribute("storage", storage);
        return "new_storage";
    }

    /**
     * Метод сохранения товара
     * @param storage - класс, отвечающий за переменные, по которым передаются данные
     * @return - редирект на главную страницу после сохранения
     * @since 1.0.0
     */
    @PostMapping(value = "/save")
    public String saveBook(@ModelAttribute("storage") Storage storage) {
        service.save(storage);
        return "redirect:/";
    }

    /**
     * Метод редактирования товара
     * @param id - ID товара
     * @return - возвращаем список из переменных класса Storage
     * @since 1.0.0
     */
    @GetMapping("edit/{id}")
    public ModelAndView editStorage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_storage");
        Storage storage = service.get(id);
        mav.addObject("storage", storage);
        return mav;
    }

    /**
     * Метод удаления товара
     * @param id - ID товара
     * @return - редирект на главную страницу после удаления
     * @since 1.0.0
     */
    @GetMapping("/delete/{id}")
    public String deleteStorage(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
