package model;


public class ghost extends Monstre{
	//hello

	public String image;
	
	public ghost(int point_de_vie, int position_x, int position_y) {
		super(point_de_vie,position_x,position_y);
		this.image = "ghost";
	}
}
