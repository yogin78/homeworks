package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {

    private final String bun;
    private final int burgers;
    private final String sauce;
    private final List<String> ingredients;

    private Bigmac(String bun, int burgers, String sauce, List<String> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public String getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "bun='" + bun + '\'' +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }

    public static class BigmacBuilder {
        private String bun;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder bun(String bun) {
            if (!bun.equals("sesame seed") && !bun.equals("regular")) {
                throw new IllegalStateException("Bun type must be either 'sesame seed' or 'regular'.");
            }
            this.bun = bun;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            if (burgers < 1 || burgers > 3) {
                throw new IllegalStateException("Number of burgers must be between 1 and 3.");
            }
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            if (!sauce.equals("standard") && !sauce.equals("1000 islands") && !sauce.equals("barbecue")) {
                throw new IllegalStateException("Sauce must be 'standard', '1000 islands', or 'barbecue'.");
            }
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(String ingredient) {
            List<String> allowedIngredients = List.of("lettuce", "onion", "bacon", "chili peppers", "champignons", "cheese", "shrimps");
            if (!allowedIngredients.contains(ingredient)) {
                throw new IllegalStateException("Ingredient '" + ingredient + "' is not allowed.");
            }
            this.ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            return new Bigmac(bun, burgers, sauce, ingredients);
        }
    }
}
