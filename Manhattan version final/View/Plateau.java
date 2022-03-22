package View;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Controlleur.Control;
import Controlleur.Observer;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Screen;

public class Plateau implements Observer
{
	private MediaPlayer track;
	private EventControl eventctrl = new EventControl();				// name implies // 
	private Control C;													// acces to Control link //
	private List<Integer> stats = new ArrayList<Integer>();				// main status values //
	private List<List<File>> bloc_image = new ArrayList<List<File>>();	// viewing of blocs //
	private List<Background> Bk = new ArrayList<Background>();			// background for player area //
	private List<Group> G = new ArrayList<Group>();						// player area stabilizer (for rotation) //
	private List<List<Integer>> BlocsList;								// indicative state of Deck  Bloc //
	private List<List<Integer>> CardsList;								// indicative state of Deck  Card //
	private int[][][][] Towerlist = new int[6][3][3][3];				// indicative state of Tower Card //
	private ImageView[][] Gimg = new ImageView[4][4];					// Operate Card Imaging and status show/hidden //
	private Label[][] labellist = new Label[5][4];						// Pseudonymes holder //
	private Label[][] quarterctrl = new Label[6][9];					// quarter value holderSS
	private HBox[] Local = new HBox[4];									// player area container //
	private VBox[] verticals = new VBox[5];								// screen container //
	
	public Plateau(int py,List<List<Integer>> DC,List<String> pseudo, List<Integer> Ai,Control c) throws MalformedURLException
	{
		this.C = c;
		Observer.Update_SG(py,pseudo,C);
		
		this.stats.add(0,0);			// roller for blocs //
		this.stats.add(1,py);			// number of player //
		this.stats.add(2,1);			// turning pointer  //
		this.stats.add(3,1);			// player in charge //
		
		this.stats.add(4,0);			// points Player 1 //
		this.stats.add(5,0);			// points Player 2 //
		this.stats.add(6,0);			// points Player 3 //
		this.stats.add(7,0);			// points Player 4 //
		
		this.stats.add(8 ,Ai.get(0));	// player 1 AI status // if 1 = true // if 0 = false //
		this.stats.add(9 ,Ai.get(1));	// player 2 AI status // if 1 = true // if 0 = false //
		this.stats.add(10,Ai.get(2));	// player 3 AI status // if 1 = true // if 0 = false //
		this.stats.add(11,Ai.get(3));	// player 4 AI status // if 1 = true // if 0 = false //
		
		List<List<Integer>> DB  = new ArrayList<List<Integer>>();
		List<Integer> Db1 = new ArrayList<Integer>(Arrays.asList(11,6,4,3));	DB.add(0,Db1);
    	List<Integer> Db2 = new ArrayList<Integer>(Arrays.asList(11,6,4,3));	DB.add(1,Db2);
    	List<Integer> Db3 = new ArrayList<Integer>(Arrays.asList(11,6,4,3));	DB.add(2,Db3);
    	List<Integer> Db4 = new ArrayList<Integer>(Arrays.asList(11,6,4,3));	DB.add(3,Db4);
    	this.BlocsList = DB;
    	
    	for ( int i = 0 ; i < 6 ; i++ )
    	{
    		for ( int j = 0 ; j < 9 ; j++ )
    		{
    			this.quarterctrl[i][j] = new Label("0");
    		}
    	}
    	
    	int[][][][] tl =
    		{
    			{
    				{{0,0,0},{0,0,0},{0,0,0}},{{0,0,0},{0,0,0},{0,0,0}},{{0,0,0},{0,0,0},{0,0,0}}
    			},
    			{
    				{{0,0,0},{0,0,0},{0,0,0}},{{0,0,0},{0,0,0},{0,0,0}},{{0,0,0},{0,0,0},{0,0,0}}
    			},
    			{
    				{{0,0,0},{0,0,0},{0,0,0}},{{0,0,0},{0,0,0},{0,0,0}},{{0,0,0},{0,0,0},{0,0,0}}
    			},
    			{
    				{{0,0,0},{0,0,0},{0,0,0}},{{0,0,0},{0,0,0},{0,0,0}},{{0,0,0},{0,0,0},{0,0,0}}
    			},
    			{
    				{{0,0,0},{0,0,0},{0,0,0}},{{0,0,0},{0,0,0},{0,0,0}},{{0,0,0},{0,0,0},{0,0,0}}
    			},
    			{
    				{{0,0,0},{0,0,0},{0,0,0}},{{0,0,0},{0,0,0},{0,0,0}},{{0,0,0},{0,0,0},{0,0,0}}
    			}
    		};
    	
    	this.Towerlist = tl;
    	
		this.CardsList = DC;
		
		for ( int i = 0 ; i < 4 ; i ++ )
		{
			for ( int j = 0 ; j < 4 ; j ++ )
			{
				this.labellist[i+1][j] = new Label("");
			}
		}
		
		for ( int i = 0 ; i < 4 ; i ++ )
		{
			List<File> listcolor = new ArrayList<File>();
			for ( int j = 0 ; j < 5 ; j ++ )
			{
				File blcol = new File("src\\Blocs_view\\"+(i+1)+"_"+(j)+".JPG");
				listcolor.add(blcol);
			}
			Font f = new Font("Calibri",Screen.getPrimary().getBounds().getHeight()/50);
			this.bloc_image.add(listcolor);
			Label l = new Label();
			l.setText(pseudo.get(i) + " : " + this.stats.get(i+4));
			l.setFont(f);
			this.labellist[0][i] = l;
		}
		
		// Player Area //
		HBox Local1 = new HBox();	HBox Local2 = new HBox();	HBox Local3 = new HBox();	HBox Local4 = new HBox();
		Local[0]=Local1;			Local[1]=Local2;			Local[2]=Local3;			Local[3]=Local4;
		
		G.add(new Group(Local[0]));	G.add(new Group(Local[1]));	G.add(new Group(Local[2]));	G.add(new Group(Local[3]));
		
		// Screen vertical box //
		VBox ext_left = new VBox();	VBox inn_left = new VBox();	VBox centered = new VBox();	VBox inn_rigt = new VBox();	VBox ext_rigt = new VBox();
		verticals[0] = ext_left;	verticals[1] = inn_left;	verticals[2] = centered;	verticals[3] = inn_rigt;	verticals[4] = ext_rigt;
					
		// background //
		Color yellow = Color.rgb(255,255,140);		Background bkyellow = new Background(new BackgroundFill(yellow, null, null));
		Color orange = Color.rgb(255,190,100);		Background bkorange = new Background(new BackgroundFill(orange, null, null));
		Color blue   = Color.rgb(100,190,255);		Background bkblue   = new Background(new BackgroundFill(blue  , null, null));
		Color purple = Color.rgb(190,100,255);		Background bkpurple = new Background(new BackgroundFill(purple, null, null));
					
		this.Bk.add(bkorange);	this.Bk.add( bkblue );	this.Bk.add(bkyellow);	this.Bk.add(bkpurple);
	}
	
