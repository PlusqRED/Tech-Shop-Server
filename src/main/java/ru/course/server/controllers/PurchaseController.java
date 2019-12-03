package ru.course.server.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.course.server.daos.PurchaseRepository;
import ru.course.server.models.product.Purchase;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/purchases")
public class PurchaseController {
    private final PurchaseRepository purchaseRepository;

    @PostMapping
    public void purchase(@RequestBody Purchase purchase) {
        purchase.setPurchaseDate(LocalDate.now());
        purchaseRepository.save(purchase);
    }

    @GetMapping
    public List<Purchase> getAll() {
        return purchaseRepository.findAll();
    }
}
