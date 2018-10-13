import java.applet.*;
import java.awt.*; 

/*<applet code="Ball2" width=500 height=500>
</applet>
*/

public class MovingBall extends Applet implements Runnable
{
 private Dimension d;
 private int x,y,ix,iy;
 private Thread thd;
 AudioClip ax,ay,ac;
 
 public void init()
 {
  setBackground(new Color(255,255,180));
  setForeground(Color.red);
  
  d=getSize();
  x=-10;
  y=-10;
  ix=2;
  iy=1;
  
  ax=getAudioClip(getCodeBase(),"drip.au");
     ay=getAudioClip(getCodeBase(),"yahu.au");
  ac=getAudioClip(getCodeBase(),"spac.au");

  //ac.loop();  

  thd=new Thread(this);
  thd.start(); 
 }
 
 public void run()
 {
  
  while(true)
  {
   repaint();
 
   try
   {
    Thread.sleep(10);
   }
   catch(InterruptedException e){}
 
   x=x+ix;
   y=y+iy;
   
   if(x<= 10)
   {
    ax.play();
    ix=2;
   }
   else
   if(x>=d.width-10)
   { 
    ax.play();
    ix=-2;
   }

   if(y<=10)
   {
    ay.play();
    iy=1;
   }
   else
   if(y>=d.height-10)
   { 
    ay.play();
    iy=-1;
   }
  }
 }
 
 public void paint(Graphics g)
 {
  g.fillOval(x-10,y-10,20,20);
 }
}
