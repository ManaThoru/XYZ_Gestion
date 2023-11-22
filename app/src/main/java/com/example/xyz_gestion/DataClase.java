package com.example.xyz_gestion;
public class DataClase {
    private String dataEditorial;
    private String dataTitulo;
    private String dataIdioma;
    private String dataImage;
    private String key;
    public DataClase(String editorial, String titulo, String idioma, String urlImage){}

    public DataClase(String dataEditorial, String dataTitulo, String dataIdioma, String dataImage, String key) {
        this.dataEditorial = dataEditorial;
        this.dataTitulo = dataTitulo;
        this.dataIdioma = dataIdioma;
        this.dataImage = dataImage;
        this.key = key;
    }
    public DataClase(){}

    public String getDataEditorial() {
        return dataEditorial;
    }

    public void setDataEditorial(String dataEditorial) {
        this.dataEditorial = dataEditorial;
    }

    public String getDataTitulo() {
        return dataTitulo;
    }

    public void setDataTitulo(String dataTitulo) {
        this.dataTitulo = dataTitulo;
    }

    public String getDataIdioma() {
        return dataIdioma;
    }

    public void setDataIdioma(String dataIdioma) {
        this.dataIdioma = dataIdioma;
    }

    public String getDataImage() {
        return dataImage;
    }

    public void setDataImage(String dataImage) {
        this.dataImage = dataImage;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
