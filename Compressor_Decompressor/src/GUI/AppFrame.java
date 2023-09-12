package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import comp_decomp.Compressor;
import comp_decomp.Decompressor;

@SuppressWarnings("serial")
public class AppFrame extends JFrame implements ActionListener{
JButton compressButton;
JButton decompressButton;
AppFrame(){
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	compressButton = new JButton("select file to compress");
	compressButton.setBounds(20,100,200,30);
	compressButton.addActionListener(this);
	
	decompressButton = new JButton("select file to decompress");
	decompressButton.setBounds(50,100,200,30);
	decompressButton.addActionListener(this);
	
	this.add(compressButton);
	this.add(decompressButton);
	this.setSize(700,700);
	this.getContentPane().setBackground(Color.green);
	this.setVisible(true);
}
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==compressButton) {
		JFileChooser filechooser=new JFileChooser();
		int response=filechooser.showSaveDialog(null);
		if(response==JFileChooser.APPROVE_OPTION) {
			File file=new File(filechooser.getSelectedFile().getAbsolutePath());
			System.out.print(file);
			try {
				Compressor.method(file);
				
			}catch(Exception ee) {
				JOptionPane.showMessageDialog(null, ee.toString());
			}
		}
		
	}
	
	if(e.getSource()==decompressButton) {
		JFileChooser filechooser=new JFileChooser();
		int response=filechooser.showSaveDialog(null);
		if(response==JFileChooser.APPROVE_OPTION) {
			File file=new File(filechooser.getSelectedFile().getAbsolutePath());
			System.out.print(file);
			try {
				Decompressor.method(file);
				
			}catch(Exception ee) {
				JOptionPane.showMessageDialog(null, ee.toString());
			}
		}
		
	}
	 
}

}
