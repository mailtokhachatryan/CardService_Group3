package am.smartcode.cardservice.service.impl;

import am.smartcode.cardservice.mapper.CardMapper;
import am.smartcode.cardservice.model.CardDto;
import am.smartcode.cardservice.model.CardEntity;
import am.smartcode.cardservice.repository.CardRepository;
import am.smartcode.cardservice.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    @Transactional
    @Override
    public CardDto createCard(CardDto cardDto) {
        CardEntity entity = cardMapper.toEntity(cardDto);
        cardRepository.save(entity);
        return cardMapper.toDto(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CardDto> getCardByUserId(Integer userId) {
        List<CardEntity> cards = cardRepository.findAllByUserId(userId);
        return cards.stream().map(cardMapper::toDto).toList();
    }

    @Override
    @Transactional
    public void deleteAllCardsByUserId(Integer userId) {
        cardRepository.deleteCardEntitiesByUserId(userId);
    }

    @Override
    @Transactional
    public void deleteCardById(Integer id, Integer userId) {
        cardRepository.deleteByIdAndUserId(id, userId);
    }
}
