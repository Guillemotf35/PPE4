package Garderie;

import java.awt.* ;
import java.awt.event.* ;
import java.sql.SQLException;
import java.util.Scanner;

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
	    	Garderie test = new Garderie();
	    	test.setNom(nom.getText());
	    	test.listPersons();
	    	Double total = 0.0 ;
	    	total = test.getPrixTotal();
	    	labTotal.setText (etiqTotal + total) ;
	    }
	    catch (NumberFormatException | SQLException ex)
	    { 
	    	nom.setText ("") ;
	    	labTotal.setText (etiqTotal) ;
	    }
	}
}


public interface garderieInterface {
	 public static void main (String args[]) throws SQLException
	  { 
		 
		 MaFenetre fen = new MaFenetre() ;
		 fen.setVisible(true) ;
//		 
//         test.listPersons();
//         
//		 test.getPrixTotal();
//		 test.setPrixTotal(42.0);
//		 System.out.println(test.getPrixTotal());

	  }
	
	
}

