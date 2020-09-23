/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author rashdaamir
 */
public class ControlPanel extends javax.swing.JPanel {
    
    private Game game;
    private int pause;

    /**
     * Creates new form ControlPanel
     * @param game
     */
    public ControlPanel(Game game) {
        initComponents();
        this.game = game;
        pause = 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NextLevel = new javax.swing.JButton();
        RestartLevel = new javax.swing.JButton();
        Pause = new javax.swing.JButton();
        Resume = new javax.swing.JButton();
        Quit = new javax.swing.JButton();

        NextLevel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/skipicon.png"))); // NOI18N
        NextLevel.setText("Skip Level");
        NextLevel.setFocusable(false);
        NextLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextLevelActionPerformed(evt);
            }
        });

        RestartLevel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/restart.png"))); // NOI18N
        RestartLevel.setText("Restart Level");
        RestartLevel.setToolTipText("");
        RestartLevel.setFocusable(false);
        RestartLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestartLevelActionPerformed(evt);
            }
        });

        Pause.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/pause.png"))); // NOI18N
        Pause.setText("Pause");
        Pause.setFocusable(false);
        Pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PauseActionPerformed(evt);
            }
        });

        Resume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/play.png"))); // NOI18N
        Resume.setText("Resume");
        Resume.setFocusable(false);
        Resume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResumeActionPerformed(evt);
            }
        });

        Quit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/quiticon.png"))); // NOI18N
        Quit.setText("Quit");
        Quit.setFocusable(false);
        Quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Quit)
                    .addComponent(NextLevel)
                    .addComponent(RestartLevel)
                    .addComponent(Resume)
                    .addComponent(Pause))
                .addGap(0, 41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pause)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Resume)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RestartLevel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NextLevel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Quit)
                .addContainerGap(135, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void NextLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextLevelActionPerformed
        game.goNextLevel();
    }//GEN-LAST:event_NextLevelActionPerformed

    private void RestartLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestartLevelActionPerformed
       game.restartLevel();
    }//GEN-LAST:event_RestartLevelActionPerformed

    private void PauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PauseActionPerformed
            game.getWorld().stop();;
        
//        if(pause == 1){
//            game.getWorld().start();
//            pause = 0;
//        } else {
//            game.getWorld().stop();
//            pause = 1;
//        }
    }//GEN-LAST:event_PauseActionPerformed

    private void ResumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResumeActionPerformed
        game.getWorld().start();
    }//GEN-LAST:event_ResumeActionPerformed

    private void QuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_QuitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton NextLevel;
    private javax.swing.JButton Pause;
    private javax.swing.JButton Quit;
    private javax.swing.JButton RestartLevel;
    private javax.swing.JButton Resume;
    // End of variables declaration//GEN-END:variables
}
