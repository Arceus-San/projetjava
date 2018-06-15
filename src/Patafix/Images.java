package Patafix;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.Serializable;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Images implements Serializable{

	private static final long serialVersionUID = 1L;
	public String nomimg;
	public String couleur;
	public String resolution;
	public ArrayList<String> personnes = new ArrayList<String>();
	public String ville;
	public ArrayList<String> tags = new ArrayList<String>();
	public String path;

	public Images(String p){
		this.path=p;
	}
	
	public String toString(){
		return this.path + "";
	}

	public Image recupimg(){
		//String nom = this.nomimg+".jpg";
		//Image img = new Image("Photos/"+nom);
		Image temp = new Image("file:" + this.path);
		return temp;
	}

	public void complete(){
		StringBuilder sb = new StringBuilder();
		sb.append((int)this.recupimg().getWidth());
		sb.append("x");
		sb.append((int)this.recupimg().getHeight());
		this.resolution=sb.toString();
	}
	
	public void addc(String coul){
		this.couleur=coul;
	}
	public void addv(String vil){
		this.ville=vil;
	}
	public void addp(String pers){
		this.personnes.add(pers);
	}
	public void addt(String tag){
		this.tags.add(tag);
	}


}

