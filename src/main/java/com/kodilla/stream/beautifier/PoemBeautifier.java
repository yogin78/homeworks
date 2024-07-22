package com.kodilla.stream.beautifier;

public class PoemBeautifier{

    public void beautify(String text, PoemDecorator decorator) {
        String result = decorator.decorate(text);
        System.out.println(result);
    }

    public static void main(String[] args) {

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        PoemDecorator toUpperCase = text -> text.toUpperCase();
        PoemDecorator addStars = text -> "*** " + text + " ***";
        PoemDecorator addABC = text -> "ABC" + text + "ABC";
        PoemDecorator addExclamation = text -> text + "!!!";

        String text1 = "tekst1";
        String text2 = "tekst2";
        String text3 = "tekst3";
        String text4 = "tekst4";

        poemBeautifier.beautify(text1, toUpperCase);
        poemBeautifier.beautify(text2, addStars);
        poemBeautifier.beautify(text3, addABC);
        poemBeautifier.beautify(text4, addExclamation);

    }
}
