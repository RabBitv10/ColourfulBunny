import javax.swing.*;

import java.awt.Color.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bunny implements ActionListener {
	JFrame ramka = new JFrame();
	JPanel panelPierwszejPlanszy = new JPanel();
	JPanel panelPierwszejPlanszyA = new JPanel();
	JPanel panelGlowny = new JPanel();
	JButton przycisk = new JButton();
	JPanel Informacje = new JPanel();
	JLabel poziom = new JLabel();
	JButton doZmian=new JButton();
	JButton doLevelu=new JButton();
	JButton doMenu=new JButton();
    int tablicaKolorow[];
	int iloscRuchow = 0;
	int nr=0;
	ImageIcon zmianaKolorow;
	ImageIcon koniecLevelu;
	JLabel ruchy = new JLabel("Wykonane ruchy:" + iloscRuchow);
	// JLabel pierwszyKrolik = new JLabel();
	String[] kroliki = new String[4];
	int pierwszyKrolikKolor = 0;
	JButton trzeciKrolik = new JButton();
	int drugiKrolikKolor = 1;
	JButton czwartyKrolik = new JButton();
	int trzeciKrolikKolor = 2;
	JButton drugiKrolik = new JButton();
	int czwartyKrolikKolor = 3;

	public Bunny(int[] tablicaWarunkow, int nrPoziomu, ImageIcon zmianaKolorow, ImageIcon koniecLevelu) {
		tablicaKolorow=tablicaWarunkow;
		nr=nrPoziomu;
		this.zmianaKolorow=zmianaKolorow;
		this.koniecLevelu=koniecLevelu;
	}
	public boolean Wykonane() {
		if (pierwszyKrolikKolor == tablicaKolorow[0] && drugiKrolikKolor == tablicaKolorow[1] && trzeciKrolikKolor == tablicaKolorow[2]
				&& czwartyKrolikKolor == tablicaKolorow[3]) {
			System.out.println("true");
			return true;
		}
		return false;

	}

	public void actionPerformed(ActionEvent a) {
		if(a.getSource()==doMenu) {
			//iloscRuchow=0;
			Levels twojeLevele1=new Levels();
			ramka.setVisible(false);
			twojeLevele1.pokazLevele();
		}

		// zawsze();
		else if (a.getSource() == przycisk) {
			zawsze();
			pierwszyKrolikKolor++;
			if (pierwszyKrolikKolor == kroliki.length)
				pierwszyKrolikKolor = 0;
			Krolik1();
			drugiKrolikKolor++;
			if (drugiKrolikKolor == kroliki.length)
				drugiKrolikKolor = 0;
			Krolik2();
			PierwszaPlansza();
			if(Wykonane()) {
			
				Wygrana();
			}
		
		} 
		
		else if (a.getSource() == drugiKrolik) {
			zawsze();
			drugiKrolikKolor++;
			if (drugiKrolikKolor == kroliki.length)
				drugiKrolikKolor = 0;
			Krolik2();
			czwartyKrolikKolor++;
			if (czwartyKrolikKolor == kroliki.length)
				czwartyKrolikKolor = 0;
			Krolik4();
			PierwszaPlansza();
			if(Wykonane()) {
		
				Wygrana();
			}
	
		} 
		
		else if (a.getSource() == trzeciKrolik) {
			zawsze();
			trzeciKrolikKolor++;
			if (trzeciKrolikKolor == kroliki.length)
				trzeciKrolikKolor = 0;
			Krolik3();
			pierwszyKrolikKolor++;
			if (pierwszyKrolikKolor == kroliki.length)
				pierwszyKrolikKolor = 0;
			Krolik1();
			PierwszaPlansza();
			if(Wykonane()) {
			
				Wygrana();
			}
	
		}
		
		else if (a.getSource() == czwartyKrolik) {
			zawsze();
			czwartyKrolikKolor++;
			if (czwartyKrolikKolor == kroliki.length)
				czwartyKrolikKolor = 0;
			Krolik4();
			trzeciKrolikKolor++;
			if (trzeciKrolikKolor == kroliki.length)
				trzeciKrolikKolor = 0;
			Krolik3();
			PierwszaPlansza();
			if(Wykonane()) {
			
				Wygrana();
			}

		}
	}

	public void zawsze() {
		iloscRuchow++;
		Informacje.remove(ruchy);
		Informacje.remove(doMenu);
		doMenu=null;
	
	}

	public void Wygrana()  {
		Wygrane jesliWygrasz=new Wygrane(nr,ramka);
		jesliWygrasz.wygrales(nr, iloscRuchow);
		//ramka.setVisible(false);
		przycisk = null;
		drugiKrolik = null;
		trzeciKrolik = null;
		czwartyKrolik = null;

	}

	//ustawia wyglad kr�lika u do�u po lewej
	public void Krolik3() {
		panelPierwszejPlanszyA.remove(trzeciKrolik);
		trzeciKrolik = null;
		trzeciKrolik = new JButton();
		panelPierwszejPlanszyA.add(trzeciKrolik);
		trzeciKrolik.setBackground(Color.white);
		Image fGB = (Toolkit.getDefaultToolkit().createImage(kroliki[trzeciKrolikKolor]));
		ImageIcon fairGreyBunny = new ImageIcon(fGB);
		trzeciKrolik.setIcon(fairGreyBunny);
	}

	//ustawia wygl�d kr�lika u do�u po prawej
	public void Krolik4() {
		panelPierwszejPlanszyA.remove(czwartyKrolik);
		czwartyKrolik = null;
		czwartyKrolik = new JButton();
		panelPierwszejPlanszyA.add(czwartyKrolik);
		czwartyKrolik.setBackground(Color.white);
		Image fGB = (Toolkit.getDefaultToolkit().createImage(kroliki[czwartyKrolikKolor]));
		ImageIcon fairGreyBunny = new ImageIcon(fGB);
		czwartyKrolik.setIcon(fairGreyBunny);
	}

	//ustawia wyglad kr�lika u g�ry po prawej
	public void Krolik2() {
		panelPierwszejPlanszy.remove(drugiKrolik);
		drugiKrolik = null;
		drugiKrolik = new JButton();
		panelPierwszejPlanszy.add(drugiKrolik);
		drugiKrolik.setBackground(Color.white);
		Image fGB = (Toolkit.getDefaultToolkit().createImage(kroliki[drugiKrolikKolor]));
		ImageIcon fairGreyBunny = new ImageIcon(fGB);
		drugiKrolik.setIcon(fairGreyBunny);
	}

	//ustawia wyglad kr�lika u g�ry po lewej
	public void Krolik1() {
		panelPierwszejPlanszy.remove(przycisk);
		przycisk = null;
		przycisk = new JButton();
		panelPierwszejPlanszy.add(przycisk);
		przycisk.setBackground(Color.white);
		Image fGB = (Toolkit.getDefaultToolkit().createImage(kroliki[pierwszyKrolikKolor]));
		ImageIcon fairGreyBunny = new ImageIcon(fGB);
		przycisk.setIcon(fairGreyBunny);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tab= {1,1,1,1};
	//	Bunny gra = new Bunny(tab);
//		gra.PierwszaPlansza();
	}

	public void PierwszaPlansza() {
		Font alfa = new Font("serif", Font.ITALIC, 24);
		ruchy= new JLabel("Wykonane ruchy:"+iloscRuchow);
		Informacje.setBackground(Color.white);
		kroliki[0] = "data/darkGreenBunny.jpg";
		kroliki[1] = "data/fairGreyBunny.jpg";
		kroliki[2] = "data/purpleBunny.jpg";
		kroliki[3] = "data/orangeBunny.jpg";
		ramka.setSize(1035, 885);
		ramka.setVisible(true);
		ramka.getContentPane().add(BorderLayout.CENTER, panelGlowny);
		panelGlowny.setLayout(new BoxLayout(panelGlowny,BoxLayout.Y_AXIS));
		panelGlowny.add(Informacje);
		doZmian.setIcon(zmianaKolorow);
		doZmian.setBackground(Color.WHITE);
		doLevelu.setIcon(koniecLevelu);
		doLevelu.setBackground(Color.WHITE);
		Informacje.add(doZmian);
		Informacje.add(doLevelu);
		poziom.setText("Level "+nr);
		poziom.setFont(alfa);
		Informacje.add(poziom);
		Informacje.remove(ruchy);
		Informacje.add(ruchy);
		ruchy.setFont(alfa);
	//	doMenu=null;
		doMenu=new JButton();
		Informacje.remove(doMenu);
		Informacje.add(doMenu);
		doMenu.setText("Wr�� do menu");
		doMenu.setBackground(Color.WHITE);
		doMenu.addActionListener(this);
		panelGlowny.add(panelPierwszejPlanszy);
		panelGlowny.add(panelPierwszejPlanszyA);
		panelPierwszejPlanszy.add(przycisk);
		panelPierwszejPlanszy.add(drugiKrolik);
		panelPierwszejPlanszyA.add(trzeciKrolik);
		panelPierwszejPlanszyA.add(czwartyKrolik);
		panelPierwszejPlanszy.setBackground(Color.white);
		panelPierwszejPlanszyA.setBackground(Color.white);
		panelGlowny.setBackground(Color.white);
		System.out.println(trzeciKrolikKolor);
		System.out.println(czwartyKrolikKolor);
		przycisk.setIcon(new ImageIcon((Toolkit.getDefaultToolkit().createImage(kroliki[pierwszyKrolikKolor]))));
		przycisk.addActionListener(this);
		drugiKrolik.setIcon(new ImageIcon((Toolkit.getDefaultToolkit().createImage(kroliki[drugiKrolikKolor]))));
		drugiKrolik.addActionListener(this);
		trzeciKrolik.setIcon(new ImageIcon((Toolkit.getDefaultToolkit().createImage(kroliki[trzeciKrolikKolor]))));
		trzeciKrolik.addActionListener(this);
		czwartyKrolik.setIcon(new ImageIcon((Toolkit.getDefaultToolkit().createImage(kroliki[czwartyKrolikKolor]))));
		czwartyKrolik.addActionListener(this);
		przycisk.setBackground(Color.white);
		drugiKrolik.setBackground(Color.white);
		trzeciKrolik.setBackground(Color.white);
		czwartyKrolik.setBackground(Color.white);
		ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
