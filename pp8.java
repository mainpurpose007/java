public class pp8 extends Thread {
    String str;
    int n;

    pp8(String str, int n) {
        this.str = str;
        this.n = n;
    }
    
    public void run() {
        try {
            for (int i = 0; i < n; i++) {
                System.out.println(getName() + " : " + str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        pp8 t1 = new pp8("COVID19", 10);
        pp8 t2 = new pp8("LOCKDOWN2020", 20);
        pp8 t3 = new pp8("VACCINATED", 30);

        t1.start();
        t2.start();
        t3.start();

    }
}



program 2


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form action="Slip30.jsp" method="post">
Enter Number :
<input type="text" name="num">
<input type="submit" value="Submit">
</form>
</body>
</html>

JSP FILE :Slip30.jsp


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
int n = Integer.parseInt(request.getParameter("num"));
intnum,i,count;
for(num=1;num<=n;num++)
{
count=0;
for(i=2;i<=num/2;i++)
{
if(num%i==0)
{
count++;
break;
}
}
if(count==0 &&num!=1)
{
%>
<html>
<body>
<font size ="14" color="red"><%out.println("\t"+num);%>
</body>
</html>
<%
}
}
%>