package MVC.Modelo;

public enum Categorias {
    HOGAR, LIMPIEZA, ALIMENTACION, OCIO, TECNOLOGIA, OTROS;

    public static Categorias detectarCategoria(String categoria){
        return switch (categoria.toLowerCase()) {
            case "hogar" -> HOGAR;
            case "limpieza" -> LIMPIEZA;
            case "alimentacion" -> ALIMENTACION;
            case "ocio" -> OCIO;
            case "tecnologia" -> TECNOLOGIA;
            default -> OTROS;
        };
    }

}
