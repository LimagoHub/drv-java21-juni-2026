package main;

import java.lang.ScopedValue;

public class ScopedValueHello {

    // 1. ScopedValue deklarieren
    static final ScopedValue<Person> USER =
            ScopedValue.newInstance();

    public static void main(String[] args) {


        // 2. ScopedValue binden und Code im Scope ausführen
        ScopedValue.where(USER, new Person("Alice")).run(() -> {

            // 3. ScopedValue lesen
            sayHello();

        });

        // 4. Außerhalb des Scopes NICHT verfügbar
        // USER.get(); // -> IllegalStateException
    }

    private static void sayHello() {
        USER.get().setName("Bob");
        // ScopedValue ist hier verfügbar, obwohl es kein Parameter ist
        System.out.println("Hallo " + USER.get());

    }
}

class Person  {
    private String name;
    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
