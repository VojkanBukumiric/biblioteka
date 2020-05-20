package vojkan.bukumiric.biblioteka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vojkan.bukumiric.biblioteka.entity.Korisnik;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

	List<Korisnik> findByImeAndLozinka(String ime, String lozinka);

}
