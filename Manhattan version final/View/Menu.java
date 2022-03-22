package View;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Controlleur.Control;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.stage.Screen;

public class Menu
{
	private Control C;
	private HBox hb = new HBox();
	private Font font;
	private Polygon P = new Polygon(	// generate the wished shape of the buttons //
			200.0,  50.0,
			400.0,  50.0,
			450.0, 100.0,
			450.0, 200.0,
			400.0, 250.0,
			200.0, 250.0,
			150.0, 200.0,
			150.0, 100.0);
	
	public Menu(Control c)
	{ this.C = c; }
	
	public HBox Menu_Launch(double W, double H) throws MalformedURLException	// first to launch //
	{
		hb.setPrefSize(W,H);
		
		File file1 = new File("src\\Background_view\\Background_Menu.jpg");
		hb.setBackground(new Background(new BackgroundImage(new Image(file1.toURI().toURL().toString()), null, null, null,new BackgroundSize(W,H, false, false, false, false))));
		this.font = new Font("Calibri",W/60);
		
		File file = new File("src\\Background_view\\Logo.png");
		ImageView iv = new ImageView(new Image(file.toURI().toURL().toString()));
		iv.setFitHeight((H/10)*2);
		iv.setFitWidth (W/3);
		
		VBox oversee = new VBox();	oversee.setPrefSize(W, H);
		HBox h1 = new HBox();	h1.setPrefSize(W,(H/20)*5);	h1.setAlignment(Pos.CENTER);
		HBox h2 = new HBox();	h2.setPrefSize(W,(H/20)*4);
		HBox h3 = new HBox();	h3.setPrefSize(W,(H/20)*3);
		HBox hs = new HBox();	hs.setPrefSize(W,(H/20)*1);
		HBox h4 = new HBox();	h4.setPrefSize(W,(H/20)*3);
		HBox h5 = new HBox();	h5.setPrefSize(W,(H/20)*4);
		
		Pane p1 = new Pane();	p1.setPrefSize(W/5, H/4);
		Pane p2 = new Pane();	p2.setPrefSize(W/5, H/4);
		Pane p3 = new Pane();	p3.setPrefSize(W/5, H/4);
		Pane p4 = new Pane();	p4.setPrefSize(W/5, H/4);
		Pane p5 = new Pane();	p5.setPrefSize(W/5, H/4);
		Pane p6 = new Pane();	p6.setPrefSize(W/5, H/4);
		
		Button B1 = new Button("Commencer");	B1.setPrefSize(W/5, H/4);	B1.setShape(P);		B1.setPickOnBounds(false);	B1.setFont(font);
		Button B2 = new Button("Charger");		B2.setPrefSize(W/5, H/4);	B2.setShape(P);		B2.setPickOnBounds(false);	B2.setFont(font);
		Button B3 = new Button("Statistique");	B3.setPrefSize(W/5, H/4);	B3.setShape(P);		B3.setPickOnBounds(false);	B3.setFont(font);
		Button B4 = new Button("Quitter");		B4.setPrefSize(W/5, H/4);	B4.setShape(P);		B4.setPickOnBounds(false);	B4.setFont(font);
		
		B1.setOnMouseClicked(event -> { try { this.hb = Menu_Player_Number(W,H,iv); } catch (MalformedURLException e) { e.printStackTrace(); } });
		B2.setOnMouseClicked(event -> { });	// reload a pre existing game //
		B3.setOnMouseClicked(event -> { try { this.hb = Statistic(W,H,iv); } catch (MalformedURLException e) { e.printStackTrace(); } });
		B4.setOnMouseClicked(event -> { System.exit(1); });
		
		h1.getChildren().add(iv);
		h3.getChildren().addAll(p1,B1,p2,B2,p3);
		h4.getChildren().addAll(p4,B3,p5,B4,p6);
		oversee.getChildren().addAll(h1,h2,h3,hs,h4,h5);
		hb.getChildren().add(oversee);
		
		return hb;
	}
	
