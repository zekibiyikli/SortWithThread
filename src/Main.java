import java.lang.reflect.Array;
import java.util.*;

class thread1 implements Runnable{
	public void sirala(ArrayList array){
		Collections.sort(array);
	}
	@Override
	public void run(){
		sirala(Main.sol);
		sirala(Main.sol2);
	}
}

class thread2 implements Runnable{
	public void sirala(ArrayList array){
		Collections.sort(array);
	}
	@Override
	public void run(){
		sirala(Main.sag);
		sirala(Main.sag2);
	}
}

class Birlestir implements Runnable{
	public ArrayList sirala(ArrayList array){
		
		Collections.sort(array);
		
		System.out.print("Sýralanmýþ hali: ");
		for(int i=0;i<array.size();i++){
			System.out.print(array.get(i)+"-");
		}
		System.out.println();
		return array;
	}
	public ArrayList birlestir(ArrayList arraysol,ArrayList arraysag){
		ArrayList sonuc=new ArrayList();
		
		int son=arraysol.size()+arraysag.size();
		int middle=son/2;
		int sagsize=arraysag.size();
		int solsize=arraysol.size();
		
		for(int i=0;i<solsize;i++){
			sonuc.add(arraysol.get(i));
		}
		for(int i=0;i<sagsize;i++){
			sonuc.add(arraysag.get(i));
		}
		return sonuc;
	}
	public void tersle(ArrayList array){
		Collections.reverse(array);
		System.out.print("Terslenmiþ hali: ");
		for(int i=0;i<array.size();i++){
			System.out.print(array.get(i)+"-");
		}
		System.out.println(" ");
	}
	@Override
	public void run(){
		ArrayList sonuc=new ArrayList();
		ArrayList sonuc2=new ArrayList();

		sonuc=birlestir(Main.sol,Main.sag);
		sonuc=sirala(sonuc);
		tersle(sonuc);
		sonuc2=birlestir(Main.sol2,Main.sag2);
		sonuc2=sirala(sonuc2);
		tersle(sonuc2);
	}
}


public class Main {
	static ArrayList sol=new ArrayList();
	static ArrayList sag=new ArrayList();
	static ArrayList sol2=new ArrayList();
	static ArrayList sag2=new ArrayList();
	
	public static void main(String[] args) {
	ArrayList array=new ArrayList(Arrays.asList(7,12,19,3,18,4,2,6,15,8));
	ArrayList array2=new ArrayList(Arrays.asList("R","H","Ü","S","E","O","A"));

	int middle = array.size()/2;
	int middle2=array2.size()/2;
	
	for(int i = 0; i < middle; i++) {
		sol.add(array.get(i));//sol tarafta kalanlarý sol dizisine attým
	}

	for(int j = middle; j < array.size(); j++) {
		sag.add(array.get(j));//sað tarafta kalanlarý sað dizisine attým
	}
	for(int i = 0; i < middle2; i++) {
		sol2.add(array2.get(i));//sol tarafta kalanlarý sol dizisine attým
	}

	for(int j = middle2; j < array2.size(); j++) {
		sag2.add(array2.get(j));//sað tarafta kalanlarý sað dizisine attým
	}
	
	thread1 sol2=new thread1();
	sol2.run();
	thread2 sag2=new thread2();
	sag2.run();
	Birlestir birlestir=new Birlestir();
	birlestir.run();
	
	
	}
	
}
