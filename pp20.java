<html>
<body>
<form method=get action="NumberWord.jsp">
Enter Any Number : <input type=text name=num><br><br>
<input type=submit value="Display">
</form>
<body>
</html>

NumberWord.jsp

<html>
<body>
<font color=red>
<%! int i,n;
       String s1;
%>
<%    s1=request.getParameter("num");
         n=s1.length();
         i=0;
         do
         {
           char ch=s1.charAt(i);
           switch(ch)
            {
                case '0': out.println("Zero  ");break;
                case '1': out.println("One  ");break;
                case '2': out.println("Two  ");break;
                case '3': out.println("Three  ");break;
                case '4': out.println("Four ");break;
                case '5': out.println("Five  ");break;
               case '6': out.println("Six  ");break;
               case '7': out.println("Seven  ");break;
               case '8': out.println("Eight  ");break;
               case '9': out.println("Nine  ");break;
           }
           i++;
         }while(i<n);
%>
</font>
</body>
</html>



program 2



import java.awt.*;
import java.applet.*;
/* <APPLET     code= "flag.class"  width= "500" height= "300">
     </APPLET> */
public class flag extends Applet implements Runnable
{
            Thread t;
            int x1,x2,x3,y3,x4,y4,x5,ln;
            public void init()
            {
                        t=new Thread(this);
                        t.start();
                        ln=1;
            }
            public void run()
            {
            try{      if(ln==1) {         for(x1=200;x1>100;)
                                               {
                                                       t.sleep(200);
                                                       repaint();
                                                }
                                       }
                        ln=2;
                        if(ln==2) {        for(x2=100;x2<150;)
                                                {
                                                          t.sleep(200);
                                                          repaint();
                                                }
                                      }
                        ln=3;
                        if(ln==3) {       for(x3=150,y3=100;x3>125&&y3<125;)
                                               {
                                                      t.sleep(200);
                                                      repaint();
                                              }
                                          }
                        ln=4;
                        if(ln==4) {     for(x4=125,y4=125;x4<150&&y4<150;)
                                            {
                                                t.sleep(200);
                                                repaint();
                                            }
                                       }
                        ln=5;
                        if(ln==5)  {     for(x5=150;x5>100;)
                                             {
                                                t.sleep(200);
                                                repaint();
                                              }
                                        }
                        ln=1;
            }catch(Exception e){
                                                      System.out.println(e);
                                             }
            run();  
            }
            public void paint(Graphics g)
            {
                        if(ln==1&&x1>100)
                        {
                                    g.drawLine(100,200,100,x1-=5);
                        }
                        if(ln==2&&x2<150)
                        {
                                    g.drawLine(100,200,100,100);
                                    g.drawLine(100,100,x2+=5,100);
                        }
                        if(ln==3&&x3>125&&y3<125)
                        {
                                    g.drawLine(100,200,100,100);
                                    g.drawLine(100,100,150,100);
                                    g.drawLine(150,100,x3-=5,y3+=5);
                        }
                        if(ln==4&&x4<150&&y4<150)
                        {
                                    g.drawLine(100,200,100,100);
                                    g.drawLine(100,100,150,100);
                                    g.drawLine(150,100,125,125);
                                    g.drawLine(125,125,x4+=5,y4+=5);
                        }
                        if(ln==5&&x5>100)
                        {
                                    g.drawLine(100,200,100,100);
                                    g.drawLine(100,100,150,100);
                                    g.drawLine(150,100,125,125);
                                    g.drawLine(125,125,150,150);
                                    g.drawLine(150,150,x5-=5,150);
                        }                      
            }
}