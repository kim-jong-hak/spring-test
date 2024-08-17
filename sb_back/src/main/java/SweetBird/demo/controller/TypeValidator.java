package SweetBird.demo.controller;

import java.util.Set;

public class TypeValidator {



        private static final Set<String> VALID_TYPES = Set.of("front", "back");

        public static boolean isValidType(String type) {
            return VALID_TYPES.contains(type);
        }


}
