package am.smartcode.cardservice.service;


import am.smartcode.cardservice.model.CardDto;

import java.util.List;

public interface CardService {

    CardDto createCard(CardDto cardDto);

    List<CardDto> getCardByUserId(Integer userId);

    void deleteAllCardsByUserId(Integer userId);

    void deleteCardById(Integer id, Integer userId);

}
