package animatedball;

import java.util.Random;
import javax.swing.SwingUtilities;

public class AnimatedBallApp extends javax.swing.JFrame {
    private Thread updateThread;
    private boolean running;
    private int xPosition, yPosition;
    private int xMoveSpeed = 40, yMoveSpeed = 40;
    final int fieldWidth;
    final int fieldHeight;

    public AnimatedBallApp() {
        initComponents();
        
        fieldWidth = jLabel1.getWidth();
        fieldHeight = jLabel1.getHeight();
        
        running = true;
        startUpdateThread();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Ball.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(jLabel1)
                .addContainerGap(200, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel1)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnimatedBallApp().setVisible(true);
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
                            xPosition += xMoveSpeed;
                            yPosition += yMoveSpeed;

                            int currentWidth = getWidth();
                            int currentHeight = getHeight();
                            
                            if (xPosition <= 0 || xPosition >= currentWidth){
                                xMoveSpeed = -xMoveSpeed;
                                xPosition = Math.max(0, Math.min(xPosition, currentWidth - fieldWidth));
                            }
                            
                            if (yPosition <= 0 || yPosition >= currentHeight){
                                yMoveSpeed = -yMoveSpeed;
                                yPosition = Math.max(0, Math.min(yPosition, currentHeight - fieldHeight));
                            }

                            jLabel1.setLocation(xPosition, yPosition);
                          }
                      });
                      Thread.sleep(50);
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
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
