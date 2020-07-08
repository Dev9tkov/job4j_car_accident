package ru.job4j.accident.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.job4j.accident.model.Accident;

import java.util.List;
import java.util.Optional;

@Repository
public class AccidentHibernate {

    private final SessionFactory sf;

    public AccidentHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    public void save(Accident accident) {
        try (Session session = sf.openSession()) {
            session.save(accident);
        }
    }

    public List<Accident> getAll() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from Accident", Accident.class)
                    .list();
        }
    }

    public Optional<Accident> findById(int id) {
        Optional<Accident> rsl = Optional.empty();
        try (Session session = sf.openSession()) {
            Accident accident = (Accident) session
                    .createQuery("from Accident where id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
            rsl = Optional.of(accident);
        }
        return rsl;
    }

    public void update(Accident accident) {
        try (Session session = sf.openSession()) {
            session.beginTransaction();
            session.update(accident);
            session.getTransaction().commit();
        }
    }
}
