/**
 * @author Erick Willy and Tyrone Damasceno 
 * @version infoVersão: Alpha 0.8
 **/



package br.ufrn.imd.lp2.tests;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map.Entry;

import br.ufrn.imd.lp2.domain.Network;
import br.ufrn.imd.lp2.domain.ThreatDetector;
import br.ufrn.imd.lp2.exceptions.NotUserFoundException;
import br.ufrn.imd.lp2.gui.MainScreen;
import br.ufrn.imd.lp2.io.Activity;
import br.ufrn.imd.lp2.io.PC;
import br.ufrn.imd.lp2.io.Profile;
import br.ufrn.imd.lp2.io.ReadDate;
import br.ufrn.imd.lp2.io.Reader;
import br.ufrn.imd.lp2.io.User;

/*
 * Main application class, create a new MainScreen instance and start it
 * **/

public class Main {
	
	public static void main(String[] args) throws NotUserFoundException, ParseException {
	
		MainScreen tela = new MainScreen();
		tela.setVisible(true);			
	}
	
}
