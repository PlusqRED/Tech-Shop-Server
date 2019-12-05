package ru.course.server.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.course.server.controllers.checkers.DateValidator;
import ru.course.server.controllers.checkers.TimeChecker;
import ru.course.server.daos.PurchaseJpaSpringRepository;
import ru.course.server.models.product.Purchase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/v1/purchases")

@RequiredArgsConstructor
@RestController
public class PurchaseTcpServerController {
    private final PurchaseJpaSpringRepository purchaseJpaSpringRepository;

    @PostMapping
    public void purchase(@RequestBody Purchase purchase) {
        DateValidator.dateValidate(LocalDate.now());
        purchase.setPurchaseDate(LocalDate.now());
        TimeChecker.timeCheck(LocalDateTime.now());
        purchaseJpaSpringRepository.save(purchase);
        TimeChecker.timeCheck(LocalDateTime.now());
    }

    @GetMapping
    public List<Purchase> getAll() {
        DateValidator.dateValidate(LocalDate.now());
        return purchaseJpaSpringRepository.findAll();
    }
}
