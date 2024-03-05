package am.smartcode.cardservice.repository;

import am.smartcode.cardservice.model.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, Integer> {

    List<CardEntity> findAllByUserId(Integer userId);

    void deleteCardEntitiesByUserId(Integer userId);

    void deleteByIdAndUserId(Integer id, Integer userId);
}