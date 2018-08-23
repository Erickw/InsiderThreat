/**
 * @author Erick Willy and Tyrone Damasceno 
 * @version infoVersion: 1.0
 **/

package br.ufrn.imd.lp2.gui;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.ufrn.imd.lp2.domain.Network;
import br.ufrn.imd.lp2.exceptions.NotUserFoundException;
import br.ufrn.imd.lp2.io.Profile;


/**
 * This class take care of all interaction at suspActivities screen
 * @param rede Attribute that allocate Network Instance
 * */


public class MainScreen extends JFrame {
	
	
	Network rede;

/**
 * Class constructor
 * This class take care of all interaction at listActivities screen
 * @param container It's the container that holds the elements of the first screen class 
 * @param open Button that call the options to input the directories and read log files
 * @param find Button that call the options to search a user by id
 * @param filter Button that call the options to search activities by day or period 
 * @param listSuspect Button that list all suspected users
 * @param fileName Display window responsible to get the directories files to be read
 * @param tFileUser TextField responsible input the directory UserLogs file to be read
 * @param TextField responsible input the directory ActivitiesLogs file to be read
 * @param nameUser Label that indicate the user where input the directory UserLogs
 * @param nameActivity Label that indicate the user where input the directory ActivitiesLogs
 * @param Button that confirm the directories inputed by the user
 * @param findScrn Instance that attribute a findScreen Object
 * @param listScrn Instance that attribute a listActivitiesScreen Object
 * @param suspScrn Instance that attribute a suspectScreen Object 
 * @param alert Alert Window that report exception and error from the method
 **/
	
	
	public MainScreen() {
		
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(2,6));
		
		setSize(600,350);
		setTitle("Análise de Perfis de Usuários");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JButton open  = new JButton("Abrir e Processar Arquivos");
		JButton find = new JButton("Buscar Usuário Por ID");
		JButton filter = new JButton("Filtrar Atividades Por Data");
		JButton listSuspect = new JButton("Listar Usuários Suspeitos");
		container.add(open);
		container.add(find);
		container.add(filter);
		container.add(listSuspect);	
		
		
		rede = Network.getInstance();
		
		open.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFrame fileName = new JFrame();
				JTextField tFileUser  = new JTextField();
				JTextField tFileActivity  = new JTextField();
				JLabel nameUser = new JLabel("Insira o diretório do arquivo de Usuário");
				JLabel nameActivity = new JLabel("Insira o diretório do arquivo de Activity");
				JButton ok = new JButton("OK");
				
				fileName.setLayout(null);
				fileName.setVisible(true);
				fileName.setTitle("Informações do Usuário");	
				fileName.setSize(650 , 200);
				
				fileName.add(tFileUser);
				fileName.add(tFileActivity);
				fileName.add(nameUser);
				fileName.add(nameActivity);
				fileName.add(ok);
				
				tFileUser.setBounds(300, 20, 340, 30);
				tFileActivity.setBounds(300, 60, 340, 30);			
				nameUser.setBounds(10, 20, 340, 30);
				nameActivity.setBounds(10, 60, 340, 30);
				ok.setBounds(540, 100 , 100, 30);
		
				
				ok.addActionListener(new ActionListener() {
					
				@Override
				public void actionPerformed(ActionEvent e) {
					
					try {
						
						String sFileUser = tFileUser.getText(); 
						String sFileActivity = tFileActivity.getText();
						rede.readUsers(sFileUser);
						rede.readActivities(sFileActivity);
						JFrame alert = new JFrame();
					    JOptionPane.showMessageDialog(alert, "Arquivos lidos com sucesso!");
					    alert.dispose();
					    fileName.dispose();
					    
					} catch (Exception e1) {
						JFrame alert = new JFrame();
					    JOptionPane.showMessageDialog(alert, "Arquivo ou Diretório não encontrado!");
					}
				}
				
				});

			}
		});

		find.addActionListener(new ActionListener() {
			
			@Override	
			public void actionPerformed(ActionEvent x) {
			
				try{
					findScreen findScrn = new findScreen();
					findScrn.setVisible(true);
					findScrn.setHash(rede.getNetwork());
				}	
				catch (Exception e1) {
					JFrame alert = new JFrame();
				    JOptionPane.showMessageDialog(alert, "Error");
				}
			}
		});
		
		filter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				try{
					listActivitiesScreen listScrn = new listActivitiesScreen();
					listScrn.setVisible(true);
					listScrn.setHash(rede.getNetwork());
				}	
				catch (Exception e1) {
					JFrame alert = new JFrame();
				    JOptionPane.showMessageDialog(alert, "Error");
				}
			}
		});
		
		listSuspect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				try{
					suspectScreen suspScrn = new suspectScreen();
					suspScrn.setVisible(true);
				}	
				catch (Exception e1) {
					JFrame alert = new JFrame();
				    JOptionPane.showMessageDialog(alert, "Não existem usuários para serem exibidos");
				}
			}


		});
		}
		
	
	
}