	public HBox Statistic(double W, double H,ImageView iv) throws MalformedURLException	// WAITING ... //
	{
		hb.getChildren().clear();
		File file1 = new File("src\\Background_view\\Background_Menu.jpg");
		hb.setBackground(new Background(new BackgroundImage(new Image(file1.toURI().toURL().toString()), null, null, null,new BackgroundSize(W,H, false, false, false, false))));
		
		Button B = new Button("Retour");	B.setShape(P);		B.setPickOnBounds(false);
		
		B.setOnMouseClicked(event -> { try { this.hb.getChildren().clear();	this.hb = Menu_Launch(W,H); } catch (MalformedURLException e) { e.printStackTrace(); } });
		
		hb.getChildren().add(B);
		
		return hb;
	}
	
	public HBox Menu_Player_Number(double W, double H,ImageView iv) throws MalformedURLException		// second to launch, first major input //
	{
		hb.getChildren().clear();
		File file1 = new File("src\\Background_view\\Background_Menu.jpg");
		hb.setBackground(new Background(new BackgroundImage(new Image(file1.toURI().toURL().toString()), null, null, null,new BackgroundSize(W,H, false, false, false, false))));
		
		VBox os = new VBox();	os.setPrefSize(W,H);
		HBox h1 = new HBox();	h1.setPrefSize(W,(H/10)*2.50);	h1.setAlignment(Pos.CENTER);
		Pane p1 = new Pane();	p1.setPrefSize(W,(H/10)*1.75);
		HBox h2 = new HBox();	h2.setPrefSize(W,(H/10)*1.50);	h2.setAlignment(Pos.CENTER);
		Pane p2 = new Pane();	p2.setPrefSize(W,(H/10)*1.75);
		HBox h3 = new HBox();	h3.setPrefSize(W,(H/10)*1.50);	h3.setAlignment(Pos.CENTER);
		
		Pane p01 = new Pane();				p01.setPrefSize((W/10)*1, (H/10)*2);
		Button B1 = new Button("2 Joueur");		 B1.setPrefSize((W/10)*2, (H/10)*2);	B1.setShape(P);		B1.setPickOnBounds(false);	B1.setFont(font);
		Pane p02 = new Pane();				p02.setPrefSize((W/10)*1, (H/10)*2);
		Button B2 = new Button("3 Joueur");		 B2.setPrefSize((W/10)*2, (H/10)*2);	B2.setShape(P);		B2.setPickOnBounds(false);	B2.setFont(font);
		Pane p03 = new Pane();				p03.setPrefSize((W/10)*1, (H/10)*2);
		Button B3 = new Button("4 Joueur");		 B3.setPrefSize((W/10)*2, (H/10)*2);	B3.setShape(P);		B3.setPickOnBounds(false);	B3.setFont(font);
		Pane p04 = new Pane();				p04.setPrefSize((W/10)*1, (H/10)*2);
		
		Pane p05 = new Pane();				p05.setPrefSize((W/10)*1, (H/10)*2);
		Button B4 = new Button("Retour");	 	 B4.setPrefSize((W/10)*2, (H/10)*2);	B4.setShape(P);		B4.setPickOnBounds(false);	B4.setFont(font);
		Pane p06 = new Pane();				p06.setPrefSize((W/10)*1, (H/10)*2);
		
		B1.setOnMouseClicked(event -> { try { this.hb = Menu_Player_Pseudo(2,W,H,iv); } catch (MalformedURLException e) { e.printStackTrace(); }  });
		B2.setOnMouseClicked(event -> { try { this.hb = Menu_Player_Pseudo(3,W,H,iv); } catch (MalformedURLException e) { e.printStackTrace(); }  });
		B3.setOnMouseClicked(event -> { try { this.hb = Menu_Player_Pseudo(4,W,H,iv); } catch (MalformedURLException e) { e.printStackTrace(); }  });
		B4.setOnMouseClicked(event -> { try { this.hb.getChildren().clear();	this.hb = Menu_Launch(W,H); } catch (MalformedURLException e) { e.printStackTrace(); } });
		
		h1.getChildren().add(iv);
		h2.getChildren().addAll(p01,B1,p02,B2,p03,B3,p04);
		h3.getChildren().addAll(p05,B4,p06);
		os.getChildren().addAll(h1,p1,h2,p2,h3);
		hb.getChildren().add(os);
		return hb;
	}
	
