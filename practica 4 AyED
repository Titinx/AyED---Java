package arbolBinario;

import tp03.ejercicio6.ListaEnlazadaGenerica;
import tp03.ejercicio6.ListaGenerica;
import nodoBinario.NodoBinario;

public class ArbolBinario<T> {

	private NodoBinario<T> raiz;
	
	public ArbolBinario(){		
		this.raiz = null;
	}
	
	public ArbolBinario(T dato){		
		this.raiz = new NodoBinario<T>(dato);
	}	
	
	private ArbolBinario(NodoBinario<T> nodo){		
		this.raiz = nodo;
	}
	
	private NodoBinario<T> getRaiz(){		
		return raiz;
	}
	
	public T getDatoRaiz(){
		if (this.getRaiz() != null){
			return this.getRaiz().getDato();
		}else{
			return null;
		}
	}
	
	public ArbolBinario<T> getHijoIzquierdo(){		
		return new ArbolBinario<T>(this.raiz.getHijoIzquierdo());
	}
	
	public ArbolBinario<T> getHijoDerecho(){		
		return new ArbolBinario<T>(this.raiz.getHijoDerecho());
	}	
	
	public void agregarHijoIzquierdo(ArbolBinario<T> hijo){		
		this.raiz.setHijoIzquierdo(hijo.getRaiz());
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo){		
		this.raiz.setHijoDerecho(hijo.getRaiz());
	}	
	
	public void eliminarHijoIzquierdo(){		
		this.raiz.setHijoIzquierdo(null);
	}
	
	public void eliminarHijoDerecho(){		
		this.raiz.setHijoDerecho(null);
	}	
	private boolean esHoja(){
		return (this.getHijoIzquierdo().getRaiz()==null) && (this.getHijoDerecho().getRaiz()==null);
	}
	
	
	private void ObtenerFrontera(ListaEnlazadaGenerica<T> list){
		if(this.raiz != null){
			if(this.esHoja()){
				list.agregarFinal(this.getDatoRaiz());
			}else{
				if(this.getHijoIzquierdo().getRaiz() != null){
					this.getHijoIzquierdo().ObtenerFrontera(list);
				}
				if(this.getHijoDerecho().getRaiz() != null){
					this.getHijoDerecho().ObtenerFrontera(list);
				}
			}
		}
		
	}
	
	public ListaGenerica<T> frontera() {
		ListaEnlazadaGenerica<T> list = null;
		if (this.raiz == null)
			return null;
		else{
			this.ObtenerFrontera(list);
			return list;
		}
	}
	
	@Override
	public boolean equals(Object o){ // me fijo que sean iguales en los datos y estructuralmente.
		if(o != null && o instanceof ArbolBinario){
			ArbolBinario<T> ar = (ArbolBinario<T>) o;
			if(this.raiz == null && ar.getRaiz() == null){ //a pesar de estar vacios, son estructuralmente iguales.
				return true;
			}else{
				if(this.raiz != null && ar.getRaiz() != null){ 
					return (this.getDatoRaiz().equals(ar.getDatoRaiz()) &&
							this.getHijoIzquierdo().equals(ar.getHijoIzquierdo()) &&
							this.getHijoDerecho().equals(ar.getHijoDerecho()));
				}else{
					return false;
				}
			} // else de (this.raiz == null && ar.getRaiz() == null)
		}else{
			return false;
		}
	}
	
