package am.smartcode.cardservice.controller;

import am.smartcode.cardservice.model.CardDto;
import am.smartcode.cardservice.service.CardService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cards")
public class CardController {
    private final CardService cardService;

    @PostMapping
    public ResponseEntity<CardDto> createCard(@RequestBody @NotNull CardDto cardDto) {
        return ResponseEntity.ok(cardService.createCard(cardDto));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<CardDto>> getCardsByUserId(@PathVariable @NotNull Integer userId) {
        return ResponseEntity.ok(cardService.getCardByUserId(userId));
    }

    @DeleteMapping("/users/{userId}")
    public void deleteAllCardsByUserId(@PathVariable @NotNull Integer userId) {
        cardService.deleteAllCardsByUserId(userId);
    }

    @DeleteMapping("/{id}/{userId}")
    void deleteCardById(@PathVariable Integer id, @PathVariable Integer userId){
        cardService.deleteCardById(id,userId);
    }

}