	public HBox Menu_Player_Pseudo(int number,double W,double H,ImageView iv) throws MalformedURLException	// dependant of previous answer //
	{
		VBox os = new VBox();	Font f = new Font("Calibri",W/60);
		HBox h1 = new HBox();	h1.setPrefSize(W,(H/10)*2.50);	h1.setAlignment(Pos.CENTER);
		HBox h2 = new HBox();	h2.setPrefSize(W,(H/10)*1.50);	h2.setAlignment(Pos.CENTER);
		HBox h3 = new HBox();	h3.setPrefSize(W,(H/10)*1.50);	h3.setAlignment(Pos.CENTER);
		HBox h4 = new HBox();	h4.setPrefSize(W,(H/10)*1.50);	h4.setAlignment(Pos.CENTER);
		HBox h5 = new HBox();	h5.setPrefSize(W,(H/10)*1.50);	h5.setAlignment(Pos.CENTER);
		HBox h6 = new HBox();	h6.setPrefSize(W,(H/10)*1.50);	h6.setAlignment(Pos.CENTER);
		
		List<String> pseudo = new ArrayList<String>(Arrays.asList("","","",""));
		TextField tf1 = new TextField();	tf1.setPrefSize(W/5, H/20);		tf1.setFont(f);
		TextField tf2 = new TextField();	tf2.setPrefSize(W/5, H/20);		tf2.setFont(f);
		TextField tf3 = new TextField();	tf3.setPrefSize(W/5, H/20);		tf3.setFont(f);
		TextField tf4 = new TextField();	tf4.setPrefSize(W/5, H/20);		tf4.setFont(f);
		
		HBox rad11 = new HBox();		rad11.setPrefSize(W/10, H/20);	rad11.setAlignment(Pos.CENTER);
		HBox rad21 = new HBox();		rad21.setPrefSize(W/10, H/20);	rad21.setAlignment(Pos.CENTER);
		HBox rad31 = new HBox();		rad31.setPrefSize(W/10, H/20);	rad31.setAlignment(Pos.CENTER);
		HBox rad41 = new HBox();		rad41.setPrefSize(W/10, H/20);	rad41.setAlignment(Pos.CENTER);
		HBox rad12 = new HBox();		rad12.setPrefSize(W/10, H/20);	rad12.setAlignment(Pos.CENTER);
		HBox rad22 = new HBox();		rad22.setPrefSize(W/10, H/20);	rad22.setAlignment(Pos.CENTER);
		HBox rad32 = new HBox();		rad32.setPrefSize(W/10, H/20);	rad32.setAlignment(Pos.CENTER);
		HBox rad42 = new HBox();		rad42.setPrefSize(W/10, H/20);	rad42.setAlignment(Pos.CENTER);
		
		ToggleGroup ai1 = new ToggleGroup();
		ToggleGroup ai2 = new ToggleGroup();
		ToggleGroup ai3 = new ToggleGroup();
		ToggleGroup ai4 = new ToggleGroup();
		
		RadioButton rb11 = new RadioButton("I.A");		rb11.setFont(f);	rb11.setTextFill(Color.GREENYELLOW);
		RadioButton rb21 = new RadioButton("I.A");		rb21.setFont(f);	rb21.setTextFill(Color.GREENYELLOW);
		RadioButton rb31 = new RadioButton("I.A");		rb31.setFont(f);	rb31.setTextFill(Color.GREENYELLOW);
		RadioButton rb41 = new RadioButton("I.A");		rb41.setFont(f);	rb41.setTextFill(Color.GREENYELLOW);
		
		RadioButton rb12 = new RadioButton("Humain");	rb12.setFont(f);	rb12.setTextFill(Color.MEDIUMVIOLETRED);
		RadioButton rb22 = new RadioButton("Humain");	rb22.setFont(f);	rb22.setTextFill(Color.MEDIUMVIOLETRED);
		RadioButton rb32 = new RadioButton("Humain");	rb32.setFont(f);	rb32.setTextFill(Color.MEDIUMVIOLETRED);
		RadioButton rb42 = new RadioButton("Humain");	rb42.setFont(f);	rb42.setTextFill(Color.MEDIUMVIOLETRED);
		
		rb11.setToggleGroup(ai1);	rb12.setToggleGroup(ai1);	rb12.setSelected(true);		rad11.getChildren().add(rb11);		rad12.getChildren().add(rb12);
		rb21.setToggleGroup(ai2);	rb22.setToggleGroup(ai2);	rb22.setSelected(true);		rad21.getChildren().add(rb21);		rad22.getChildren().add(rb22);	
		rb31.setToggleGroup(ai3);	rb32.setToggleGroup(ai3);	rb32.setSelected(true);		rad31.getChildren().add(rb31);		rad32.getChildren().add(rb32);
		rb41.setToggleGroup(ai4);	rb42.setToggleGroup(ai4);	rb42.setSelected(true);		rad41.getChildren().add(rb41);		rad42.getChildren().add(rb42);
		
		hb.getChildren().clear();
		File file1 = new File("src\\Background_view\\Background_Menu.jpg");
		hb.setBackground(new Background(new BackgroundImage(new Image(file1.toURI().toURL().toString()), null, null, null,new BackgroundSize(W,H, false, false, false, false))));
		Button B1 = new Button("Lancer Partie");	B1.setPrefSize(W/ 8,(H/10));		B1.setShape(P);		B1.setPickOnBounds(false);	B1.setFont(font);
		Pane   P0 = new Pane();						P0.setPrefSize(W/16,(H/10));
		Button B2 = new Button("Retour");			B2.setPrefSize(W/ 8,(H/10));		B2.setShape(P);		B2.setPickOnBounds(false);	B2.setFont(font);
		
		     if ( number == 2 )
		{
		    h2.getChildren().addAll(tf1,rad11,rad12);
		    h3.getChildren().addAll(tf2,rad21,rad22);	
		}
		else if ( number == 3 )
		{
			h2.getChildren().addAll(tf1,rad11,rad12);
			h3.getChildren().addAll(tf2,rad21,rad22);
			h4.getChildren().addAll(tf3,rad31,rad32);
		}
		else if ( number == 4 )
		{
			h2.getChildren().addAll(tf1,rad11,rad12);
			h3.getChildren().addAll(tf2,rad21,rad22);
			h4.getChildren().addAll(tf3,rad31,rad32);
			h5.getChildren().addAll(tf4,rad41,rad42);
		}
		
		B1.setOnMouseClicked(event ->	// WARNING TO CONNECT TO MVC ASAP //
		{
			List<Integer> Ai_input = new ArrayList<Integer>(); 
			List<List<Integer>> SetHandCard = new ArrayList<List<Integer>>();
	    	List<Integer> Hc1 = new ArrayList<Integer>(Arrays.asList(1,1,1,1));	SetHandCard.add(Hc1);	// a remplir //
	    	List<Integer> Hc2 = new ArrayList<Integer>(Arrays.asList(3,3,3,3));	SetHandCard.add(Hc2);	// a remplir //
	    	List<Integer> Hc3 = new ArrayList<Integer>(Arrays.asList(7,7,7,7));	SetHandCard.add(Hc3);	// si - de 3 joueurs, laisser vide //
	    	List<Integer> Hc4 = new ArrayList<Integer>(Arrays.asList(9,9,9,9));	SetHandCard.add(Hc4);	// si - de 4 joueurs, laisser vide //
	    	
	    	if ( rb11.isSelected() == true )	{ Ai_input.add(0,1); }		else if ( rb12.isSelected() == true )	{ Ai_input.add(0,0); }
	    	if ( rb21.isSelected() == true )	{ Ai_input.add(1,1); }		else if ( rb22.isSelected() == true )	{ Ai_input.add(1,0); }	
	    	if ( number == 3 || number == 4 )	{ if ( rb31.isSelected() == true )	{ Ai_input.add(2,1); }	else if ( rb32.isSelected() == true ) { Ai_input.add(2,0); } }	else { Ai_input.add(2,-1); }
	    	if ( number == 4 )					{ if ( rb41.isSelected() == true )	{ Ai_input.add(3,1); }	else if ( rb42.isSelected() == true ) { Ai_input.add(3,0); } }	else { Ai_input.add(3,-1); }
	    	
			StackPane SP = new StackPane();
	    	SP.setPrefSize(Screen.getPrimary().getBounds().getWidth(),Screen.getPrimary().getBounds().getHeight());
	    	try
	    		{
	    			if ( tf1.getText().isEmpty() == false)  { pseudo.remove(0);	pseudo.add(0,tf1.getText()); }	else  { pseudo.remove(0);	pseudo.add(0,"Player_1"); }
	    			if ( tf2.getText().isEmpty() == false)  { pseudo.remove(1);	pseudo.add(1,tf2.getText()); }	else  { pseudo.remove(1);	pseudo.add(1,"Player_2"); }
	    			if ( tf3.getText().isEmpty() == false)  { pseudo.remove(2);	pseudo.add(2,tf3.getText()); }	else  { pseudo.remove(2);	pseudo.add(2,"Player_3"); }
	    			if ( tf4.getText().isEmpty() == false)  { pseudo.remove(3);	pseudo.add(3,tf4.getText()); }	else  { pseudo.remove(3);	pseudo.add(3,"Player_4"); }
	    			this.hb.getChildren().clear();
	    			Plateau plate = new Plateau(number,SetHandCard,pseudo,Ai_input,C);
	    			SP = plate.Create_Plateau(SP);
	    			this.hb.getChildren().add(SP);
	    		}
	    	catch (MalformedURLException e) { e.printStackTrace(); }
		});
		B2.setOnMouseClicked(event -> { this.hb.getChildren().clear();	try { this.hb = Menu_Player_Number(W,H,iv); } catch (MalformedURLException e) { e.printStackTrace(); } });
		
		h1.getChildren().add(iv);
		h6.getChildren().addAll(B2,P0,B1);
		os.getChildren().addAll(h1,h2,h3,h4,h5,h6);
		hb.getChildren().add(os);
		return hb;
	}
	
