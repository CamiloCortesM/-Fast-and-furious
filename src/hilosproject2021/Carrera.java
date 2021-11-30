/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilosproject2021;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Carrera extends Thread {
    private JLabel car;
    private JframeGame p; 
    private int lauc=0;

    
    public Carrera(JLabel car, JframeGame p){
        this.car=car;
        this.p=p;
    }
    @Override
    public void run(){
        int c1=0, c2=0, c3=0, c4=0,c5=0;
        int a = 0;
        while (true) {
                try {
                    sleep((int)(Math.random()*250));
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
                }
                c1=p.getCar1().getLocation().x;
                c2=p.getCar2().getLocation().x;
                c3=p.getCar3().getLocation().x;
                c4=p.getCar4().getLocation().x;
                c5=p.getCar5().getLocation().x;
                
                int r = (int) (Math.random()*11)+2;
              if(c1>=150  && c2>=150 && c3>=150&&c4>=150 &&c5>=150 ){
                   Timer timer2 = new Timer();
                   TimerTask tarea2 = new TimerTask() {
                       public void run() {
                             p.NextGameEnabled(true);
                           }

                   };
                   timer2.schedule(tarea2, 1000);
                              
                   break;
               }else
                {
                 if(car.getLocation().x>=150){
                 }
                 else{
                   lauc+=1;
                   car.setLocation(car.getLocation().x+r,car.getLocation().y);
                   p.upgradeLauc(lauc, car);
                   a=a+r;
                   p.PoComplete(a,car);
                   p.scoreGame(a, car);
                   if(car.getLocation().x>=150){
                       if(car.getLocation().x==150){
                           lauc=0;
                           p.PoComplete(150,car);
                           p.scoreGame(150, car);
                           p.Victory(car);
                       }
                       else{
                            car.setLocation(150,car.getLocation().y);
                             lauc=0;
                             p.PoComplete(150,car);
                             p.scoreGame(150, car);
                             p.Victory(car);
                       }
                   }
                   p.repaint();
                 }
                    }
        }
        if (car.getLocation().x>=150){
            
        }
}
}