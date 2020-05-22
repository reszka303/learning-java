package javaStart.task13_StaticComponents.exercise2;

public class Recipe {
   static final double GLASS_TO_MILIMITERS = 250;
   static final double SPOON_TO_MILIMITERS = 15;
   static final double TEASPOON_TO_MILIMITERS = 5;

   static double countGlass(double numberOfGlass) {
        return numberOfGlass * GLASS_TO_MILIMITERS;
   }

   static double countSpoon(double numberOfSpoon) {
       return numberOfSpoon * SPOON_TO_MILIMITERS;
   }

   static double countTeaspoon(double numberOfTeaspoon) {
       return numberOfTeaspoon * TEASPOON_TO_MILIMITERS;
   }
}