	public HBox Overlay_Paused(double W, double H, StackPane sP,MediaPlayer mp)	// create a semi transparent box for pause options.
	{
		this.hb.setAlignment(Pos.CENTER);
		VBox v = new VBox();	v.setAlignment(Pos.CENTER);
		this.hb.setPrefSize(W, H);
		this.hb.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		VBox os = new VBox();
		Button B1 = new Button("Reprendre");	B1.setPrefSize(W/4,H/8);		B1.setShape(P);		B1.setPickOnBounds(false);		//B1.setFont(font);
		Pane   P1 = new Pane();					P1.setPrefSize(W/4,H/8);
		Button B2 = new Button("Sauvegarder");	B2.setPrefSize(W/4,H/8);		B2.setShape(P);		B2.setPickOnBounds(false);		//B2.setFont(font);
		Pane   P2 = new Pane();					P2.setPrefSize(W/4,H/8);
		Button B3 = new Button("Quitter");		B3.setPrefSize(W/4,H/8);		B3.setShape(P);		B3.setPickOnBounds(false);		//B3.setFont(font);
		
		B1.setOnMouseClicked(event -> { sP.getChildren().remove(3);	sP.getChildren().remove(2); });
		B2.setOnMouseClicked(event -> { /* register the current game */ });
		B3.setOnMouseClicked(event -> { try { mp.stop();	this.hb.getChildren().clear();	this.hb = Menu_Launch(W,H); } catch (MalformedURLException e) { e.printStackTrace(); } });
		
		os.getChildren().addAll(B1,P1,B2,P2,B3);
		v.getChildren().add(os);
		this.hb.getChildren().add(v);
		return this.hb;
	}
	
