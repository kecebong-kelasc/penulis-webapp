package lab.kecebong.penuliswebapp.repo;

import lab.kecebong.penuliswebapp.entity.Penulis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PenulisRepo

	extends JpaRepository<Penulis,String> {}