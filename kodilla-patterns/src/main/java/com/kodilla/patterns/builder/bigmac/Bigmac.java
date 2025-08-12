package com.kodilla.patterns.builder.bigmac;

import java.util.HashSet;
import java.util.Set;

public final class Bigmac {

    private final Bun bun;
    private final Sauce sauce;
    private final int burgers;
    private final Set<Ingredients> ingredients;

    public static class BigmacBuilder {

        private Bun bun;
        private Sauce sauce;
        private int burgers;
        private final Set<Ingredients> ingredients = new HashSet<>();

        public BigmacBuilder bun(Bun bun) {
            this.bun = bun;
            return this;
        }

        public BigmacBuilder sauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder ingredients(Ingredients ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            validateBun();
            validateSauce();
            validateBurgers();
            validateIngredients();
            return new Bigmac(bun, sauce, burgers, ingredients);
        }

        private void validateBun() {
            if (bun == null) {
                throw new IllegalArgumentException("Bun must be selected!");
            }
        }

        private void validateSauce() {
            if (sauce == null) {
                throw new IllegalArgumentException("Sauce must be selected!");
            }
        }

        private void validateBurgers() {
            if (burgers <= 0 || burgers > 2) {
                throw new IllegalArgumentException("Burgers must be between 1 and 2!");
            }
        }

        private void validateIngredients() {
            if (ingredients.size() > 4) {
                throw new IllegalArgumentException("Ingredients must be between 0 and 4!");
            }
        }
    }

    private Bigmac(Bun bun, Sauce sauce, int burgers, Set<Ingredients> ingredients) {
        this.bun = bun;
        this.sauce = sauce;
        this.burgers = burgers;
        this.ingredients = new HashSet<>(ingredients);
    }

    public Bun getBun() {
        return bun;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public int getBurgers() {
        return burgers;
    }

    public Set<Ingredients> getIngredients() {
        return new HashSet<>(ingredients);
    }
}
