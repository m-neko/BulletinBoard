package biz.mike_neko.bulletinboard.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<BoardData,Integer>{
	public List<BoardData> findAllByOrderByIdDesc();
}
