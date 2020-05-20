package vojkan.bukumiric.biblioteka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vojkan.bukumiric.biblioteka.entity.Zanr;

@Repository
public interface ZanrRepository extends JpaRepository<Zanr, Long> {

}
