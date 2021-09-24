package guru.qa.tests;

public enum Hobbies {
    SPORTS("Sports", 0),
    READING("Reading", 1),
    MUSIC("Music", 2);

    public final String name;
    public final int number;

    Hobbies(String name, int number) {
        this.name = name;
        this.number = number;
    }
}
