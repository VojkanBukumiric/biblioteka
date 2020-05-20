package vojkan.bukumiric.biblioteka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vojkan.bukumiric.biblioteka.entity.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

}
