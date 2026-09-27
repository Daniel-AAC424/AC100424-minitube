package com.example.minitube.model;

public class Video {
	
    private Long id;
    private String titulo;
    private String urlYoutube;
    private String youtubeId;
    private CategoriaVideo categoria;

    public Video() {
    }

    public Video(Long id, String titulo,
                 String urlYoutube, String youtubeId,
                 CategoriaVideo categoria) {
        this.id = id;
        this.titulo = titulo;
        this.urlYoutube = urlYoutube;
        this.youtubeId = youtubeId;
        this.categoria = categoria;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getUrlYoutube() { return urlYoutube; }
    public void setUrlYoutube(String urlYoutube) {
        this.urlYoutube = urlYoutube;
    }

    public String getYoutubeId() { return youtubeId; }
    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }
    
    public CategoriaVideo getCategoria() { return categoria; }
    public void setCategoria(CategoriaVideo categoria) {
        this.categoria = categoria;
    }


}
