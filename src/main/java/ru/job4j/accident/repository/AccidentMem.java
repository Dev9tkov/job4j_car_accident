package ru.job4j.accident.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccidentMem {
    private Map<Integer, Accident> accidents = new ConcurrentHashMap<>();

    private static AtomicInteger ACCIDENT_ID = new AtomicInteger(3);

    public AccidentMem() {
        accidents.put(1, new Accident(1, "Авария на мосту", "Лада гранта и Форд фокус", "ул. Первомайская, 14"));
        accidents.put(2, new Accident(2, "Авария на рынке", "Тайота камри и Лексус РИкс 200", "ул. Пушкина, 90"));
        accidents.put(3, new Accident(3, "Авария на преддомовой территории", "Хонда аккорд и Лада приора", "ул. Куфонина, 44"));
    }

    public Collection<Accident> findAllAccidents() {
        return accidents.values();
    }

    public void create(Accident accident) {
        if (accident.getId() == 0) {
            accident.setId(ACCIDENT_ID.incrementAndGet());
        }
        accidents.put(accident.getId(), accident);
    }

    public Accident findById(int id) {
        return accidents.get(id);
    }
}
