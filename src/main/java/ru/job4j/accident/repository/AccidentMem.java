package ru.job4j.accident.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class AccidentMem {

    public static AccidentMem INSTANCE = new AccidentMem();

    private Map<Integer, Accident> accidents = new ConcurrentHashMap<>();

    private AccidentMem() {
        accidents.put(1, new Accident(1, "Авария на мосту", "Лада гранта и Форд фокус", "ул. Первомайская, 14"));
        accidents.put(2, new Accident(2, "Авария на рынке", "Тайота камри и Лексус РИкс 200", "ул. Пушкина, 90"));
        accidents.put(3, new Accident(3, "Авария на преддомовой территории", "Хонда аккорд и Лада приора", "ул. Куфонина, 44"));
    }

    public static AccidentMem getInstance() {
        return INSTANCE;
    }

    public Collection<Accident> findAllAccidents() {
        return accidents.values();
    }
}
