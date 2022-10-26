package fr.lernejo.umlgrapher;

public class UmlType {

    //Récupère la class, le nom de la classe et son package

    private final Class aClass;
    private final String className;
    private final String packageName;

    UmlType(Class aClass){
        this.aClass = aClass;
        this.className = aClass.getSimpleName();
        this.packageName = aClass.getPackageName();
    }

    public Class getMyClass() {
        return this.aClass;
    }

    public String getClassName() {
        return this.className;
    }

    public String getPackageName() {
        return this.packageName;
    }
}
