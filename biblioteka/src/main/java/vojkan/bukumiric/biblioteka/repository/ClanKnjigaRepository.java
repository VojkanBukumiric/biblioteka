package vojkan.bukumiric.biblioteka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vojkan.bukumiric.biblioteka.entity.ClanKnjiga;

@Repository
public interface ClanKnjigaRepository extends JpaRepository<ClanKnjiga, Long>{

}
