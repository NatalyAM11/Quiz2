package main;

import java.util.ArrayList;
import java.util.LinkedList;

import Exceptions.firstException;
import processing.core.PApplet;

public class Main extends PApplet {
	ArrayList <Cuadro> cuadros;
	
	//Esta variable me facilitaria manejar la excepci�n, osea cuando 
	//este se mueva iba a ser true, cuando se quede quieto false, y
	//despues de que fuera false aparecera la excepcion, pero no me funciono el movimiento :'v
	boolean activarMovimiento;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("main.Main");

	}
	public void settings() {
		size(600,400);
	}
	
	public void setup() {
		cuadros= new ArrayList <Cuadro>();
		activarMovimiento=false;

	}
	
	public void draw() {
		for (int i=0; i<30;i++) {
			for (int j=0; j<20;j++) {
				
				
				//Try del choque, aca se suponia que iba a aparecer el mensaje del error 
				try{
					
					
				    verificarEstado();
				      
				} catch (IndexOutOfBoundsException e) {
					System.out.println(e.getMessage());
					
				}catch (Exception e) {
					 System.out.println(e.getMessage());
					 fill(255,0,0);
					 textSize(20);
			         text (e.getMessage(),137,64);
				}
				
			
		// con este if controlo que el impar lo pinte en blanco, y cada par negro
			 if(i % 2 == 0 && j % 2 == 0) {
		            fill(255);


		        }   else {
                    fill(0);
                }
                if((i % 2!=0)& j % 2!=0 )  {
                    fill(255);
                }
                
                
                Cuadro cuadrito = new Cuadro(0+(600/30)*i,0+(600/30)*j,20,this);
                
                //pinto el cuadro
    			cuadrito.pintar();
    			

		}
		}
}
	
	public void mousePressed() {
		for (int i=0; i<30;i++) {
			for (int j=0; j<20;j++) {
				
				 Cuadro cuadrito = new Cuadro(0+(600/30)*i,0+(600/30)*j,20,this);
				 
				 
				// Aca intentaba mover los cuadros negro :(
   			 if(j % 2 == 0) {
   				 new Thread (cuadrito).start();
   				 activarMovimiento=true;
   				 System.out.println("esta joda no esta funcionando");
   			 }
				
				
			}
			}
		
		
		
	}
	
	//Exception de que ya no puede interactuar con el cuadrado, pero no se movio ningun circulo :/
		 public void verificarEstado() throws firstException {
			 activarMovimiento=false;
			 throw new firstException ("Este hilo ya no est� disponible.");
			 
			 
		 }
		 
}