	public StackPane Create_Plateau(StackPane SP) throws MalformedURLException	// Entry : HBox // Exit : plateau //
	{
		// initiate soundtrack file and object //
		File file = new File("src\\Soundtrack\\SoundTrack_01.mp3");
		String tell = file.toURI().toURL().toString();
		Media sound = new Media(tell);
		track = new MediaPlayer(sound);
		track.setCycleCount(50);	// allow repeat //
		track.setAutoPlay(true);	// allow repeat //
		
		// recover screen size //
		double W = (int)Screen.getPrimary().getBounds().getWidth() ;	/* size of screen from right to left */	double W02 = W/11;	/* Size in lenght for cards */
		double H = (int)Screen.getPrimary().getBounds().getHeight();	/* size of screen from top to bottom */	double H02 = H/11;	/* Size in height for cards */
		
		// secondary sizes //
		double H2 = H/2;
		double H3 = (H-H2)/2;
				
		Pane P = new Pane();	P.setPrefSize(W, H);
		HBox Hb = new HBox();
		Font f = new Font("Calibri",H3/10);
		
		Color back = Color.rgb(30,30,30);
		Background overall = new Background(new BackgroundFill(back, null, null));
		
		// Border //
		BorderStroke bs1 = new BorderStroke(Color.rgb(1,1,1),BorderStrokeStyle.SOLID,CornerRadii.EMPTY,new BorderWidths(2));
		
		Hb.setPrefSize(W, H);
		Hb.setAlignment(Pos.CENTER);
		
		// player Local Default //
		Local[0].setPrefSize(H2, H3);	Local[1].setPrefSize(H3, H2);	Local[2].setPrefSize(H2, H3);	Local[3].setPrefSize(H3, H2);
		
		// inner board //
		HBox innerplateau = new HBox();	innerplateau.setAlignment(Pos.CENTER);
		innerplateau = Create_Inner_Board(H/2,overall);
		
		// bloc central //
		verticals[2].setPrefSize(H2, H);
		
		if ( this.stats.get(1) == 2 )	{ Local[2] = Create_Player_Area_H(Local[2],bs1,1,3,H02,W02,true);	Local[2].setBackground(this.Bk.get(2)); }
		if ( this.stats.get(1) == 4 )	{ Local[2] = Create_Player_Area_H(Local[2],bs1,2,3,H02,W02,true);	Local[2].setBackground(this.Bk.get(2)); }
		
		Local[0] = Create_Player_Area_H(Local[0],bs1,0,1,H02,W02,false);	Local[0].setBackground(this.Bk.get(0));
		
		// bloc central_right //
		verticals[3].setPrefSize(H3, H);
		
		// Corner Right_Up, point counter //
		HBox corner_R_U = new HBox();	corner_R_U.setPrefSize(H3, H3);		corner_R_U.setAlignment(Pos.CENTER);
		VBox ptsliner = new VBox();		ptsliner.setPrefSize(H3/1.5, H3);		ptsliner.setAlignment(Pos.CENTER);
		if ( this.stats.get(1) == 2 )
		{
			HBox pts_P1 = new HBox();		pts_P1.setPrefSize(H3/1.5,H3/5);		pts_P1.setBackground(this.Bk.get(0));	pts_P1.setAlignment(Pos.CENTER);	Pane pa = new Pane();	pa.setPrefSize(H3/1.5,H3/30);
			HBox pts_P2 = new HBox();		pts_P2.setPrefSize(H3/1.5,H3/5);		pts_P2.setBackground(this.Bk.get(2));	pts_P2.setAlignment(Pos.CENTER);
			pts_P1.getChildren().add(this.labellist[0][0]);
			pts_P2.getChildren().add(this.labellist[0][1]);
			ptsliner.getChildren().addAll(pts_P1,pa,pts_P2);
		}
		else if ( this.stats.get(1) == 3 )
		{
			HBox pts_P1 = new HBox();		pts_P1.setPrefSize(H3/1.5,H3/5);		pts_P1.setBackground(this.Bk.get(0));	pts_P1.setAlignment(Pos.CENTER);	Pane pa = new Pane();	pa.setPrefSize(H3/1.5,H3/30);
			HBox pts_P2 = new HBox();		pts_P2.setPrefSize(H3/1.5,H3/5);		pts_P2.setBackground(this.Bk.get(1));	pts_P2.setAlignment(Pos.CENTER);	Pane pb = new Pane();	pb.setPrefSize(H3/1.5,H3/30);
			HBox pts_P3 = new HBox();		pts_P3.setPrefSize(H3/1.5,H3/5);		pts_P3.setBackground(this.Bk.get(3));	pts_P3.setAlignment(Pos.CENTER);
			pts_P1.getChildren().add(this.labellist[0][0]);
			pts_P2.getChildren().add(this.labellist[0][1]);
			pts_P3.getChildren().add(this.labellist[0][2]);
			ptsliner.getChildren().addAll(pts_P1,pa,pts_P2,pb,pts_P3);
		}
		else if ( this.stats.get(1) == 4 )
		{
			HBox pts_P1 = new HBox();		pts_P1.setPrefSize(H3/1.5,H3/5);		pts_P1.setBackground(this.Bk.get(0));	pts_P1.setAlignment(Pos.CENTER);	Pane pa = new Pane();	pa.setPrefSize(H3/1.5,H3/30);
			HBox pts_P2 = new HBox();		pts_P2.setPrefSize(H3/1.5,H3/5);		pts_P2.setBackground(this.Bk.get(1));	pts_P2.setAlignment(Pos.CENTER);	Pane pb = new Pane();	pb.setPrefSize(H3/1.5,H3/30);
			HBox pts_P3 = new HBox();		pts_P3.setPrefSize(H3/1.5,H3/5);		pts_P3.setBackground(this.Bk.get(2));	pts_P3.setAlignment(Pos.CENTER);	Pane pc = new Pane();	pc.setPrefSize(H3/1.5,H3/30);
			HBox pts_P4 = new HBox();		pts_P4.setPrefSize(H3/1.5,H3/5);		pts_P4.setBackground(this.Bk.get(3));	pts_P4.setAlignment(Pos.CENTER);
			pts_P1.getChildren().add(this.labellist[0][0]);
			pts_P2.getChildren().add(this.labellist[0][1]);
			pts_P3.getChildren().add(this.labellist[0][2]);
			pts_P4.getChildren().add(this.labellist[0][3]);
			ptsliner.getChildren().addAll(pts_P1,pa,pts_P2,pb,pts_P3,pc,pts_P4);
		}
		corner_R_U.getChildren().add(ptsliner);
		// end points counter //
		
		if ( this.stats.get(1) != 2 )	{ Local[1] = Create_Player_Area_V(Local[1],bs1,1,2,H02,W02,false);	Local[1].setBackground(this.Bk.get(1)); }
		
		// corner Right Down //
		HBox corner_R_D = new HBox();	corner_R_D.setPrefSize(H3,H3);
		VBox buttonland = new VBox();	buttonland.setPrefSize(H3,H3);	buttonland.setAlignment(Pos.CENTER);
		Button b1 = new Button("Execute");	b1.setPrefSize(H3/1.5, H3/3.5);		b1.setFont(f);
		Pane p = new Pane();		p.setPrefSize(H3,H3/5);
		Button b2 = new Button("Cancel");	b2.setPrefSize(H3/1.5, H3/3.5);		b2.setFont(f);
		buttonland.getChildren().addAll(b1,p,b2);
		corner_R_D.getChildren().add(buttonland);
		
		// bloc central__left //
		verticals[1].setPrefSize(H3, H);
		// Corner Left_Up //
		HBox corner_L_U = new HBox();	corner_L_U.setPrefSize(H3, H3);
		
		if ( this.stats.get(1) == 3 )	{ Local[3] = Create_Player_Area_V(Local[3],bs1,2,4,H02,W02,true);	Local[3].setBackground(this.Bk.get(3)); }
		if ( this.stats.get(1) == 4 )	{ Local[3] = Create_Player_Area_V(Local[3],bs1,3,4,H02,W02,true);	Local[3].setBackground(this.Bk.get(3)); }
		
		// Corner Left_Down //
		HBox corner_L_D = new HBox();	corner_L_D.setPrefSize(H3, H3);	corner_L_D.setAlignment(Pos.CENTER);
		VBox buttonland2 = new VBox();	buttonland2.setPrefSize(H3,H3);	buttonland2.setAlignment(Pos.CENTER);
		Button b3 = new Button("Finish Turn");	b3.setPrefSize(H3/1.5, H3/3.5);;	b3.setFont(f);
		Pane p2 = new Pane();		p2.setPrefSize(H3,H3/5);
		Button b4 = new Button("Pausing");		b4.setPrefSize(H3/1.5, H3/3.5);		b4.setFont(f);
		buttonland2.getChildren().addAll(b3,p2,b4);
		corner_L_D.getChildren().add(buttonland2);
		
		b1.setOnMouseClicked(event -> {  });
		b2.setOnMouseClicked(event -> {  });
		b3.setOnMouseClicked(event ->
		{
			try
			{ 
				if ( this.eventctrl.Check_MoveSet() == false || this.BlocsList.get(this.stats.get(3)-1).get(eventctrl.Get_Input()[1]) == 0 )	{ throw new Exception(); }
				
				if ( this.stats.get(3) == 4 || this.stats.get(3) == 3 )	{ this.eventctrl.Inverser(); }
				Observer.Update_3DInput(this.stats.get(1),this.stats.get(3),this.eventctrl.Get_Input(),C);
				this.City_Update(this.stats.get(3));
				Turning();
				this.eventctrl.Play_Effect(2);
				this.eventctrl.Reseter();
			}
			catch (MalformedURLException e) { e.printStackTrace(); }
			catch (Exception e)
			{
				// e.printStackTrace(); //	// current error : none //
				Menu m = new Menu(C);
				HBox x = new HBox();
				     if ( this.eventctrl.Check_MoveSet()  == false )								{ x=m.Overlay_Error(W, H, 1, SP); }
				else if ( this.BlocsList.get(this.stats.get(3)-1).get(eventctrl.Get_Input()[1]) == 0)	{ x=m.Overlay_Error(W, H, 2, SP); }
				HBox y = new HBox();
				y.setPrefSize(W,H);
				y.setBackground(new Background(new BackgroundFill(Color.BLACK,null,null)));
				y.setOpacity(0.5);
				SP.getChildren().add(2,y);
				SP.getChildren().add(3,x);
			}
		});
		b4.setOnMouseClicked(event ->
		{
			this.track.setVolume(0.5);
			Menu m = new Menu(C);
			HBox x = m.Overlay_Paused(W, H,SP,track);
			HBox y = new HBox();
			y.setPrefSize(W,H);
			y.setBackground(new Background(new BackgroundFill(Color.BLACK,null,null)));
			y.setOpacity(0.5);
			SP.getChildren().add(2,y);
			SP.getChildren().add(3,x);
		});
		
		// bloc ex_right //
		VBox ex_R = new VBox();			ex_R.setPrefSize((W-(H3*2)-(H2))/2, H);
		
		// bloc ec__left //
		VBox ex_L = new VBox();			ex_L.setPrefSize((W-(H3*2)-(H2))/2, H);
		
		corner_L_D.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		corner_L_U.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		corner_R_D.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		corner_R_U.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		ex_R.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		ex_L.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, null, null)));
		
		// generating empty placeholder //
		
		if ( this.stats.get(1) == 2 )
		{
			Local[1] = Create_Empty_Area(Local[1], bs1, 1);		Local[1].setBackground(this.Bk.get(1));
			Local[3] = Create_Empty_Area(Local[3], bs1, 3);		Local[3].setBackground(this.Bk.get(3));		
		}
		else if ( this.stats.get(1) == 3 )
		{ Local[2] = Create_Empty_Area(Local[2], bs1, 2);		Local[2].setBackground(this.Bk.get(2)); }
		else if ( this.stats.get(1) == 4 )
		{  }
		
		// Main assembly line
		verticals[3].getChildren().addAll(corner_R_U,G.get(1),corner_R_D);
		verticals[2].getChildren().addAll(G.get(2),innerplateau,G.get(0));
		verticals[1].getChildren().addAll(corner_L_U,G.get(3),corner_L_D);
		
		Hb.getChildren().addAll(ex_R,verticals[3],verticals[2],verticals[1],ex_L);
		
		File file1 = new File("src\\Background_view\\Background_A.jpg");
		P.setBackground(new Background(new BackgroundImage(new Image(file1.toURI().toURL().toString()), null, null, null,new BackgroundSize(W,H, false, false, false, false))));
		SP.getChildren().add(0, P);
		SP.getChildren().add(1,Hb);
		track.play();
		return SP;
	}
	
	public HBox Create_Inner_Board(double size,Background overall)	// Create inner Board // WORK IN PROGRESS //
	{
		HBox Hb = new HBox();
		Hb.setPrefSize(size, size);
		// initiate inner board sizes //
		double ringsize = (size/25)*24;
		double ringbord = (size/25)   ;
		double centered = (size/12.5) ;
		
		// initiate pts elements
		List<HBox> ptsbloc = new ArrayList<HBox>();	    		// container of information comming from the model //
		List<List<HBox>> quarter = new ArrayList<List<HBox>>();	// container of information comming from the model //
		
		for( int i = 0 ; i < 80 ; i++ )
		{
			HBox h = new HBox();
			Label l = new Label(""+i);
			h.setAlignment(Pos.CENTER);
			h.setPrefSize(ringbord,ringbord);
			h.getChildren().add(l);
			ptsbloc.add(h);
		}
		
		for ( int i = 0 ; i < 6 ; i++ )
		{
			List<HBox> quarterbis = new ArrayList<HBox>();
			for ( int j = 0 ; j < 9 ; j++ )
			{
				HBox h = new HBox();
				h.setPrefSize(ringbord,ringbord);
				quarterbis.add(h);
			}
			quarter.add(quarterbis);
		}
		
		// initiate Color and background //
		Color corn = Color.rgb(255,125,0);;
		Color five = Color.rgb(255,195,0);;
		Color clen = Color.rgb(255,255,255);;
		Background corners = new Background(new BackgroundFill(corn, null, null));
		Background fiveclu = new Background(new BackgroundFill(five, null, null));
		Background blanksc = new Background(new BackgroundFill(clen, null, null));
		
		// initiate inner Node //
		HBox inner       = new HBox();		// Heart of the board //
		HBox ring_up2    = new HBox();
		HBox ring_down2  = new HBox();
		VBox ring_left2  = new VBox();
		VBox ring_right2 = new VBox();
		// initiate secondary Node //
		BorderPane center = new BorderPane();
		HBox ring_up    = new HBox();
		HBox ring_down  = new HBox();
		VBox ring_left  = new VBox();
		VBox ring_right = new VBox();
		
		BorderPane inside = new BorderPane();
		HBox ring = new HBox();
		VBox v0 = new VBox();
		
		// settings //
		      inner.setPrefSize(size-(ringbord*4), (size-(ringbord*4)));
		   ring_up2.setPrefSize(size-(ringbord*3),ringbord);
		 ring_down2.setPrefSize(size-(ringbord*3),ringbord);
		 ring_left2.setPrefSize(ringbord,size-(ringbord*4));
		ring_right2.setPrefSize(ringbord,size-(ringbord*4));
		
		    center.setPrefSize(centered, centered);
		   ring_up.setPrefSize(ringsize,ringbord);
		 ring_down.setPrefSize(ringsize,ringbord);
		 ring_left.setPrefSize(ringbord,ringsize-(ringbord/2));
		ring_right.setPrefSize(ringbord,ringsize-(ringbord/2));
		
		inside.setPrefSize(ringsize, ringsize);
		ring.setPrefSize(ringsize, ringsize);
		v0.setAlignment(Pos.CENTER);
		Hb.setAlignment(Pos.CENTER);
		
		inner = Create_Main_City(inner); // IN CONSTRUCTION //
		
		// Painter //
		for ( int i = 0 ; i < 80 ; i++ )	// paint the points case //
		{
			     if( i == 0 || i == 20 || i == 40 || i == 60 )	{ ptsbloc.get(i).setBackground(corners); }
			else if(i % 5 == 0)									{ ptsbloc.get(i).setBackground(fiveclu); }
			else												{ ptsbloc.get(i).setBackground(blanksc); }
		}
		Hb.setBackground(overall);
		inside.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		center.setBackground(overall);
		
		// assembly //
		int cptl = 18;
		int cptd = 20;
		for ( int i = 0 ; i < 80 ; i++ )	// assembler for points case //
		{
			     if( i >= 0  && i < 20 ) {    ring_up.getChildren().add(ptsbloc.get(i)); HBox h = new HBox(); h.setPrefSize(((3*ringbord)/20),ringbord); h.setBackground(overall); ring_up.getChildren().add(h); }
			else if( i == 20 )			 {    ring_up.getChildren().add(ptsbloc.get(i)); }	// blocking //
			else if( i == 21 )			 { HBox h1 = new HBox(); h1.setPrefSize(ringbord,((3*ringbord)/18)); h1.setBackground(overall); ring_right.getChildren().add(h1); ring_right.getChildren().add(ptsbloc.get(i)); HBox h2 = new HBox(); h2.setPrefSize(ringbord,((3*ringbord)/18)); h2.setBackground(overall); ring_right.getChildren().add(h2); }
			else if( i >= 22 && i < 40 ) { ring_right.getChildren().add(ptsbloc.get(i)); HBox h = new HBox(); h.setPrefSize(ringbord,((3*ringbord)/18)); h.setBackground(overall); ring_right.getChildren().add(h); }
			else if( i >= 40 && i < 60 ) {  ring_down.getChildren().add(ptsbloc.get(i+cptd)); HBox h = new HBox(); h.setPrefSize(((3*ringbord)/20),ringbord); h.setBackground(overall); ring_down.getChildren().add(h); cptd = cptd - 2; } // reversed //
			else if( i == 60 )			 {  ring_down.getChildren().add(ptsbloc.get(i+cptd)); }  // blocking // reversed //
			else if( i == 61)			 { HBox h1 = new HBox(); h1.setPrefSize(ringbord,((3*ringbord)/18)); h1.setBackground(overall); ring_left.getChildren().add(h1); ring_left.getChildren().add(ptsbloc.get(i+cptl)); HBox h2 = new HBox(); h2.setPrefSize(ringbord,((3*ringbord)/18)); h2.setBackground(overall); ring_left.getChildren().add(h2); cptl = cptl -2; }
			else if( i >= 62 && i < 80 ) {  ring_left.getChildren().add(ptsbloc.get(i+cptl)); HBox h = new HBox(); h.setPrefSize(ringbord,((3*ringbord)/18)); h.setBackground(overall); ring_left.getChildren().add(h); cptl = cptl - 2; }	// reversed //
		}
		center.setTop(ring_up2);
		center.setBottom(ring_down2);
		center.setLeft(ring_left2);
		center.setRight(ring_right2);
		center.setCenter(inner);
		
		inside.setTop(ring_up);
		inside.setBottom(ring_down);
		inside.setLeft(ring_left);
		inside.setRight(ring_right);
		inside.setCenter(center);
		
		ring.getChildren().add(inside);
		v0.getChildren().add(ring);
		Hb.getChildren().add(v0);
		
		return Hb;
	}
	
	public HBox Create_Main_City(HBox H)
	{
		double w = H.getPrefWidth();	double h = H.getPrefHeight();
		
		double h2 = h / 3;	double h3 = w-((h/3)*2);	double h4 = h3 / 2;
		
		HBox h11 = new HBox();	h11.setPrefSize(h4, h2);
		HBox h12 = new HBox();	h12.setPrefSize(h2, h2);	h12 = Create_Quarter(h12,0);
		HBox h13 = new HBox();	h13.setPrefSize(h2, h2);	h13 = Create_Quarter(h13,1);
		HBox h14 = new HBox();	h14.setPrefSize(h4, h2);
		
		HBox h21 = new HBox();	h21.setPrefSize(h2, h2);	h21 = Create_Quarter(h21,2);
		HBox h22 = new HBox();	h22.setPrefSize(h3, h2);
		HBox h23 = new HBox();	h23.setPrefSize(h2, h2);	h23 = Create_Quarter(h23,3);
		
		HBox h31 = new HBox();	h31.setPrefSize(h4, h2);
		HBox h32 = new HBox();	h32.setPrefSize(h2, h2);	h32 = Create_Quarter(h32,4);
		HBox h33 = new HBox();	h33.setPrefSize(h2, h2);	h33 = Create_Quarter(h33,5);
		HBox h34 = new HBox();	h34.setPrefSize(h4, h2);
		
		HBox v1 = new HBox();	v1.setPrefSize(w , h2);	v1.getChildren().addAll(h11,h12,h13,h14);
		HBox v2 = new HBox();	v2.setPrefSize(w , h2);	v2.getChildren().addAll(h21,h22,h23);
		HBox v3 = new HBox();	v3.setPrefSize(w , h2);	v3.getChildren().addAll(h31,h32,h33,h34);
		
		VBox v0 = new VBox();	v0.getChildren().addAll(v1,v2,v3);	H.getChildren().add(v0);
		
		return H;
	}
	
	public HBox Create_Quarter(HBox H,int index)
	{
		double w = H.getPrefWidth();	double h = H.getPrefHeight();
		double w2 = w-(w/4);			double h2 = h-(h/4);
		CornerRadii cr = new CornerRadii(25.0);
		CornerRadii cr2 = new CornerRadii(5.0);
		H.setAlignment(Pos.CENTER);
		H.setBackground(new Background(new BackgroundFill(Color.BLUE, cr, null)));
		VBox v = new VBox();	v.setPrefSize(w2, h);	v.setAlignment(Pos.CENTER);
		HBox h0 = new HBox();	h0.setPrefSize(w2, h2);
		
		GridPane gp = new GridPane();
		
		for ( int i = 0 ; i < 5 ; i++ )
		{
			for ( int j = 0 ; j < 5 ; j++ )
			{
				Label l = new Label();	l.setFont(new Font("Calibri",25));
				HBox hd = new HBox();
				hd.setPrefSize(w2/20,h2/20);	// divide into 2 lenght //
				
				if ( i == 0 && j == 0 ) { 	hd.setPrefSize((w2/20)*6,(h2/20)*6);
											hd.setBackground(new Background(new BackgroundFill(Color.GREY, cr2, null)));
											l.setText( Integer.toString(this.Towerlist[index][0][0][1]));	hd.getChildren().add(l); 	this.quarterctrl[index][0] = l; }
				if ( i == 0 && j == 2 ) { 	hd.setPrefSize((w2/20)*6,(h2/20)*6);
											hd.setBackground(new Background(new BackgroundFill(Color.GREY, cr2, null)));
											l.setText( Integer.toString(this.Towerlist[index][1][0][1]));	hd.getChildren().add(l); 	this.quarterctrl[index][1] = l; }
				if ( i == 0 && j == 4 ) { 	hd.setPrefSize((w2/20)*6,(h2/20)*6);
											hd.setBackground(new Background(new BackgroundFill(Color.GREY, cr2, null)));
											l.setText( Integer.toString(this.Towerlist[index][2][0][1])); 	hd.getChildren().add(l); 	this.quarterctrl[index][2] = l; }
				
				if ( i == 2 && j == 0 ) { 	hd.setPrefSize((w2/20)*6,(h2/20)*6);
											hd.setBackground(new Background(new BackgroundFill(Color.GREY, cr2, null)));
											l.setText( Integer.toString(this.Towerlist[index][0][1][1])); 	hd.getChildren().add(l); 	this.quarterctrl[index][3] = l; }
				if ( i == 2 && j == 2 ) { 	hd.setPrefSize((w2/20)*6,(h2/20)*6);
											hd.setBackground(new Background(new BackgroundFill(Color.GREY, cr2, null)));
											l.setText( Integer.toString(this.Towerlist[index][1][1][1])); 	hd.getChildren().add(l); 	this.quarterctrl[index][4] = l; }
				if ( i == 2 && j == 4 ) { 	hd.setPrefSize((w2/20)*6,(h2/20)*6);
											hd.setBackground(new Background(new BackgroundFill(Color.GREY, cr2, null)));
											l.setText( Integer.toString(this.Towerlist[index][2][1][1])); 	hd.getChildren().add(l); 	this.quarterctrl[index][5] = l; }
				
				if ( i == 4 && j == 0 ) { 	hd.setPrefSize((w2/20)*6,(h2/20)*6);
											hd.setBackground(new Background(new BackgroundFill(Color.GREY, cr2, null)));
											l.setText( Integer.toString(this.Towerlist[index][0][2][1])); 	hd.getChildren().add(l); 	this.quarterctrl[index][6] = l; }
				if ( i == 4 && j == 2 ) { 	hd.setPrefSize((w2/20)*6,(h2/20)*6);
											hd.setBackground(new Background(new BackgroundFill(Color.GREY, cr2, null)));
											l.setText( Integer.toString(this.Towerlist[index][1][2][1])); 	hd.getChildren().add(l); 	this.quarterctrl[index][7] = l; }
				if ( i == 4 && j == 4 ) { 	hd.setPrefSize((w2/20)*6,(h2/20)*6);
											hd.setBackground(new Background(new BackgroundFill(Color.GREY, cr2, null)));
											l.setText( Integer.toString(this.Towerlist[index][2][2][1])); 	hd.getChildren().add(l); 	this.quarterctrl[index][8] = l; }
				
				hd.setAlignment(Pos.CENTER);
				
				gp.setOnMousePressed (event -> eventctrl.OnClick_Event_Handler(gp,0,0,index,3,true ));
				gp.setOnMouseReleased(event -> eventctrl.OnClick_Event_Handler(gp,0,0,index,3,false));
				
				gp.add(hd, i, j);
			}
		}
		
		h0.getChildren().add(gp);	v.getChildren().add(h0);	H.getChildren().add(v);
		
		return H;
	}
	
	public HBox Create_Empty_Area(HBox H,BorderStroke bs, int local)	// Create PlaceHolder // Otherwise a transparent space would appear instead //
	{
		double w = H.getPrefWidth(); double h = H.getPrefHeight();
		
		if ( local == 1 || local == 3 )
		{
			VBox Vpr = new VBox();
			for( int i = 0 ; i < 4 ; i++ )
			{
				HBox Ha = new HBox();	Ha.setPrefSize(w, h/4);
				HBox a = new HBox();	a.setPrefSize(w*0.25, h/4);	a.setBorder(new Border(bs));
				HBox b = new HBox();	b.setPrefSize(w*0.75, h/4);	b.setBorder(new Border(bs));
				if ( local == 1 )		{ Ha.getChildren().addAll(b,a); }
				else if ( local == 3)	{ Ha.getChildren().addAll(a,b); }
				Vpr.getChildren().add(i,Ha);
			}
			H.getChildren().add(Vpr);
		}
		else if ( local == 2 )
		{
			HBox Hpr = new HBox();
			for( int i = 0 ; i < 4 ; i++ )
			{
				VBox Va = new VBox();	Va.setPrefSize(w/4, h);
				HBox a = new HBox();	a.setPrefSize(w/4, h*0.25);	a.setBorder(new Border(bs));
				HBox b = new HBox();	b.setPrefSize(w/4, h*0.75);	b.setBorder(new Border(bs));
				Va.getChildren().addAll(b,a);
				Hpr.getChildren().add(i,Va);
			}
			H.getChildren().add(Hpr);
		}
		return H;
	}
	
	public HBox Create_Player_Area_H(HBox H,BorderStroke bs,int index,int player,double ws,double hs,boolean sta) throws MalformedURLException	// true == top // false == bottom //
	{
		double w = H.getPrefWidth(); double h = H.getPrefHeight();
		VBox temp = new VBox();		temp.setPrefSize(w,h);
		HBox carte = new HBox();	carte.setPrefSize(w, h*0.75);
		HBox blocs = new HBox();	blocs.setPrefSize(w, h*0.25);
		List<ImageView> test = new ArrayList<ImageView>();
		ImageView iv = new ImageView();
		
		for ( int i = 0 ; i < 4 ; i ++ )
		{
			int coloring = 0;
			     if ( sta == true )
			{
			    	 coloring = 1;
				     if ( this.stats.get(1) == 2 )	{ iv = new ImageView(new Image(this.bloc_image.get(coloring).get(5-(i+1)).toURI().toURL().toString())); }
			    else if ( this.stats.get(1) == 4 )	{ iv = new ImageView(new Image(this.bloc_image.get(coloring).get(5-(i+1)).toURI().toURL().toString())); }
			}
			else if ( sta == false ){ coloring = 2; iv = new ImageView(new Image(this.bloc_image.get(coloring).get(i+1).toURI().toURL().toString())); }
			
			iv.setFitHeight(h*0.2);
			iv.setFitWidth(h*0.2);
			
			if ( sta == true ) { iv.setRotate(180); }
			if ( sta == false) {}
			test.add(iv);
		}
		
		for ( int i = 0 ; i < 4 ; i ++ )
		{
			HBox hb0 = new HBox();		hb0.setAlignment(Pos.CENTER);
			hb0.setPrefSize(w*0.25, h*0.75);
			
			if ( sta == true  ) { Card_Control(index,i,player,hs,ws,180,this.CardsList.get(2));}
			if ( sta == false ) { Card_Control(index,i,player,hs,ws, 0 ,this.CardsList.get(0));}
			Group g = new Group();	g.getChildren().add(this.Gimg[index][i]);
			hb0.getChildren().add( g );
			hb0.setBorder(new Border(bs));
			carte.getChildren().add(hb0);
		}
		
		for ( int i = 0 ; i < 4 ; i ++ )
		{
			int ie = i;
			HBox hb0 = new HBox();	hb0.setAlignment(Pos.CENTER);
			HBox hb1 = new HBox();	hb1.setAlignment(Pos.CENTER);
			HBox hb2 = new HBox();	hb2.setAlignment(Pos.CENTER);
			hb0.setPrefSize(w/4, h*0.25);
			hb1.setPrefSize(w/8, h*0.25);
			hb2.setPrefSize(w/8, h*0.25);
			hb0.setBorder(new Border(bs));
			
			if ( sta == true  )
			{
				this.labellist[3][i] = new Label();
				this.labellist[3][i].setFont(new Font("Calbiri",ws/3));
				this.labellist[3][i].setText("*"+ this.BlocsList.get(2).get(3-i));
				hb2.getChildren().add(this.labellist[3][i]);
			}
			else if ( sta == false )
			{
				this.labellist[1][i] = new Label();
				this.labellist[1][i].setFont(new Font("Calbiri",ws/3));
				this.labellist[1][i].setText("*"+ this.BlocsList.get(0).get(i));
				hb2.getChildren().add(this.labellist[1][i]);
			}
				ImageView imvi = test.get(i);
				if ( sta == true )	{ imvi.setRotate(0); }
				hb1.getChildren().add(test.get(i));
				hb0.setOnMousePressed (event -> { eventctrl.OnClick_Event_Handler(imvi,this.stats.get(3),player,ie,2,true ); });
				hb0.setOnMouseReleased(event -> { eventctrl.OnClick_Event_Handler(imvi,this.stats.get(3),player,ie,2,false); });
				
			hb0.getChildren().addAll(hb1,hb2);
			if ( sta == true )	{ hb0.setRotate(180); }
			
			blocs.getChildren().add(hb0);
		}
		
		if ( sta == true  ) { temp.getChildren().addAll(carte,blocs); }
		if ( sta == false ) { temp.getChildren().addAll(blocs,carte); }

		H.getChildren().add(temp);
		return H;
	}
	
	public HBox Create_Player_Area_V(HBox H,BorderStroke bs,int index,int player, double ws,double hs,boolean sta) throws MalformedURLException	// true == right // false == left //
	{
		double w = H.getPrefWidth(); double h = H.getPrefHeight();
		HBox temp = new HBox();		temp.setPrefSize(w,h);
		VBox carte = new VBox();	carte.setPrefSize(w*0.75, h);
		VBox blocs = new VBox();	blocs.setPrefSize(w*0.25, h);
		List<ImageView> test = new ArrayList<ImageView>();
		ImageView iv = new ImageView();
		
		for ( int i = 0 ; i < 4 ; i ++ )	// updating ... //
		{
			int coloring = 0;
			if ( sta == true )
			{
				coloring = 3;
				     if ( this.stats.get(1) == 3 ) { iv = new ImageView(new Image(this.bloc_image.get(coloring).get(5-(i+1)).toURI().toURL().toString())); }
				else if ( this.stats.get(1) == 4 ) { iv = new ImageView(new Image(this.bloc_image.get(coloring).get(5-(i+1)).toURI().toURL().toString())); }
			}
			if ( sta == false) { coloring = 0;     iv = new ImageView(new Image(this.bloc_image.get(coloring).get(i+1).toURI().toURL().toString())); }
			iv.setFitHeight(h*0.1);
			iv.setFitWidth(h*0.1);
			if ( sta == true ) { iv.setRotate(-90); }
			if ( sta == false) { iv.setRotate(90); }
			test.add(iv);
		}
		
		for ( int i = 0 ; i < 4 ; i ++ )
		{
			VBox vb0 = new VBox();		vb0.setAlignment(Pos.CENTER);
			vb0.setPrefSize(w*0.75, h*0.25);
			
			if ( sta == true  ) { Card_Control(index,i,player,hs,ws,270,this.CardsList.get(3)); }
			if ( sta == false ) { Card_Control(index,i,player,hs,ws, 90,this.CardsList.get(1)); }
			Group g = new Group();	g.getChildren().add(this.Gimg[index][i]);
			vb0.getChildren().add( g );
			vb0.setBorder(new Border(bs));
			carte.getChildren().add(vb0);
		}
		
		for ( int i = 0 ; i < 4 ; i ++ )
		{
			int ie = i;
			VBox vb0 = new VBox();	vb0.setAlignment(Pos.CENTER);
			HBox hb1 = new HBox();	hb1.setAlignment(Pos.CENTER);
			HBox hb2 = new HBox();	hb2.setAlignment(Pos.CENTER);
			vb0.setPrefSize(w/4, h*0.25);
			hb1.setPrefSize(w/8, h*0.25);
			hb2.setPrefSize(w/8, h*0.25);
			vb0.setBorder(new Border(bs));
			
			if ( sta == true  )
			{
				this.labellist[4][i] = new Label();
				this.labellist[4][i].setFont(new Font("Calbiri",ws/3));
				this.labellist[4][i].setText("*"+ this.BlocsList.get(1).get(3-i));
				this.labellist[4][i].setRotate(90);
				hb2.getChildren().add(this.labellist[4][i]);
				}
			else if ( sta == false )
			{
				this.labellist[2][i] = new Label();
				this.labellist[2][i].setFont(new Font("Calbiri",ws/3));
				this.labellist[2][i].setText("*"+ this.BlocsList.get(3).get(i));
				this.labellist[2][i].setRotate(90);
				hb2.getChildren().add(this.labellist[2][i]);
			}
			
				ImageView imvi = test.get(i);
				if ( sta == true )	{ imvi.setRotate(90); }
				hb1.getChildren().add(test.get(i));
				vb0.setOnMousePressed (event -> { eventctrl.OnClick_Event_Handler(imvi,this.stats.get(3),player,ie,2,true ); });
				vb0.setOnMouseReleased(event -> { eventctrl.OnClick_Event_Handler(imvi,this.stats.get(3),player,ie,2,false); });
			
			vb0.getChildren().addAll(hb1,hb2);
			if ( sta == true )	{ vb0.setRotate(180); }
				
			blocs.getChildren().add(vb0);
		}
		
		if ( sta == false ) { temp.getChildren().addAll(carte,blocs); }
		if ( sta == true  ) { temp.getChildren().addAll(blocs,carte); }

		H.getChildren().add(temp);
		return H;
	}
	
	public void Turning() throws MalformedURLException	// control the adaptation linked to change of player turn //	// Cleaning required // add auto turning for AI //
	{
		     if ( this.stats.get(1) == 2 )	// cas 2 joueurs //
		{
		           if ( this.stats.get(2) == 1 )
		          {		this.stats.remove(2);	this.stats.add(2,2);
		          		this.stats.remove(3);	this.stats.add(3,3);
		          		Turning_Update(1,0,2);
		        	  	verticals[2].getChildren().remove(G.get(0));	Local[0].setRotate(180);	verticals[2].getChildren().add(0,G.get(0));
		  				verticals[2].getChildren().remove(G.get(2));	Local[2].setRotate(180);	verticals[2].getChildren().add(2,G.get(2));
		  				verticals[1].getChildren().remove(G.get(3));	Local[3].setRotate(180);	verticals[1].getChildren().add(1,G.get(1));
		  				verticals[3].getChildren().remove(G.get(1));	Local[1].setRotate(180);	verticals[3].getChildren().add(1,G.get(3));
		          }
		      else if ( this.stats.get(2) == 2 )
		     	  {		this.stats.remove(2);	this.stats.add(2,1);
		     	  		this.stats.remove(3);	this.stats.add(3,1);
		     	  		Turning_Update(0,1,1);
		    	 		verticals[2].getChildren().remove(G.get(2));	Local[2].setRotate( 0 );	verticals[2].getChildren().add(0,G.get(2));
	  					verticals[2].getChildren().remove(G.get(0));	Local[0].setRotate( 0 );	verticals[2].getChildren().add(2,G.get(0));
	  					verticals[1].getChildren().remove(G.get(1));	Local[1].setRotate( 0 );	verticals[3].getChildren().add(1,G.get(1));
		  				verticals[3].getChildren().remove(G.get(3));	Local[3].setRotate( 0 );	verticals[1].getChildren().add(1,G.get(3));
		     	  }
		}
		else if ( this.stats.get(1) == 3 )	// cas 3 joueurs //
		{
		           if ( this.stats.get(2) == 1 )
		          {		this.stats.remove(2);	this.stats.add(2,2);
		          		this.stats.remove(3);	this.stats.add(3,2);
		          		Turning_Update(1,0,2);
		        	  	verticals[2].getChildren().remove(G.get(2));	Local[2].setRotate(270);	verticals[2].getChildren().add(0,G.get(3));
		     	  		verticals[2].getChildren().remove(G.get(0));	Local[0].setRotate(270);	verticals[2].getChildren().add(2,G.get(1));
		     	  		verticals[3].getChildren().remove(G.get(1));	Local[1].setRotate(270);	verticals[3].getChildren().add(1,G.get(2));
		     	  		verticals[1].getChildren().remove(G.get(3));	Local[3].setRotate(270);	verticals[1].getChildren().add(1,G.get(0));
		          }
		      else if ( this.stats.get(2) == 2 )	// WARNING // instability in the construction //
		     	  { 	this.stats.remove(2);	this.stats.add(2,3);
		     	  		this.stats.remove(3);	this.stats.add(3,4);
		        	  	Turning_Update(2,1,3);
		        	  	verticals[2].getChildren().remove(G.get(3));	Local[3].setRotate(90 );
		     	  		verticals[2].getChildren().remove(G.get(1));	Local[1].setRotate(90 );
		     	  		verticals[3].getChildren().remove(G.get(2));	Local[2].setRotate(90 );
		     	  		verticals[1].getChildren().remove(G.get(0));	Local[0].setRotate(90 );
		     	  		verticals[2].getChildren().add(0,G.get(1));
		     	  		verticals[2].getChildren().add(2,G.get(3));
		     	  		verticals[3].getChildren().add(1,G.get(0));
		     	  		verticals[1].getChildren().add(1,G.get(2));
		     	  }
		      else if ( this.stats.get(2) == 3 )
		     	  { 	this.stats.remove(2);	this.stats.add(2,1);
		     	  		this.stats.remove(3);	this.stats.add(3,1);
		     	  		Turning_Update(0,2,1);
		        	  	verticals[2].getChildren().remove(G.get(1));	Local[2].setRotate( 0 );	verticals[2].getChildren().add(0,G.get(2));
		     	  		verticals[2].getChildren().remove(G.get(3));	Local[0].setRotate( 0 );	verticals[2].getChildren().add(2,G.get(0));
		     	  		verticals[3].getChildren().remove(G.get(0));	Local[1].setRotate( 0 );	verticals[3].getChildren().add(1,G.get(1));
		     	  		verticals[1].getChildren().remove(G.get(2));	Local[3].setRotate( 0 );	verticals[1].getChildren().add(1,G.get(3));
		     	  }
		}
		else if ( this.stats.get(1) == 4 )	// cas 4 joueurs //
		{
		           if ( this.stats.get(2) == 1 )
		     	  { 	this.stats.remove(2);	this.stats.add(2,2);
		     	  		this.stats.remove(3);	this.stats.add(3,2);
		     	  		Turning_Update(1,0,2);
		     	  		verticals[2].getChildren().remove(G.get(2));	Local[2].setRotate(270);	verticals[2].getChildren().add(0,G.get(3));
		     	  		verticals[2].getChildren().remove(G.get(0));	Local[0].setRotate(270);	verticals[2].getChildren().add(2,G.get(1));
		     	  		verticals[3].getChildren().remove(G.get(1));	Local[1].setRotate(270);	verticals[3].getChildren().add(1,G.get(2));
		     	  		verticals[1].getChildren().remove(G.get(3));	Local[3].setRotate(270);	verticals[1].getChildren().add(1,G.get(0));
		     	  }
			  else if ( this.stats.get(2) == 2 )
			      {		this.stats.remove(2);	this.stats.add(2,3);
			      		this.stats.remove(3);	this.stats.add(3,3);
			      		Turning_Update(2,1,3);
			      		verticals[2].getChildren().remove(G.get(3));	Local[2].setRotate(180);	verticals[2].getChildren().add(0,G.get(0));
			      		verticals[2].getChildren().remove(G.get(1));	Local[0].setRotate(180);	verticals[2].getChildren().add(2,G.get(2));
			      		verticals[3].getChildren().remove(G.get(2));	Local[1].setRotate(180);	verticals[3].getChildren().add(1,G.get(3));
			      		verticals[1].getChildren().remove(G.get(0));	Local[3].setRotate(180);	verticals[1].getChildren().add(1,G.get(1));
			      
			      }
			  else if ( this.stats.get(2) == 3 )
			      { 	this.stats.remove(2);	this.stats.add(2,4);
			      		this.stats.remove(3);	this.stats.add(3,4);
			      		Turning_Update(3,2,4);
			      		verticals[2].getChildren().remove(G.get(0));	Local[2].setRotate(90 );	verticals[2].getChildren().add(0,G.get(1));
			      		verticals[2].getChildren().remove(G.get(2));	Local[0].setRotate(90 );	verticals[2].getChildren().add(2,G.get(3));
			      		verticals[3].getChildren().remove(G.get(3));	Local[1].setRotate(90 );	verticals[3].getChildren().add(1,G.get(0));
			      		verticals[1].getChildren().remove(G.get(1));	Local[3].setRotate(90 );	verticals[1].getChildren().add(1,G.get(2));
			      }
			  else if ( this.stats.get(2) == 4 )
			      { 	this.stats.remove(2);	this.stats.add(2,1);
			      		this.stats.remove(3);	this.stats.add(3,1);
			      		Turning_Update(0,3,1);
			      		verticals[2].getChildren().remove(G.get(1));	Local[2].setRotate( 0 );	verticals[2].getChildren().add(0,G.get(2));
			      		verticals[2].getChildren().remove(G.get(3));	Local[0].setRotate( 0 );	verticals[2].getChildren().add(2,G.get(0));
			      		verticals[3].getChildren().remove(G.get(0));	Local[1].setRotate( 0 );	verticals[3].getChildren().add(1,G.get(1));
			      		verticals[1].getChildren().remove(G.get(2));	Local[3].setRotate( 0 );	verticals[1].getChildren().add(1,G.get(3));
			      }
		}
	}
	public void City_Update(int current_player)
	{
		int card = this.CardsList.get(current_player-1).get(this.eventctrl.Get_Input()[0]);
		int bloc = this.eventctrl.Get_Input()[1]+1;
		int qart = this.eventctrl.Get_Input()[2];
		int memo = 0;
		int rev_bloc = 0;
		if ( current_player == 3 || current_player == 4 )
		{ switch(bloc)	{ case 1: rev_bloc = 4; break;  case 2: rev_bloc = 3; break;  case 3: rev_bloc = 2; break;  case 4: rev_bloc = 1; break; } }
		else
		{ rev_bloc = bloc; }
		
		// add color change effect //
		
		int temp = this.BlocsList.get(current_player-1).get(bloc-1);
		this.BlocsList.get(current_player-1).remove(bloc-1);
		this.BlocsList.get(current_player-1).add(bloc-1,temp-1);
		this.labellist[current_player][rev_bloc-1].setText("*"+ this.BlocsList.get(current_player-1).get(bloc-1));	// DONT TOUCH THAT //
		
		switch(card)
		{
			case 1:
				memo = this.Towerlist[qart][0][0][1];
				this.Towerlist[qart][0][0][1] = memo + bloc;
				this.quarterctrl[qart][0].setText(String.valueOf(this.Towerlist[qart][0][0][1]));;
				break;
			case 2:
				memo = this.Towerlist[qart][1][0][1];
				this.Towerlist[qart][1][0][1] = memo + bloc;
				this.quarterctrl[qart][3].setText(String.valueOf(this.Towerlist[qart][1][0][1]));;
				break;
			case 3:
				memo = this.Towerlist[qart][2][0][1];
				this.Towerlist[qart][2][0][1] = memo + bloc;
				this.quarterctrl[qart][6].setText(String.valueOf(this.Towerlist[qart][2][0][1]));;
				break;
			case 4:
				memo = this.Towerlist[qart][0][1][1];
				this.Towerlist[qart][0][1][1] = memo + bloc;
				this.quarterctrl[qart][1].setText(String.valueOf(this.Towerlist[qart][0][1][1]));;
				break;
			case 5:
				memo = this.Towerlist[qart][1][1][1];
				this.Towerlist[qart][1][1][1] = memo + bloc;
				this.quarterctrl[qart][4].setText(String.valueOf(this.Towerlist[qart][1][1][1]));;
				break;
			case 6:
				memo = this.Towerlist[qart][2][1][1];
				this.Towerlist[qart][2][1][1] = memo + bloc;
				this.quarterctrl[qart][7].setText(String.valueOf(this.Towerlist[qart][2][1][1]));;
				break;	
			case 7:
				memo = this.Towerlist[qart][0][2][1];
				this.Towerlist[qart][0][2][1] = memo + bloc;
				this.quarterctrl[qart][2].setText(String.valueOf(this.Towerlist[qart][0][2][1]));;
				break;
			case 8:
				memo = this.Towerlist[qart][1][2][1];
				this.Towerlist[qart][1][2][1] = memo + bloc;
				this.quarterctrl[qart][5].setText(String.valueOf(this.Towerlist[qart][1][2][1]));;
				break;
			case 9:
				memo = this.Towerlist[qart][2][2][1];
				this.Towerlist[qart][2][2][1] = memo + bloc;
				this.quarterctrl[qart][8].setText(String.valueOf(this.Towerlist[qart][2][2][1]));;
				break;
		}
	}
	
	
	public void Turning_Update(int a,int b,int plynxt) throws MalformedURLException	// reverse backside - frontside //
	{
		if ( this.stats.get(plynxt+7) == 0 )
	  	{
			this.Gimg[a][0].setImage(Card_Update(a,0,true ));		this.Gimg[a][1].setImage(Card_Update(a,1,true ));
			this.Gimg[a][2].setImage(Card_Update(a,2,true ));		this.Gimg[a][3].setImage(Card_Update(a,3,true ));
	  	}
		else
		{
			this.Gimg[b][0].setImage(Card_Update(b,0,false));		this.Gimg[b][1].setImage(Card_Update(b,1,false));
	  		this.Gimg[b][2].setImage(Card_Update(b,2,false));		this.Gimg[b][3].setImage(Card_Update(b,3,false));
		}
	}
	
	public Image Card_Update(int j, int k, boolean stat) throws MalformedURLException	// true = shows // false = hides //
	{
		File file = null;
		     if ( stat == true  )	{ file = new File("src\\Cards_view\\carte"+ this.CardsList.get(j).get(k) +".JPG"); }
		else if ( stat == false )	{ file = new File("src\\Cards_view\\carteDos.JPG"); }
		Image I = new Image(file.toURI().toURL().toString());
		return I;
	}
	
	public Image Card_Control(int py,int card,int player,double a, double b,int rotate,List<Integer> list) throws MalformedURLException	// true = to backside // false = to frontside //
	{
		ImageView IV = null;
		
		if( player == 1 && this.stats.get(8) == 0 )
		{
			File file = new File("src\\Cards_view\\carte"+ this.CardsList.get(player-1).get(card) +".JPG");
			Image I = new Image(file.toURI().toURL().toString());
			IV = new ImageView(I);
			this.Gimg[py][card] = IV;
		}
		else
		{
			File file = new File("src\\Cards_view\\carteDos.JPG");
			Image I = new Image(file.toURI().toURL().toString());
			IV = new ImageView(I);
			this.Gimg[py][card] = IV;
		}
		IV.setFitHeight(a);
		IV.setFitWidth (b);
		IV.setRotate(rotate);
		this.Gimg[py][card] = IV;
		this.Gimg[py][card].setOnMousePressed (event -> { eventctrl.OnClick_Event_Handler(this.Gimg[py][card],this.stats.get(3),player,card,1,true ); });
		this.Gimg[py][card].setOnMouseReleased(event -> { eventctrl.OnClick_Event_Handler(this.Gimg[py][card],this.stats.get(3),player,card,1,false); });
		return IV.getImage();
	}
	
	public void Card_List_Updtate(List<Integer> cartes, int player)
	{
		
	}
}