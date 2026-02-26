package Infrastructure.repository;

import com.gui_mpereira.aprendendo_spring.infrastructure.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Telefone,Long> {
}
