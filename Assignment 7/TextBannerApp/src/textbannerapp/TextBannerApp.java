package textbannerapp;

import javax.swing.SwingUtilities;

public class TextBannerApp extends javax.swing.JFrame {
    private Thread updateThread;
    private boolean running;
    private int xPosition;
    final private int moveSpeed = 80;

    public TextBannerApp() {
        initComponents();
        running = true;
        startUpdateThread();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setText("Hello, how are you?");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 281, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(144, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(134, 134, 134))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TextBannerApp().setVisible(true);
            }
        });
    }
    
    private void startUpdateThread(){
        updateThread = new Thread(new Runnable(){
            @Override
           public void run(){
               while(running){
                   try{
                      SwingUtilities.invokeLater(new Runnable() {
                          @Override
                          public void run(){
                            xPosition += moveSpeed;
                            int currentWidth = getWidth();

                            if (xPosition >= currentWidth) {
                                xPosition = 0;
                            }

                            jTextField1.setLocation(xPosition, jTextField1.getY());
                          }
                      });
                      Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       running = false;
                   }
               }
           }
        });
        updateThread.setDaemon(true); // Makes this a background thread
        updateThread.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
