/**
 * Clase Racional que permita trabajar con números racionales (fracciones).
 * 
 * Incluir los siguientes métodos: sumar , restar , multiplicar , dividir ,
 * copiar , simplificar y la redefinición de equals y toSring .
 *
 *
 */

public class Racional {

	// Atributos
	private int numerador;
	private int denominador;

	// Constructor
	public Racional(int numerador, int denominador) throws RacionalException {
		this.setNumerador(numerador);
		this.setDenominador(denominador);
	}

	// Métodos setter y getter
	public int getNumerador() {
		return this.numerador;
	}

	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}

	public int getDenominador() {
		return this.denominador;
	}

	public void setDenominador(int denominador) throws RacionalException {

		if (denominador == 0) {
			throw new RacionalException("El denominador no puede ser 0.");
		}

		this.denominador = denominador;
	}

	public String toString() {
		return this.numerador + "/" + this.denominador;
	}


	public boolean equals(Racional otro) {
		boolean resultado = false;

		this.simplificar();
		otro.simplificar();

		if (this.numerador == otro.numerador && this.denominador == otro.denominador) {
			resultado = true;
		}

		return resultado;
	}

	

	

	/**
	 * Método que suma dos objetos Racional
	 * 
	 * @param otro
	 * @return objeto Racional que representa la suma de dos Racional
	 */
	public Racional sumar(Racional otro) {
		int numerador1;
		int numerador2;
		int numeradorTotal;
		int denominadorComun;
		Racional resultado = null;

		denominadorComun = this.denominador * otro.denominador;
		numerador1 = otro.denominador * this.numerador;
		numerador2 = this.denominador * otro.numerador;
		numeradorTotal = numerador1 + numerador2;

		try {
			resultado = new Racional(numeradorTotal, denominadorComun);
			resultado.simplificar();
		} catch (RacionalException e) {
			// Este error nunca va a producirse, porque el denominador no va a
			// poder dar 0
		}

		return resultado;
	}

	/**
	 * Método que resta dos objetos Racional
	 * 
	 * @param otro
	 * @return objeto Racional que representa la resta de dos Racional
	 */
	public Racional restar(Racional otro) {
		int numerador1;
		int numerador2;
		int nuevoNumerador;
		int nuevoDenominador;
		Racional resultado = null;

		numerador1 = otro.denominador * this.numerador;
		numerador2 = this.denominador * otro.numerador;
		nuevoNumerador = numerador1 - numerador2;
		nuevoDenominador = this.denominador * otro.getDenominador();

		try {
			resultado = new Racional(nuevoNumerador, nuevoDenominador);
			resultado.simplificar();
		} catch (RacionalException e) {
			// Este error no se va a producir
		}

		return resultado;
	}

	/**
	 * Método que multiplica dos objetos Racional
	 * 
	 * @param otro
	 * @return objeto Racional que representa la multiplicación de dos Racional
	 */
	public Racional multiplicar(Racional otro) {
		int nuevoNumerador;
		int nuevoDenominador;
		Racional resultado = null;

		nuevoNumerador = this.numerador * otro.getNumerador();
		nuevoDenominador = this.denominador * otro.getDenominador();

		try {
			resultado = new Racional(nuevoNumerador, nuevoDenominador);
			//resultado.simplificar(); //no hace falta
		} catch (RacionalException e) {
			//Este error no se va a producir
			
		}

		return resultado;
	}

	/**
	 * Método que divide dos objetos Racional
	 * 
	 * @param otro
	 * @return objeto Racional que representa la division de dos Racional
	 * @throws RacionalException 
	 */
	public Racional dividir(Racional otro) throws RacionalException {
		int nuevoNumerador;
		int nuevoDenominador;
		Racional resultado = null;

		nuevoNumerador = this.numerador * otro.getDenominador();
		nuevoDenominador = this.denominador * otro.getNumerador();

		//La excepción aqui se lanza porque puede ser que sea división por cero
		resultado = new Racional(nuevoNumerador, nuevoDenominador);
		resultado.simplificar();
		

		return resultado;
	}

	/**
	 * Método que simplifica un Racional. No devuelve nada.
	 * 
	 */
	public void simplificar() {
		int resultadoMcd;

		try {

			resultadoMcd = MisFuncionesMatematicas.mcd(this.numerador, this.denominador);
			this.numerador = this.numerador / resultadoMcd;
			this.denominador = this.denominador / resultadoMcd;

		} catch (MisFuncionesMatematicasException e) {

			// Solo se va a dar si el numerador es 0,
			// en este caso no se simplifica
		}

	}
}
