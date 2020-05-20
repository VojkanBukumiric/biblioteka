package vojkan.bukumiric.biblioteka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vojkan.bukumiric.biblioteka.entity.Grad;

@Repository
public interface GradRepository extends JpaRepository<Grad, Long> {

}
