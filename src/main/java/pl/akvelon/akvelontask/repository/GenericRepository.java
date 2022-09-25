package pl.akvelon.akvelontask.repository;


import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T, V> extends JpaRepository<T, Long> {
    default V getType() {
        throw new NotYetImplementedException();
    }
}