	public HBox Overlay_Error(double W,double H,int status,StackPane sP)
	{
		Font f1 = new Font("Calibri",H/50);
		this.hb.setAlignment(Pos.CENTER);
		VBox v = new VBox();	v.setAlignment(Pos.CENTER);
		this.hb.setPrefSize(W, H);
		this.hb.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		VBox os = new VBox();
		Button B1 = new Button("OK");	B1.setPrefSize(W/12,H/8);		B1.setShape(P);		B1.setPickOnBounds(false);		B1.setFont(f1);
		if ( status == 1 )
		{
			Label l0 = new Label("Erreur : L'une des conditions suivantes n'a pas été remplies :");
			Label l1 = new Label("1 : Vous n'avez pas selectionné de Carte.");
			Label l2 = new Label("2 : Vous n'avez pas selectionné de Bloc.");
			Label l3 = new Label("3 : Vous n'avez pas selectionné de quartier.");
			
			HBox h0 = new HBox();	l0.setFont(f1);	l0.setTextFill(Color.rgb(255-110, 255-60, 255-180));	h0.getChildren().add(l0);	h0.setPadding(new Insets(H/100));
			HBox h1 = new HBox();	l1.setFont(f1);	l1.setTextFill(Color.rgb(255-110, 255-60, 255-180));	h1.getChildren().add(l1);	h1.setPadding(new Insets(H/100));
			HBox h2 = new HBox();	l2.setFont(f1);	l2.setTextFill(Color.rgb(255-110, 255-60, 255-180));	h2.getChildren().add(l2);	h2.setPadding(new Insets(H/100));
			HBox h3 = new HBox();	l3.setFont(f1);	l3.setTextFill(Color.rgb(255-110, 255-60, 255-180));	h3.getChildren().add(l3);	h3.setPadding(new Insets(H/100));
			HBox h4 = new HBox();	h4.setAlignment(Pos.CENTER);	h4.getChildren().add(B1);
			
			os.getChildren().addAll(h0,h1,h2,h3,h4);
		}
		if ( status == 2 )
		{
			Label l0 = new Label("Erreur : La hauteur du bloc selectionné est inferieur a celle du dernier bloc de la tour choisi.");
			
			HBox h0 = new HBox();	l0.setFont(f1);	l0.setTextFill(Color.rgb(255-110, 255-60, 255-180));	h0.getChildren().add(l0);	h0.setPadding(new Insets(H/100));
			HBox h1 = new HBox();	h1.setAlignment(Pos.CENTER);	h1.getChildren().add(B1);
			
			os.getChildren().addAll(h0,h1);
		}
		if ( status == 3 )
		{
			Label l0 = new Label("Erreur : Nombre de bloc insuffisant, veuillez choisir une autre taille de bloc.");
			
			HBox h0 = new HBox();	l0.setFont(f1);	l0.setTextFill(Color.rgb(255-110, 255-60, 255-180));	h0.getChildren().add(l0);	h0.setPadding(new Insets(H/100));
			HBox h1 = new HBox();	h1.setAlignment(Pos.CENTER);	h1.getChildren().add(B1);
			
			os.getChildren().addAll(h0,h1);
		}
		if ( status > 3 )
		{
			Label l0 = new Label("Erreur : Non Specifié, , ,");
			
			HBox h0 = new HBox();	l0.setFont(f1);	l0.setTextFill(Color.rgb(255-110, 255-60, 255-180));	h0.getChildren().add(l0);	h0.setPadding(new Insets(H/100));
			HBox h1 = new HBox();	h1.setAlignment(Pos.CENTER);	h1.getChildren().add(B1);
			
			os.getChildren().addAll(h0,h1);
		}
		
		CornerRadii cr = new CornerRadii(H/50);
		os.setBackground(new Background(new BackgroundFill(Color.rgb(110, 60, 180), cr, null)));
		os.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(H/50), new BorderWidths(H/250))));
		os.setPadding(new Insets(H/50));
		
		B1.setOnMouseClicked(event -> { sP.getChildren().remove(3);	sP.getChildren().remove(2); });
		
		v.getChildren().add(os);
		this.hb.getChildren().add(v);
		return this.hb;
	}
}