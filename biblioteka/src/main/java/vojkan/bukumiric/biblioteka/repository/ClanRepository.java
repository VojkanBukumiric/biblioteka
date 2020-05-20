package vojkan.bukumiric.biblioteka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vojkan.bukumiric.biblioteka.entity.Clan;

@Repository
public interface ClanRepository extends JpaRepository<Clan, Long> {

	List<Clan> findByBrClanskeKarte(String brClanskeKarte);

	

	

}
