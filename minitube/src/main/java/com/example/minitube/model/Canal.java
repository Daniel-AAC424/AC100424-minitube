package com.example.minitube.model;

import java.util.ArrayList;
import java.util.List;


public class Canal {
	
    private Long id;
    private String nombre;
    private String usuario;
    private String descripcion;
    private String urlPortada = "";
    private List<Video> videos;

    public Canal() {
        videos = new ArrayList<>();
    }

    public Canal(Long id, 
    		String nombre,
    		String usuario, 
    		String descripcion,
    		String urlPortada) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.descripcion = descripcion;
        setUrlPortada(urlPortada);
        this.videos = new ArrayList<>();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getUrlPortada() { return urlPortada; }
    public void setUrlPortada(String urlPortada) {
        this.urlPortada = (urlPortada == null) ? "" : urlPortada.strip();
    }

    public List<Video> getVideos() { return videos; }
    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
    
    public int getTotalVideos() {
        return videos.size();
    }

    public void agregarVideo(Video video) {
        videos.add(video);
    }
    
    public boolean eliminarVideo(Long videoId) {
        return videos.removeIf(video -> videoId.equals(video.getId()));
    }



}
