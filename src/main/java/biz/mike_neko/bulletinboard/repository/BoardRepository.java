package biz.mike_neko.bulletinboard.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardData,Integer>{
	public Page<BoardData> findAllByOrderByIdDesc(Pageable pageable);
}
