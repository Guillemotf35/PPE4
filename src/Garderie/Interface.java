package Garderie;

import java.awt.* ;
import java.awt.event.* ;
import javax.swing.* ;

class MaFenetre extends JFrame implements ActionListener
{ 
  private JLabel labNom, labTotal ;
  private JTextField nom ;
  static private String etiqNom = "Nom responsable légal : ", etiqTotal = "Total facture : ";
  private JButton boutonCalcul ;
	
  public MaFenetre ()
  {
	setTitle ("Garderie") ;
    setSize (400, 200) ;
    Container contenu = getContentPane() ;
    contenu.setLayout (new FlowLayout() ) ;

    labNom = new JLabel (etiqNom) ;
    contenu.add(labNom) ;
    nom = new JTextField (10) ;
    contenu.add(nom) ;
    boutonCalcul = new JButton ("CALCUL") ;
    contenu.add(boutonCalcul) ;
    boutonCalcul.addActionListener(this) ;
    labTotal = new JLabel (etiqTotal) ;
    contenu.add(labTotal) ;
  }

@Override
public void actionPerformed(ActionEvent e) {
	if (e.getSource() == boutonCalcul)
	    try
	    { 
	    	Double total = 0.0 ;
//	    	total = getPrixTotal();
	    	labTotal.setText (etiqTotal + total) ;
	    }
	    catch (NumberFormatException ex)
	    { 
	    	nom.setText ("") ;
	    	labTotal.setText (etiqTotal) ;
	    }
	}
}


public class Interface {
	 public static void main (String args[])
	  { 
		 Garderie test = new Garderie();
		 MaFenetre fen = new MaFenetre() ;
	    fen.setVisible(true) ;
	  }
	
	
}
