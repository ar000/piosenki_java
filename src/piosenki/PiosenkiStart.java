package piosenki;

import java.awt.EventQueue;



public class PiosenkiStart {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Logic();
            }
        });
	}

}
