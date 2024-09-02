package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.kodilla.patterns.builder.bigmac.Bigmac;

import java.util.List;

public class BigmacTestSuite {

    @Test
    public void BigmacTestSuite() {
        // Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("sesame seed")
                .burgers(2)
                .sauce("barbecue")
                .ingredient("lettuce")
                .ingredient("onion")
                .ingredient("bacon")
                .build();

        // When
        String bun = bigmac.getBun();
        int burgers = bigmac.getBurgers();
        String sauce = bigmac.getSauce();
        List<String> ingredients = bigmac.getIngredients();

        // Then
        Assertions.assertEquals("sesame seed", bun);
        Assertions.assertEquals(2, burgers);
        Assertions.assertEquals("barbecue", sauce);
        Assertions.assertTrue(ingredients.contains("lettuce"));
        Assertions.assertTrue(ingredients.contains("onion"));
        Assertions.assertTrue(ingredients.contains("bacon"));
        Assertions.assertEquals(3, ingredients.size());
    }

    @Test
    public void testBigmacBuilderInvalidBun() {
        // Given & When & Then
        Assertions.assertThrows(IllegalStateException.class, () -> {
            new Bigmac.BigmacBuilder()
                    .bun("whole grain") // Invalid bun type
                    .burgers(2)
                    .sauce("barbecue")
                    .ingredient("lettuce")
                    .ingredient("onion")
                    .ingredient("bacon")
                    .build();
        });
    }

    @Test
    public void testBigmacBuilderInvalidBurgers() {
        // Given & When & Then
        Assertions.assertThrows(IllegalStateException.class, () -> {
            new Bigmac.BigmacBuilder()
                    .bun("sesame seed")
                    .burgers(5) // Invalid number of burgers
                    .sauce("barbecue")
                    .ingredient("lettuce")
                    .ingredient("onion")
                    .ingredient("bacon")
                    .build();
        });
    }

    @Test
    public void testBigmacBuilderInvalidSauce() {
        // Given & When & Then
        Assertions.assertThrows(IllegalStateException.class, () -> {
            new Bigmac.BigmacBuilder()
                    .bun("sesame seed")
                    .burgers(2)
                    .sauce("mustard") // Invalid sauce type
                    .ingredient("lettuce")
                    .ingredient("onion")
                    .ingredient("bacon")
                    .build();
        });
    }

    @Test
    public void testBigmacBuilderInvalidIngredient() {
        // Given & When & Then
        Assertions.assertThrows(IllegalStateException.class, () -> {
            new Bigmac.BigmacBuilder()
                    .bun("sesame seed")
                    .burgers(2)
                    .sauce("barbecue")
                    .ingredient("lettuce")
                    .ingredient("onion")
                    .ingredient("pineapple") // Invalid ingredient
                    .build();
        });
    }
}
