/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minipaint1;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.CircleBuilder;
import javax.swing.ImageIcon;
import javafx.event.Event; 
import javafx.scene.Group;
import javafx.scene.input.MouseButton; 
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.jdom2.Element;
import org.jdom2.Document;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


/**
 *
 * @author joseb
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Canvas lienzo;
    
    private GraphicsContext g;
     @FXML
    private Circle cr;
     @FXML
    private Label coor;
         @FXML   
      private String figura = new String();
     
      
    @FXML
    private void crearCuadrado(ActionEvent event) {
       // System.out.println("You clicked me!");
       // label.setText("Hello World!");
        g=lienzo.getGraphicsContext2D();
        double w= lienzo.getWidth();
        double h= lienzo.getHeight();
        g.setFill(Color.WHITE);
        g.fillRect(0.5, 0.5, w, h);
        cr.setFill(Color.WHITE);
        
        g.setStroke(Color.GREEN);
        g.setLineWidth(3);
        g.strokeRect(30, 30, 100, 100);
        
        figura="cuadrado";
       
    }
    @FXML
    private void ccuadrado(ActionEvent event) {
       // System.out.println("You clicked me!");
       // label.setText("Hello World!");
        g=lienzo.getGraphicsContext2D();
        double w= lienzo.getWidth();
        double h= lienzo.getHeight();
        g.setFill(Color.WHITE);
        g.fillRect(0.5, 0.5, w, h);
        cr.setFill(Color.WHITE);
        
        g.setStroke(Color.BLACK);
        g.setLineWidth(3);
        g.strokeRect(30, 30, 100, 100);
        g.setFill(Color.rgb(0 + (int) (Math.random() * 255), 0 + (int) (Math.random() * 255), 0 + (int) (Math.random() * 255)));
        g.fillRect(30, 30, 100, 100);
        
        figura="cuadrado";
       
    }
        @FXML
    private void crearMouseCuadrado(MouseEvent event) {
       // System.out.println("You clicked me!");
       // label.setText("Hello World!");
        g=lienzo.getGraphicsContext2D();
        
        double x=event.getX();
        double y=event.getY();
        
       
        
        g.setStroke(Color.GREEN);
        g.setLineWidth(3);
        g.strokeRect(x-30, y-30, 60, 60);
        
       
    }
    
      @FXML
    private void label1(MouseEvent event) {
       // System.out.println("You clicked me!");
       // label.setText("Hello World!");
        g=lienzo.getGraphicsContext2D();
        
        double x=event.getX();
        double y=event.getY();
        
       
       coor.setText("x:  "+ x + "   y:  "+ y);
       
        
       
    }
         @FXML
    private void limpiar(ActionEvent event) {
       // System.out.println("You clicked me!");
       // label.setText("Hello World!");
        g=lienzo.getGraphicsContext2D();
        
        double w= lienzo.getWidth();
        double h= lienzo.getHeight();
        g.setFill(Color.WHITE);
        g.fillRect(0.5, 0.5, w, h);
        g.setStroke(Color.BLACK);
        g.setLineWidth(3);
        g.strokeRect(0, 0, w, h);
        cr.setFill(Color.WHITE);
    }
    
  @FXML
    private void triangulo(ActionEvent event) {
        double w3 = lienzo.getWidth();
        double h3 = lienzo.getHeight();
        g.setFill(Color.WHITE);
        g.fillRoundRect(270, 100, w3 - 300, h3 - 184, 50, 50);
        g.setStroke(Color.GREY);
        double[] coordenadasx = {50, 100, 150};

        double[] coordenadasy = {100, 50, 100};

        g.strokePolygon(coordenadasx, coordenadasy, 3);

        figura="triangulo";
    }
    
    @FXML
    private void ctriangulo(ActionEvent event) {
        double w3 = lienzo.getWidth();
        double h3 = lienzo.getHeight();
        g.setFill(Color.WHITE);
        g.fillRoundRect(270, 100, w3 - 300, h3 - 184, 50, 50);
        g.setStroke(Color.GREY);
        g.setFill(Color.rgb(0 + (int) (Math.random() * 255), 0 + (int) (Math.random() * 255), 0 + (int) (Math.random() * 255)));
        double[] coordenadasx = {50, 100, 150};

        double[] coordenadasy = {100, 50, 100};

        g.strokePolygon(coordenadasx, coordenadasy, 3);
        g.fillPolygon(coordenadasx, coordenadasy, 3);

        figura="triangulo";
        
    }
     
    
    

    @FXML
    private void crearCirculo(ActionEvent event) {
       // System.out.println("You clicked me!");
       // label.setText("Hello World!");
        g=lienzo.getGraphicsContext2D();
        
        double w= lienzo.getWidth();
        double h= lienzo.getHeight();
        
        g.setFill(Color.WHITE);
        g.fillRect(0.5, 0.5, w, h);
        

        Polygon p=new Polygon();
        
        p.getPoints().addAll(new Double[]{
         -50.0, 50.0,
         20.0, 10.0,
         100.0, 100.0 });
        cr.setFill(Color.GREEN);
        
        
         Circle c= new Circle(50);
        Rectangle r=new Rectangle(100,100);
        r.setFill(Color.GREEN);
        
        PathTransition transition=new PathTransition();
        
        transition.setNode(cr);
        transition.setDuration(Duration.seconds(5));
        transition.setPath(c);
        transition.setCycleCount(PathTransition.INDEFINITE);
        transition.play();
       
    }
    
     @FXML
    private void ccirculo(ActionEvent event) {
       // System.out.println("You clicked me!");
       // label.setText("Hello World!");
        g=lienzo.getGraphicsContext2D();
        
        double w= lienzo.getWidth();
        double h= lienzo.getHeight();
        
        g.setFill(Color.WHITE);
        g.fillRect(0.5, 0.5, w, h);
        

        Polygon p=new Polygon();
        
        p.getPoints().addAll(new Double[]{
         -50.0, 50.0,
         20.0, 10.0,
         100.0, 100.0 });
        cr.setFill(Color.rgb(0 + (int) (Math.random() * 255), 0 + (int) (Math.random() * 255), 0 + (int) (Math.random() * 255)));
        
        
         Circle c= new Circle(50);
        Rectangle r=new Rectangle(100,100);
        r.setFill(Color.GREEN);
        
        PathTransition transition=new PathTransition();
        
        transition.setNode(cr);
        transition.setDuration(Duration.seconds(5));
        transition.setPath(c);
        transition.setCycleCount(PathTransition.INDEFINITE);
        transition.play();
       
    }
      public void guardarXML(String Dato) {
        try {
            Element num = new Element("Hecho_por_jose") {
            };
            Document doc = new Document(num);

            Element staff = new Element("Coordenadas");
            staff.addContent(new Element("dato").setText(Dato));
            doc.getRootElement().addContent(staff);

            XMLOutputter xmlOutput = new XMLOutputter();
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output(doc, new FileWriter("file.xml"));
            System.out.println("Archivo Guardado!");

        } catch (IOException io) {
            System.out.println(io.getMessage());
        }

    }

    @FXML
    private void guardarxml(ActionEvent event) {
        String a = new String();

        if (figura == "circulo") {
            a = "\nFigura: Circulo"+"\n\n           coordenadas:" +"\n            X: 300" + "\n            Y: 120"+ "\n\n            Color: Azul Cielo Claro";
        } else if (figura == "pincel") {
            a = "\nFigura: Circulo"+"\n\n           coordenadas:" +"\n            X: 300" + "\n            Y: 120"+ "\n\n            Color: Random";
        } else if (figura == "5 puntas") { 
            a = "\nFigura: Estrella de 5 puntas"+"\n\n           coordenadas:" +"\n            X: [350, 650, 400, 500, 600]" + "\n            Y: [300, 300, 450, 200, 450]"+ "\n\n            Color: Blanco";
        } else if (figura == "6 puntas") {
              a = "\nFigura: Estrella de 6 puntas"+"\n\n           coordenadas:" +"\n            X: [400, 500, 600, 400, 500, 600]" + "\n            Y: [300, 450, 300, 400, 250, 400]"+ "\n\n            Color: Blanco";
            
        } else if (figura == "7 puntas") { a = "\nFigura: Estrella de 7 puntas"+"\n\n           coordenadas:" +"\n            X: [420, 520, 500, 400, 468, 540, 440]" + "\n            Y: [490, 490, 390, 440, 510, 440, 390]"+ "\n\n            Color: Blanco";
            
        } else if (figura == "8 puntas c") { a = "\nFigura: Estrella de 8 puntas"+"\n\n           coordenadas:" +"\n            X: [550, 660, 550, 440, 475, 625, 625, 475]" + "\n            Y: [560, 450, 340, 450, 525, 525, 375, 375]"+ "\n\n            Color: Blanco";
        } 
        else if (figura == "8 puntas p") { a = "\nFigura: Estrella de 8 puntas"+"\n\n           coordenadas:" +"\n            X:[550, 725, 650, 575, 750, 575, 650, 725]" + "\n            Y: [340, 265, 440, 265, 340, 415, 240, 415]"+ "\n\n            Color: Blanco";
        }
        else if (figura == "12 puntas") { a = "\nFigura: Estrella de 12 puntas"+"\n\n           coordenadas:" +"\n            X: [560, 725, 600, 650, 700, 575, 740, 575, 700, 650, 600, 725]" + "\n            Y: [340, 300, 405, 260, 405, 300, 340, 380, 275, 420, 275, 380]"+ "\n\n            Color: Blanco";
        }

        guardarXML(a);

    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        g=lienzo.getGraphicsContext2D();
        
        double w= lienzo.getWidth();
        double h= lienzo.getHeight();
        g.setFill(Color.WHITE);
        g.fillRect(0.5, 0.5, w, h);
        g.setStroke(Color.BLACK);
        g.setLineWidth(3);
        g.strokeRect(0, 0, w, h);
        
     
    }    
    
}
