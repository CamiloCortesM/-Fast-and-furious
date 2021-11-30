/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilosproject2021;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileNotFoundException;
import javax.swing.JLabel;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.table.DefaultTableModel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JframeGame extends javax.swing.JFrame {
    
    private String[] cars = {"Rojo","Azul","Amarillo","Verde","Naranja"};
    private Player[] pl = new Player[5];
    DefaultTableModel model;
    DefaultTableModel model2;
    int position = 1, a,b=0,game=1;
    private int[] pos = new int[5];
    private String[] namepos = new String[5];
    public JframeGame() {
        initComponents();
        NewGAME.setVisible(false);
        Rating.setVisible(false);
        NextGame.setVisible(false);
        lbl_barrera.setLocation(150, lbl_barrera.getLocation().y);
        this.setResizable(false);
        read();

        model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Puntos");
        model.addColumn("Nro Lanzamiento");
        model.addColumn("Posicion");
        model.addColumn("PuntosFaltantes");
        model.addColumn("Puntaje");
        model.addColumn("Hora");
        this.TableGame.setModel(model);
        for (int i = 0; i < pl.length; i++) {
            String[] info = new String[4];
            String result = pl[i].getUsername().replaceAll("^\"+|\"+$", "");
            info[0] = result;
            model.addRow(info);
        }
        model2 = new DefaultTableModel();
        this.TableFinalGame.setModel(model2);
        model2.addColumn("Name");
        model2.addColumn("Game1");
        model2.addColumn("Game2");
        model2.addColumn("Game3");
        model2.addColumn("Game4");
        model2.addColumn("Game5");
        model2.addColumn("Final Score");
        readPComplete();
        for (int i = 0; i < pl.length; i++) {
            String[] info = new String[7];
            String result = pl[i].getUsername().replaceAll("^\"+|\"+$", "");
            info[0] = result;
            model2.addRow(info);
        }
        Timer timer = new Timer();
        TimerTask tarea = new TimerTask() {

            public void run() {
                ZoneId zoneid1 = ZoneId.of("Asia/Tokyo");
                LocalTime id1 = LocalTime.now(zoneid1);
                String astrid = id1.getHour() + ":" + id1.getMinute() + ":" + id1.getSecond();
                model.setValueAt(astrid, 2, 6);

                ZoneId zoneid2 = ZoneId.of("Asia/Dubai");
                LocalTime id2 = LocalTime.now(zoneid2);
                String alejandra = id2.getHour() + ":" + id2.getMinute() + ":" + id2.getSecond();
                model.setValueAt(alejandra, 4, 6);

                ZoneId zoneid3 = ZoneId.of("Europe/Helsinki");
                LocalTime id3 = LocalTime.now(zoneid3);
                String daniel = id3.getHour() + ":" + id3.getMinute() + ":" + id3.getSecond();
                model.setValueAt(daniel, 1, 6);

                ZoneId zoneid4 = ZoneId.of("America/Bogota");
                LocalTime id4 = LocalTime.now(zoneid4);
                String diego = id4.getHour() + ":" + id4.getMinute() + ":" + id4.getSecond();
                model.setValueAt(diego, 3, 6);
                
                ZoneId zoneid5 = ZoneId.of("America/Yellowknife");
                LocalTime id5 = LocalTime.now(zoneid5);
                String camilo = id5.getHour() + ":" + id5.getMinute() + ":" + id5.getSecond();
                model.setValueAt(camilo, 0, 6);

            }
        };
        timer.schedule(tarea, 0, 1000);
        Timer timer2 = new Timer();
        TimerTask tarea2 = new TimerTask() {

            public void run() {
                if(game>5){
                    for(int i=0;i<5;i++){
                   //int valor = (int) model.getValueAt(i, 5);
                   String a = String.valueOf(model2.getValueAt(i, 1));
                   String b = String.valueOf(model2.getValueAt(i, 2));
                   String c = String.valueOf(model2.getValueAt(i, 3));
                   String d = String.valueOf(model2.getValueAt(i, 4));
                   String e = String.valueOf(model2.getValueAt(i, 5));
                    model2.setValueAt(Integer.valueOf(a)+Integer.valueOf(b)+Integer.valueOf(c)+Integer.valueOf(d)+Integer.valueOf(e), i, game);
                    }
                }
                else{
                      for(int i=0;i<5;i++){
                   //int valor = (int) model.getValueAt(i, 5);
                   String a = String.valueOf(model.getValueAt(i, 5));
                    model2.setValueAt(a, i, game);
                }
                } 
                }
                
            
        };
        timer2.schedule(tarea2, 0, 1000);
        model.setValueAt(0, 0, 2);
        model.setValueAt(0, 1, 2);
        model.setValueAt(0, 2, 2);
        model.setValueAt(0, 3, 2);
        model.setValueAt(0, 4, 2);
        model.setValueAt(0, 0, 5);
        model.setValueAt(0, 1, 5);
        model.setValueAt(0, 2, 5);
        model.setValueAt(0, 3, 5);
        model.setValueAt(0, 4, 5);
    }

    public void NextGameEnabled(boolean b) {
        NextGame.setEnabled(b);
    }

    public JLabel getCar1() {
        return car1;
    }

    public JLabel getCar2() {
        return car2;
    }

    public JLabel getCar3() {
        return car3;
    }

    public JLabel getCar4() {
        return car4;
    }

    public JLabel getCar5() {
        return car5;
    }

    public JLabel getlbl_barrera() {
        return lbl_barrera;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        car1 = new javax.swing.JLabel();
        car2 = new javax.swing.JLabel();
        car3 = new javax.swing.JLabel();
        lbl_barrera = new javax.swing.JLabel();
        car4 = new javax.swing.JLabel();
        car5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btiniciar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        NextGame = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableGame = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableFinalGame = new javax.swing.JTable();
        NewGAME = new javax.swing.JButton();
        Rating = new javax.swing.JButton();
        InfoPlayer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        car1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        car1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hilosproject2021/car1.png"))); // NOI18N
        car1.setMaximumSize(new java.awt.Dimension(50, 200));
        car1.setMinimumSize(new java.awt.Dimension(50, 200));

        car2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hilosproject2021/car2.png"))); // NOI18N

        car3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hilosproject2021/car3.png"))); // NOI18N

        lbl_barrera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hilosproject2021/finish.png"))); // NOI18N
        lbl_barrera.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        car4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hilosproject2021/car4.png"))); // NOI18N

        car5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hilosproject2021/car5.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(car4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(car3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(car2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(car1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(car5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(96, 96, 96)
                .addComponent(lbl_barrera)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(car1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(car2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(car3)
                .addGap(39, 39, 39)
                .addComponent(car4)
                .addGap(36, 36, 36)
                .addComponent(car5)
                .addContainerGap())
            .addComponent(lbl_barrera, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
        );

        jLabel1.setText("Rapidos y Furiosos ");

        btiniciar.setText("Iniciar Carrera");
        btiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btiniciarActionPerformed(evt);
            }
        });

        jButton1.setText("Acerca de.");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        NextGame.setText("Siguiente Partida");
        NextGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextGameActionPerformed(evt);
            }
        });

        TableGame.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "score", "Time"
            }
        ));
        TableGame.setEnabled(false);
        jScrollPane1.setViewportView(TableGame);

        TableFinalGame.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Game 1", "Game 2", "Game 3", "Game 4", "Game 5", "Final Score"
            }
        ));
        TableFinalGame.setEnabled(false);
        jScrollPane2.setViewportView(TableFinalGame);

        NewGAME.setText("Partida Nueva");
        NewGAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewGAMEActionPerformed(evt);
            }
        });

        Rating.setText("Clasificacion");
        Rating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RatingActionPerformed(evt);
            }
        });

        InfoPlayer.setText("Info.Jugadores");
        InfoPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InfoPlayerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NextGame, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NewGAME, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Rating, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(InfoPlayer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))))
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addGap(313, 313, 313)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btiniciar)
                    .addComponent(NextGame)
                    .addComponent(jButton1)
                    .addComponent(NewGAME)
                    .addComponent(Rating)
                    .addComponent(InfoPlayer))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btiniciarActionPerformed
        car1.setLocation(0, car1.getLocation().y);
        car2.setLocation(0, car2.getLocation().y);
        car3.setLocation(0, car3.getLocation().y);
        car4.setLocation(0, car4.getLocation().y);
        car5.setLocation(0, car5.getLocation().y);
        Carrera hilo1 = new Carrera(car1, this);
        Carrera hilo2 = new Carrera(car2, this);
        Carrera hilo3 = new Carrera(car3, this);
        Carrera hilo4 = new Carrera(car4, this);
        Carrera hilo5 = new Carrera(car5, this);
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        btiniciar.setVisible(false);
        NextGame.setVisible(true);
        NextGame.setEnabled(false);
    }//GEN-LAST:event_btiniciarActionPerformed

    private void NextGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextGameActionPerformed
        car1.setLocation(0, car1.getLocation().y);
        car2.setLocation(0, car2.getLocation().y);
        car3.setLocation(0, car3.getLocation().y);
        car4.setLocation(0, car4.getLocation().y);
        car5.setLocation(0, car5.getLocation().y);
        Carrera hilo1 = new Carrera(car1, this);
        Carrera hilo2 = new Carrera(car2, this);
        Carrera hilo3 = new Carrera(car3, this);
        Carrera hilo4 = new Carrera(car4, this);
        Carrera hilo5 = new Carrera(car5, this);
        hilo1.interrupt();
        hilo2.interrupt();
        hilo3.interrupt();
        hilo4.interrupt();
        hilo5.interrupt();
        NextGame.setVisible(false);
        model.setValueAt("", 0, 1);
        model.setValueAt("", 1, 1);
        model.setValueAt("", 2, 1);
        model.setValueAt("", 3, 1);
        model.setValueAt("", 4, 1);
        model.setValueAt("", 0, 3);
        model.setValueAt("", 1, 3);
        model.setValueAt("", 2, 3);
        model.setValueAt("", 3, 3);
        model.setValueAt("", 4, 3);
        model.setValueAt("", 0, 5);
        model.setValueAt("", 1, 5);
        model.setValueAt("", 2, 5);
        model.setValueAt("", 3, 5);
        model.setValueAt("", 4, 5);
        model.setValueAt(150, 0, 4);
        model.setValueAt(150, 1, 4);
        model.setValueAt(150, 2, 4);
        model.setValueAt(150, 3, 4);
        model.setValueAt(150, 4, 4);
        model.setValueAt(0, 0, 2);
        model.setValueAt(0, 1, 2);
        model.setValueAt(0, 2, 2);
        model.setValueAt(0, 3, 2);
        model.setValueAt(0, 4, 2);
        position=1;
        b=0;
        game++;
        if(game >=6){
            NewGAME.setVisible(true);
            Rating.setVisible(true);
        }
        else{
          btiniciar.setVisible(true);
        }
    }//GEN-LAST:event_NextGameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new JFrameCredits().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void NewGAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewGAMEActionPerformed
      for(int j=1;j<=6;j++){
        for(int i=0;i<5;i++){
        model2.setValueAt("", i, j);
        }
        game =1;
      }
      NewGAME.setVisible(false);
      Rating.setVisible(false);
      btiniciar.setVisible(true);
      
        
    }//GEN-LAST:event_NewGAMEActionPerformed

    private void RatingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RatingActionPerformed

        for(int i=0;i<5;i++){
            String a = String.valueOf(model2.getValueAt(i, 6));
            pos[i]= Integer.valueOf(a);
            namepos[i] = String.valueOf(model2.getValueAt(i, 0)); 
          
            
        }
        new JFrameRating(pos,namepos,this).setVisible(true);
         
    }//GEN-LAST:event_RatingActionPerformed

    private void InfoPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InfoPlayerActionPerformed
       new JFrameInfoPlayer().setVisible(true);
    }//GEN-LAST:event_InfoPlayerActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JframeGame().setVisible(true);
            }
        });
    }

    public void Victory(JLabel car) {
        if (car.getLocation().y == getCar1().getLocation().y) {
            model.setValueAt(Position(position), 0, 3);
            model.setValueAt(Score(position), 0, 5);

        } else if (car.getLocation().y == getCar2().getLocation().y) {
            model.setValueAt(Position(position), 1, 3);
            model.setValueAt(Score(position), 1, 5);

        } else if (car.getLocation().y == getCar3().getLocation().y) {
            model.setValueAt(Position(position), 2, 3);
            model.setValueAt(Score(position), 2, 5);
        } else if (car.getLocation().y == getCar4().getLocation().y) {
            model.setValueAt(Position(position), 3, 3);
            model.setValueAt(Score(position), 3, 5);

        } else if (car.getLocation().y == getCar5().getLocation().y) {
            model.setValueAt(Position(position), 4, 3);
            model.setValueAt(Score(position), 4, 5);

        }
        position++;
        b++;
    }

    private String Position(int i) {
        switch (i) {
            case 1:
                return "Primero";
            case 2:
                return "Segundo";
            case 3:
                return "Tercero";
            case 4:
                return "Cuarto";
            case 5:
                return "Quinto";
        }
        return null;
    }

    private int Score(int i) {

        switch (i) {
            case 1:
                return 15;
            case 2:
                return 12;
            case 3:
                return 8;
            case 4:
                return 5;
            case 5:
                return 2;
        }
        return 0;

    }

    private void read() {

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/hilosproject2021/player.json")) {
            ObjectMapper objectMapper = new ObjectMapper();
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray playerlist = (JSONArray) jsonObject.get("player");
            for (int i = 0; i < playerlist.size(); i++) {
                JSONObject jsonObject1 = (JSONObject) playerlist.get(i);
                JSONObject jsonObject2 = (JSONObject) jsonObject1.get("Location");
                pl[i] = new Player(objectMapper.writeValueAsString(jsonObject1.get("name")), i + 1, objectMapper.writeValueAsString(jsonObject1.get("username")), objectMapper.writeValueAsString(jsonObject2.get("coutry")),objectMapper.writeValueAsString(jsonObject2.get("city")),cars[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void readPComplete() {

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/hilosproject2021/PointsComplete.json")) {
            ObjectMapper objectMapper = new ObjectMapper();
            Object obj = jsonParser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray points = (JSONArray) jsonObject.get("pointsComplete");
            for (int i = 0; i < points.size(); i++) {
                JSONObject jsonObject1 = (JSONObject) points.get(i);
                String name = objectMapper.writeValueAsString(jsonObject1.get("points"));
                model.setValueAt(name, i, 4);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void scoreGame(int i, JLabel car) {
        if (car.getLocation().y == getCar1().getLocation().y) {
            a = i;
            upgradeScore(a, 0);
        } else if (car.getLocation().y == getCar2().getLocation().y) {
            a = i;
            upgradeScore(a, 1);
        } else if (car.getLocation().y == getCar3().getLocation().y) {
            a = i;
            upgradeScore(a, 2);
        } else if (car.getLocation().y == getCar4().getLocation().y) {
            a = i;
            upgradeScore(a, 3);
        } else if (car.getLocation().y == getCar5().getLocation().y) {
            a = i;
            upgradeScore(a, 4);
        }
    }

    public void PoComplete(int i, JLabel car) {
        if (car.getLocation().y == getCar1().getLocation().y) {
            a = 150 - i;
            upgradeComplete(a, 0);
        } else if (car.getLocation().y == getCar2().getLocation().y) {
            a = 150 - i;
            upgradeComplete(a, 1);
        } else if (car.getLocation().y == getCar3().getLocation().y) {
            a = 150 - i;
            upgradeComplete(a, 2);
        } else if (car.getLocation().y == getCar4().getLocation().y) {
            a = 150 - i;
            upgradeComplete(a, 3);
        } else if (car.getLocation().y == getCar5().getLocation().y) {
            a = 150 - i;
            upgradeComplete(a, 4);
        }
    }

    public String remplaceCar(String a){
        switch(a){
            case "CamiloC17":
                return "/hilosproject2021/car1.png";
            case "Daniel0730":
                return "/hilosproject2021/car2.png";    
            case "Astrid0416":
                return "/hilosproject2021/car3.png";
            case "xXDiegoXx":
                return "/hilosproject2021/car4.png";
            case "Alejandrina0328":
                return "/hilosproject2021/car5.png";    
        }
        return "null";
    }
    public void upgradeComplete(int i, int b) {
        model.setValueAt(a, b, 4);

    }
    public void upgradeLauc(int i,JLabel car){
         if (car.getLocation().y == getCar1().getLocation().y) {
         model.setValueAt(i, 0, 2);
        } else if (car.getLocation().y == getCar2().getLocation().y) {
         model.setValueAt(i, 1, 2);
        } else if (car.getLocation().y == getCar3().getLocation().y) {
         model.setValueAt(i, 2, 2);
        } else if (car.getLocation().y == getCar4().getLocation().y) {
         model.setValueAt(i, 3, 2);
        } else if (car.getLocation().y == getCar5().getLocation().y) {
         model.setValueAt(i, 4, 2);
        }
    }

    public void upgradeScore(int i, int b) {
        model.setValueAt(a, b, 1);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton InfoPlayer;
    private javax.swing.JButton NewGAME;
    private javax.swing.JButton NextGame;
    private javax.swing.JButton Rating;
    private javax.swing.JTable TableFinalGame;
    private javax.swing.JTable TableGame;
    private javax.swing.JButton btiniciar;
    private javax.swing.JLabel car1;
    private javax.swing.JLabel car2;
    private javax.swing.JLabel car3;
    private javax.swing.JLabel car4;
    private javax.swing.JLabel car5;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_barrera;
    // End of variables declaration//GEN-END:variables

}
