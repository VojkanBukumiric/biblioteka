package vojkan.bukumiric.biblioteka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vojkan.bukumiric.biblioteka.entity.Knjiga;

@Repository
public interface KnjigaRepository extends JpaRepository<Knjiga, Long> {

}
