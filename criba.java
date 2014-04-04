package tp03.ejercicio4;
import tp03.ejercicio1.*;

public class CribaDeEratostenes {
	
	private boolean noEsPrimo(int num, int div){
		return(num % div ==0);
	}
	
	public ListaDeEnteros obtenerPrimos(ListaDeEnteros list){
		int numN = (int) Math.sqrt(list.tamanio()); //tengo que usar un double o puedo castear?
		int contador = 2;
		int actual;
		//list.comenzar();
		int pos;
		while (contador <= numN){ //tiene que ser la raiz cuadrada de numN
			list.comenzar();
			pos = 1;
			while (!list.fin()){
				actual = list.proximo();
				if(actual != contador && noEsPrimo(actual,contador))
					list.eliminarEn(pos);
				else
					pos++;
			}
			list.comenzar();
			pos = 1;
			while(!list.fin() && list.proximo() <= contador)
				pos++;
			
			contador = list.elemento(pos);
			
		}
		return list;
	}
	
	public ListaDeEnteros generarLista(){
		ListaDeEnterosEnlazada list = new ListaDeEnterosEnlazada();
		for (int i=1; i<=1000; i++){
			list.agregarFinal(i);
		}
		return list;
	}
	
	public void mostrarList(ListaDeEnteros list){
		list.comenzar();
		while(!list.fin()){
			System.out.println(list.proximo());
		}
	}
	
	public static void main(String[] args) {
		CribaDeEratostenes cri = new CribaDeEratostenes();
		ListaDeEnteros l1 = new ListaDeEnterosEnlazada();
		
		l1 = cri.generarLista();
		l1 = cri.obtenerPrimos(l1);
		cri.mostrarList(l1);
		while(!l1.fin()){
			System.out.println(l1.proximo());
		}
		
		
	}

}
