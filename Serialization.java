package Serialization;
import java.io.*;
//电影类型
enum MovieType implements Serializable{
	Comedy("喜剧片"),
	Action("动作片"),
	Romatic("爱情片"),
	ScienceFiction("科幻片");
	private final String name;
	MovieType(String name){
		this.name = name;
	}
	public String get(){
		return name;
	}
	
}
//电影
class Movie implements Serializable{
	String name;
	MovieType type;
	String where;
	Movie(String where,String name,MovieType a){
		this.name = name;
		this.where = where;
		this.type = a;
	}
	void printinfo(){
		System.out.print(this.name+"\n"+"类型："+this.type.get()+"\n"+"放映厅："+this.where+"\n");
	}
}
//电影放映时间段
class MovieSchedule implements Serializable{
	String time;
	String date;
	MovieSchedule(String date,String time){
		this.time = time;
		this.date = date;
	}
	void printinfo(){
		System.out.print("时间："+this.date+" "+this.time+"\n");
	}
}
//座位
class Seat implements Serializable{
	int row;
	int col;
	Seat(int a,int b){
		this.row = a;
		this.col = b;
	}
	void printinfo(){
		System.out.print("座位："+this.row+"行"+this.col+"座\n");
	}
}
//电影票
class Ticket implements Serializable{
	Movie a;
	MovieSchedule b;
	Seat c;
	Ticket(Movie get,MovieSchedule time,Seat seat){
		this.a = get;
		this.b = time;
		this.c = seat;
	}
	public void printTicket(){ //打印票的详细信息
		a.printinfo();
		b.printinfo();
		c.printinfo();
	}
}
public class Serialization {
	public static void main (String[] args) {
		Seat seat1 = new Seat(10,12);
		MovieSchedule time1 = new MovieSchedule("2010年7月12日","20时20分");
		Movie get1 = new Movie("放映厅1","疯狂的石头",MovieType.Comedy);
		Ticket one = new Ticket(get1,time1,seat1);
		
		Seat seat2 = new Seat(10,13);
		MovieSchedule time2 = new MovieSchedule("2010年7月12日","20时20分");
		Movie get2 = new Movie("放映厅1","疯狂的石头",MovieType.Comedy);
		Ticket two = new Ticket(get2,time2,seat2);
		
		Seat seat3 = new Seat(8,8);
		MovieSchedule time3 = new MovieSchedule("2010年7月14日","19时40分");
		Movie get3 = new Movie("放映厅2","2012",MovieType.ScienceFiction);
		Ticket three = new Ticket(get3,time3,seat3);
		
		Seat seat4 = new Seat(8,9);
		MovieSchedule time4 = new MovieSchedule("2010年7月14日","19时40分");
		Movie get4 = new Movie("放映厅2","2012",MovieType.ScienceFiction);
		Ticket four = new Ticket(get4,time4,seat4);
		
		one.printTicket();
		two.printTicket();
		three.printTicket();
		four.printTicket();
		try{
			FileOutputStream fs = new FileOutputStream("foo.ser");  
			ObjectOutputStream os = new ObjectOutputStream(fs);  
			os.writeObject(one);
			os.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		try{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("foo.ser"));
			Ticket getit = (Ticket) in.readObject();
			getit.printTicket();
			in.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		
	}
}
