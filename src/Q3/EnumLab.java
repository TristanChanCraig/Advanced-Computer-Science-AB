package Q3;

public class EnumLab {
    enum Level {
        LOW,    // 0
        MEDIUM, // 1
        HIGH    // 2
    }

    public static void main(String[] args) {
        Level myLvl = Level.MEDIUM;
        switch (myLvl) {
            case LOW -> System.out.println("Low level");
            case MEDIUM -> System.out.println("Medium level");
            case HIGH -> System.out.println("High level");
        }

        for (Level option : Level.values()) System.out.println(option);
        // Enums can be treated like classes with methods and attributions
        // But enum constants are "public static final
    }
}
