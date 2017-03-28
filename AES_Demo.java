//CSI 526 UAlbany
//Programming assignment 2
//Arnoldas Kurbanovas

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package crypto.assignment.two;


import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.Arrays;
import java.util.logging.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;
import javax.crypto.*;
import javax.imageio.ImageIO;
import java.nio.*;
import java.nio.file.Files;
import java.net.*;
import java.awt.Toolkit;

import javax.imageio.ImageIO;

import java.awt.image.*;

@SuppressWarnings({ "serial", "unused" })
public class AES_Demo extends javax.swing.JFrame {

  
    public AES_Demo() {
        initComponents();
    }

    
    //method i created to convert from a 1D single int array to a single byte array=
    public static byte[] intToByteArr(int[] intArr){
    	final ByteBuffer buffer = ByteBuffer.allocate(intArr.length * 4).order(ByteOrder.LITTLE_ENDIAN);
    	buffer.asIntBuffer().put(intArr);
    	return buffer.array();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jFileChooser2 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Browse Files");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Decryption Time (ms)");

        jLabel2.setText("Encryption Time (ms)");

        jLabel3.setText("Encryption");

        jButton2.setText("Begin AES Pixel By Pixel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton2ActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jButton3.setText("Choose Save Directory");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(207, 207, 207)
                                .addComponent(jButton2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(20, 20, 20))
        );

        jRadioButton1.setText("Preserve Image Header");
        jRadioButton2.setText("Reduced AES - 4 rounds");
        

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jRadioButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(154, 154, 154)
                            .addComponent(jRadioButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton1)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.getAccessibleContext().setAccessibleName("Encryption");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_jButton2ActionPerformed
     int x1 = 0, x2 = 0, x3 = 0, x4 = 0;
     boolean boolx = false;
     String file_path = jTextField1.getText();
     
     //File input_image_file = new File(file_path);
     File input_image_fileNew = new File(file_path);
     
     String out_path1 = jTextField4.getText() + "\\" +"encypted.jpg"; 
     String out_path2 = jTextField4.getText() + "\\" + "decypted.jpg";
     
     String key_st = "keyforaesencryptionanddecryption";
     
     byte[] key = key_st.getBytes();
     key = Arrays.copyOf(key, 16);
     
     File fi = new File(file_path);     
     
     //adding code to read in image pixel by pixel
     BufferedImage image = ImageIO.read(input_image_fileNew);
     
     int width = image.getWidth();
     int hight = image.getHeight();
     
   //  int[] rgbIntArr = image.getRGB(0, 0, width, hight, null, 0, width);
     
     //pixel matrix of RGBa
     int[][][] rgbaOut = new int[hight][width][4];
     
     //System.out.println("rgbaOut: "+rgbaOut);
     
     for(int x = 0; x<image.getWidth(); x++){
    	 
    	 for(int y =0; y<image.getHeight(); y++){
    		//color object to split the values of red green blue and alpha
    	     Color color = new Color(image.getRGB(x, y), true);
    	     rgbaOut[y][x][0] = color.getRed();
    	     //System.out.println("rgbaOut[y][x][0] red: " + rgbaOut[y][x][0]);
    	     rgbaOut[y][x][1]= color.getGreen();
    	     //System.out.println("rgbaOut[y][x][1] green: " + rgbaOut[y][x][1]);
    	     rgbaOut[y][x][2] = color.getBlue();
    	     //System.out.println("rgbaOut[y][x][2] blue: " + rgbaOut[y][x][2]);
    	     rgbaOut[y][x][3]= color.getAlpha();
    	     //System.out.println("rgbaOut[y][x][3] alpha: " + rgbaOut[y][x][3]);
    	 }
     }
     
     //System.out.println(rgbIntArr.length);
     
     //color object to split the values of red green blue and alpha
     //Color color = new Color(rgbIntArr[rgbIntArr.length]);
     
     //here
    // System.out.println(color.getRed());
    // System.out.println(color.getAlpha());
     
     //convert from a 3d array to a 1d array
     int[] singleArr = new int[rgbaOut.length*rgbaOut.length*rgbaOut.length];
     //flattening down my 3d array to a 1d array
     int a = 0;
     for(int i =0; i< rgbaOut.length; i++){
    	 for(int j=0; j< rgbaOut.length; j++){
    		 for(int k=0; k<4; k++){
    			 singleArr[a]= rgbaOut[i][j][k];
    			 //System.out.println("singleArr: "+singleArr[a]);
    			 a++;
    		 }
    	 }
     }
    
     //here now
     //intToByteArr
     byte[] input_data;
     input_data = intToByteArr(singleArr);
     
     //checking byte vals
     for(int z=0; z<input_data.length ; z++){
    	 //System.out.println("byte input_data values: "+ input_data[z]);
     }
     