	public boolean esMenor(ArbolBinario<T> unArbol){  //Este metodo solo se podra usar si el tipo <T> pertenece o es instancia de los Integer
		if(this.raiz != null && unArbol.getRaiz() != null && this.getDatoRaiz() instanceof Integer){
			if((Integer) this.getDatoRaiz() < (Integer) unArbol.getDatoRaiz()){  
				return true; //se cumple la primera condicion para que sea menor: a<b;
			}else{
				if(this.equals(unArbol)){
					if(this.getHijoIzquierdo().esMenor(unArbol.getHijoIzquierdo())){ 
						return true; // se cumple la segunda condicion para que sea menor: a=b y Ai < Bi;
					}else{
						if(this.getHijoIzquierdo().equals(unArbol.getHijoIzquierdo())){
							if(this.getHijoDerecho().esMenor(unArbol.getHijoDerecho())){
								return true; // se cumple la tercera condicion para que sea menor a=b y Ai = Bi y Ad < Bd;
							}else{
								return false;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	/*@Override
	public boolean equals(Object o){// solamente comparo el dato raiz
		if(o != null && o instanceof ArbolBinario){
			ArbolBinario<T> ar = (ArbolBinario<T>) o;
			if(this.raiz != null && ar.getRaiz() != null){
				return (this.getDatoRaiz().equals(ar.getDatoRaiz()));
			}else{
				return false;
			}
		}else{
			return false;
		}
		
	}
	
	public boolean esMenor(ArbolBinario<T> unArbol) {
		if(this.raiz == null && unArbol.getRaiz() == null){
			return true;
		}else{
			if(this.equals(unArbol)){
				if (!this.getHijoIzquierdo().esMenor(unArbol.getHijoDerecho()))
					return false;
				if (!this.getHijoDerecho().esMenor(unArbol.getHijoDerecho()))
					return false;
				return true;
				
			}else
				return false;
		}
	}
*/	
	private boolean esLleno(){
		return (this.getHijoIzquierdo() != null && this.getHijoDerecho() != null);
	}

	private boolean analizarLLeno(int nivel, ListaEnlazadaGenerica<Integer> list){
		if(this.esLleno()){
			return (this.getHijoIzquierdo().analizarLLeno(nivel + 1, list) && this.getHijoDerecho().analizarLLeno(nivel + 1, list));
		}else {
			if (this.esHoja()){
				list.agregarFinal(nivel);
				return true;
			}
		}
		return false;
	}

	public boolean lleno(){
		if(this.raiz != null){
			ListaEnlazadaGenerica<Integer> list = new ListaEnlazadaGenerica<Integer>();
			boolean ok = analizarLLeno(0, list);
			if (ok){
				Integer act,ant;
				list.comenzar();
				ant = list.proximo();
				while (!list.fin() && ok){
					act = list.proximo();
					ok = (ant.equals(act));
					ant = act;
				}
				return ok;
			}else{
				return false;
			}	
		}else
			return false; //si la raiz es null no es lleno, ya que no tiene nada.
		
	}
	
	private int nivelIzquierdo(int nivel){
		if(this.getHijoIzquierdo() != null){
			nivelIzquierdo(nivel + 1);
		}else{
			return nivel;
		}
		return nivel;
	}
	
	public boolean completo(){
		if(this.raiz != null){
			ListaEnlazadaGenerica<Integer> list = new ListaEnlazadaGenerica<Integer>();
			analizarLLeno(0, list);
			if(!list.esVacia()){
				boolean ok;
				Integer act,ant,nivelH;
				nivelH = this.nivelIzquierdo(0);
				list.comenzar();
				ant = list.proximo();
				ok = (ant == nivelH || ant == (nivelH - 1));
				while (!list.fin() && ok){
					act = list.proximo();
					ok = (act == ant | (ant-1) == act);
					ant = act;
				}
				return ok;
			}else{
				return false;
			}
		}
		return false;
	}
	
	--------------------------------------------------------------------------------------

metodos privados para el ejercicio 3 de la practica 4:

private int min(int m1, int m2, int m3){
	if(m1 <= m2 && m1 <=m3)
		return m1;
	else{
		if(m2 <= m3)
			return m2;
		else
			return m3;
	}
}


private int max (int m1, int m2, int m3){
	if ( m1 >= m2 && m1>=m3)
		return m1;
	else{
		if(m2 <= m3)
			return m2;
		else
			return m3;
	}
}


private int obtenerMin(){
	if (esLleno){
		min (this.getDatoRaiz(), this.getHijoIzquierdo().obtenerMin, this.getHijoDerecho().obtenerMin());
	}else{
		if(esHoja)
			return this.getDatoRaiz();
		else{
			if(this.getHijoIzquierdo() != null && this.getHijoDerecho() = null){
				if(this.getDatoRaiz() <= this.getHijoIzquierdo().getDatoRaiz)
					return this.getDatoRaiz();
				else
					return this.getHijoIzquierdo().getDatoRaiz;
			}
			else
				if(this.getDatoRaiz() <= this.getHijoDerecho().getDatoRaiz;
					return this.getDatoRaiz();
				else
					return this.getHijoDerecho().getDatoRaiz;
		}
	}

}

private int obtenerMax(){
	if (esLleno){
		max (this.getDatoRaiz(), this.getHijoIzquierdo().obtenerMin, this.getHijoDerecho().obtenerMin());
	}else{
		if(esHoja)
			return this.getDatoRaiz();
		else{
			if(this.getHijoIzquierdo() != null && this.getHijoDerecho() = null){
				if(this.getDatoRaiz() => this.getHijoIzquierdo().getDatoRaiz)
					return this.getDatoRaiz();
				else
					return this.getHijoIzquierdo().getDatoRaiz;
			}
			else
				if(this.getDatoRaiz() => this.getHijoDerecho().getDatoRaiz;
					return this.getDatoRaiz();
				else
					return this.getHijoDerecho().getDatoRaiz;
		}
	}

}
	
	
}
