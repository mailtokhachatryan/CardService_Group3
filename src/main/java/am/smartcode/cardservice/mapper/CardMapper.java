package am.smartcode.cardservice.mapper;

import am.smartcode.cardservice.model.CardDto;
import am.smartcode.cardservice.model.CardEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper {
    CardEntity toEntity(CardDto cardDto);
    CardDto toDto(CardEntity cardEntity);
}