     //Image input_image = Toolkit.getDefaultToolkit().getImage(file_path);
     //byte[] input_data;
     
     
     byte[] output_data_encrypt;
     byte[] output_data_decrypt;
     long start_time,end_time,encrypt_time = 0,decrypt_time = 0;
     try {
      if (!jRadioButton1.isSelected()) {
       if (!jRadioButton2.isSelected()) {
        input_data = Files.readAllBytes(fi.toPath());
        start_time = System.currentTimeMillis();
        output_data_encrypt = AES.encrypt(input_data, key);
        end_time = System.currentTimeMillis();
        encrypt_time = end_time - start_time;
        FileOutputStream fout = new FileOutputStream(out_path1);
        fout.write(output_data_encrypt);
        start_time = System.currentTimeMillis();
        output_data_decrypt = AES.decrypt(output_data_encrypt, key);
        end_time = System.currentTimeMillis();
        decrypt_time = end_time - start_time;
        FileOutputStream fout1 = new FileOutputStream(out_path2);
        fout1.write(output_data_decrypt);
        fout.close();
        fout1.close();
       }
       if (jRadioButton2.isSelected()) {
        input_data = Files.readAllBytes(fi.toPath());
        start_time = System.currentTimeMillis();
        output_data_encrypt = AES.encrypt_r(input_data, key);
        end_time = System.currentTimeMillis();
        encrypt_time = end_time - start_time;
        FileOutputStream fout = new FileOutputStream(out_path1);
        fout.write(output_data_encrypt);
        start_time = System.currentTimeMillis();
        output_data_decrypt = AES.decrypt_r(output_data_encrypt, key);
        end_time = System.currentTimeMillis();
        decrypt_time = end_time - start_time;
        FileOutputStream fout1 = new FileOutputStream(out_path2);
        fout1.write(output_data_decrypt);
        fout.close();
        fout1.close();
       }
      }
      if (jRadioButton1.isSelected()) {
       if (!jRadioButton2.isSelected()) {
        int bmp_header = 54;
        input_data = Files.readAllBytes(fi.toPath());
        byte[] input_data1 = Arrays.copyOfRange(input_data, bmp_header, input_data.length);
        start_time = System.currentTimeMillis();
        output_data_encrypt = AES.encrypt(input_data1, key);
        end_time = System.currentTimeMillis();
        encrypt_time = end_time - start_time;
        FileOutputStream fout = new FileOutputStream(out_path1);
        byte[] output_array = new byte[input_data.length+16];
        System.out.println("fine1");
        //System.out.println("input:" + input_data.length + "input1:" + input_data1.length + "outputdat" + output_data_encrypt.length + "outputarray" + output_array.length);
        System.arraycopy(input_data, 0, output_array, 0, bmp_header);
        System.out.println("fine2");
        System.arraycopy(output_data_encrypt, 0, output_array, bmp_header, output_data_encrypt.length);
        System.out.println("fine3");
        fout.write(output_array);
        start_time = System.currentTimeMillis();
        output_data_decrypt = AES.decrypt(output_data_encrypt, key);
        end_time = System.currentTimeMillis();
        decrypt_time = end_time - start_time;
        FileOutputStream fout1 = new FileOutputStream(out_path2);
        byte[] output_array1 = new byte[input_data.length+16];
        System.arraycopy(input_data, 0, output_array1, 0, bmp_header);
        System.arraycopy(output_data_decrypt, 0, output_array1, bmp_header, output_data_decrypt.length);
        fout1.write(output_array1);
        fout.close();
        fout1.close();
       }
       if (jRadioButton2.isSelected()) {
        int bmp_header = 54;
        input_data = Files.readAllBytes(fi.toPath());
        byte[] input_data1 = Arrays.copyOfRange(input_data, bmp_header, input_data.length);
        start_time = System.currentTimeMillis();
        output_data_encrypt = AES.encrypt_r(input_data1, key);
        end_time = System.currentTimeMillis();
        encrypt_time = end_time - start_time;
        FileOutputStream fout = new FileOutputStream(out_path1);
        byte[] output_array = new byte[input_data.length+16];
        System.arraycopy(input_data, 0, output_array, 0, bmp_header);
        System.arraycopy(output_data_encrypt, 0, output_array, bmp_header, output_data_encrypt.length);
        fout.write(output_array);
        start_time = System.currentTimeMillis();
        output_data_decrypt = AES.decrypt_r(output_data_encrypt, key);
        end_time = System.currentTimeMillis();
        decrypt_time = end_time - start_time;
        FileOutputStream fout1 = new FileOutputStream(out_path2);
        byte[] output_array1 = new byte[input_data.length+16];
        System.arraycopy(input_data, 0, output_array1, 0, bmp_header);
        System.arraycopy(output_data_decrypt, 0, output_array1, bmp_header, output_data_decrypt.length);
        fout1.write(output_array1);
        fout.close();
        fout1.close();
       }
      }
  } catch (IOException e) {
   //System.out.println("input:" + input_data.length + "input1:" + input_data1.length + "outputdat" + output_data_encrypt.length);
   System.out.println(e);
   //e.printStackTrace();
  }
     
     jTextField2.setText(Long.toString(encrypt_time)); //decryption time
     jTextField3.setText(Long.toString(decrypt_time)); //encryption time
     JOptionPane.showMessageDialog(null, "Encryption and decryption is done !!");
     
      /* To write code for  for encryption & decryption here... */
      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // file chooser to choose image (Browse)
        int returnVal = jFileChooser1.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            File file = jFileChooser1.getSelectedFile();
            if (!file.canRead()) {
                file.setReadable(true);
            }

            // display file name in text field
            jTextField1.setText(file.getAbsolutePath());

        } else
        {
            System.out.println("You must choose a file.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jFileChooser2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = jFileChooser2.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            File file = jFileChooser2.getSelectedFile();
            if (!file.canRead()) {
                file.setReadable(true);
            }
            // display file name in text field
            jTextField4.setText(file.getAbsolutePath());

        } else
        {
            System.out.println("You must choose a save directory.");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AES_Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AES_Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AES_Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AES_Demo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AES_Demo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
